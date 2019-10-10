package com.cimc.repository.test;

import com.cimc.entity.User;
import com.cimc.repository.test1.UserTest1Repository;
import com.cimc.repository.test2.UserTest2Repository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author chenz
 * @create 2019-10-10 16:18
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

    @Autowired
    private UserTest1Repository userTest1Repository;

    @Autowired
    private UserTest2Repository userTest2Repository;

    @Test
    public void saveTest() {
        User user = new User();
        user.setName("gub4");
        user.setAge(21);
        user.setBirthday(new Date());
        userTest1Repository.save(user);
        userTest2Repository.save(user);
    }

}
