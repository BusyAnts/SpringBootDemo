package com.cimc.dao.test;

import com.cimc.dao.UserRepository;
import com.cimc.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

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
        user.setName("gub");
        user.setAge(20);
        user.setBirthday(new Date());
        userRepository.save(user);
    }


}
