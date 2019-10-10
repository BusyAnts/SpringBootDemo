package com.cimc.dao.test;

import com.cimc.dao.UserRepository;
import com.cimc.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * @author chenz
 * @create 2019-09-21 21:28
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void saveTest() {
        User user = new User();
        user.setName("gub2");
        user.setAge(21);
        user.setBirthday(new Date());
        userRepository.save(user);
    }

    @Test
    public void findAllUserTest() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(0, 5, sort);
        Page<User> users = userRepository.findAllUser(pageable);
        System.out.println(users.getContent());
    }

    @Test
    public void findByNameTest() {
        Pageable pageable = PageRequest.of(0, 5);
        Page<User> users = userRepository.findByName("gub", pageable);
        System.out.println(users.getContent());
    }

    @Test
    public void findByNameTest2() {
        Pageable pageable = PageRequest.of(0, 5);
        Page<User> users = userRepository.findByName2("gub", pageable);
        System.out.println(users.getContent());
    }

    @Test
    public void modifyByIdTest() {
        int res = userRepository.modifyById("mxd", 1L);
        System.out.println(res);
    }

    @Test
    public void findByNameTest3() {
        List<User> users = userRepository.findByName("gub");
        System.out.println(users);
    }

    @Test
    public void findByAgeTest3() {
        List<User> users = userRepository.findByAge(20);
        System.out.println(users);
    }

    @Test
    public void findFirstByOrderByNameAscTest() {
        User user = userRepository.findFirstByOrderByNameAsc();
        System.out.println(user);
    }

    @Test
    public void findTopByOrderByAgeDescTest() {
        User user = userRepository.findTopByOrderByAgeDesc();
        System.out.println(user);
    }

    @Test
    public void queryFirst10ByNameTest() {
        Pageable pageable = PageRequest.of(0, 5);
        Page<User> users = userRepository.queryFirst10ByName("gub", pageable);
        System.out.println(users.getContent());
    }

    @Test
    public void findFirst10ByNameTest() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        List<User> users = userRepository.findFirst10ByName("gub", sort);
        System.out.println(users);
    }

    @Test
    public void findTop10ByNameTest() {
        Pageable pageable = PageRequest.of(0, 5);
        List<User> users = userRepository.findTop10ByName("gub", pageable);
        System.out.println(users);
    }


}
