package com.cimc.mapper.test;

import com.cimc.entity.User;
import com.cimc.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * @author chenz
 * @create 2019-09-16 10:35
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void insertTest() {
        User user = new User();
        user.setName("James");
        user.setAge(35);
        user.setPhone("15161175930");
        user.setCreateTime(new Date());
        userMapper.insert(user);
        System.out.println("自增主键为: " + user.getId());
    }

    @Test
    public void getAllTest() {
        List<User> userList = userMapper.getAll();
        System.out.println(userList);
    }

    @Test
    public void findByIdTest() {
        User user = userMapper.findById(1L);
        System.out.println(user);
    }

    @Test
    public void updateTest() {
        User user = new User();
        user.setId(1L);
        user.setName("kobe");
        user.setAge(39);
        user.setPhone("15161175939");
        user.setCreateTime(new Date());
        userMapper.update(user);
    }

    @Test
    public void deleteTest() {
        userMapper.delete(1L);
    }
}
