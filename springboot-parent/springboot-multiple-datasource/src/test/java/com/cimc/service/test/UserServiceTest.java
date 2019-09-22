package com.cimc.service.test;

import com.cimc.entity.User;
import com.cimc.one.service.UserServiceOne;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author chenz
 * @create 2019-09-22 17:12
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Autowired
    private UserServiceOne userServiceOne;

    @Test
    public void insert() {
        User user = new User();
        user.setName("James");
        user.setAge(35);
        user.setPhone("15161175930");
        user.setCreateTime(new Date());
        userServiceOne.insert(user);
    }

}
