package com.cimc.service.test;

import com.cimc.entity.User;
import com.cimc.entity.UserParam;
import com.cimc.service.UserService;
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

/**
 * @author chenz
 * @create 2019-09-22 10:06
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void save() {
        User user = new User();
        user.setName("gub");
        user.setAge(20);
        user.setBirthday(new Date());
        userService.save(user);
    }

    @Test
    public void findByConditionTest() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(0, 5, sort);
        UserParam userParam = new UserParam();
        userParam.setName("gub");
        userParam.setMinAge(10);
        userParam.setMaxAge(30);
        Page<User> userPage = userService.findByCondition(userParam, pageable);
        System.out.println(userPage.getContent());
    }

}
