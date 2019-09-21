package com.cimc.test;

import com.cimc.dao.UserDao;
import com.cimc.entity.User;
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
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void insertTest() {
        User user = new User();
        user.setName("James");
        user.setAge(35);
        user.setPhone("15161175930");
        user.setCreateTime(new Date());
        userDao.insert(user);
    }

    @Test
    public void getAllTest() {
        List<User> userList = userDao.getAll();
        System.out.println(userList);
    }

    @Test
    public void findByIdTest() {
        User user = userDao.findById(1L);
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
        userDao.update(user);
    }

    @Test
    public void deleteTest() {
        userDao.delete(1L);
    }
}
