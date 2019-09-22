package com.cimc.mapper.test;

import com.cimc.entity.User;
import com.cimc.one.mapper.UserMapperOne;
import com.cimc.two.mapper.UserMapperTwo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * @author chenz
 * @create 2019-09-22 15:18
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {

    @Autowired
    private UserMapperOne userMapperOne;

    @Autowired
    private UserMapperTwo userMapperTwo;

    @Test
    public void testInsertOne() {
        User user = new User();
        user.setName("James");
        user.setAge(35);
        user.setPhone("15161175930");
        user.setCreateTime(new Date());
        userMapperOne.insert(user);
        System.out.println("自增主键为: " + user.getId());
    }

    @Test
    public void testGetAllOne() {
        List<User> userList = userMapperOne.getAll();
        System.out.println(userList);
    }

    @Test
    public void testFindByIdOne() {
        User user = userMapperOne.findById(1L);
        System.out.println(user);
    }

    @Test
    public void testUpdateOne() {
        User user = new User();
        user.setId(1L);
        user.setName("kobe");
        user.setAge(39);
        user.setPhone("15161175939");
        user.setCreateTime(new Date());
        userMapperOne.update(user);
    }

    @Test
    public void testDeleteOne() {
        userMapperOne.delete(1L);
    }

    @Test
    public void testInsertTwo() {
        User user = new User();
        user.setName("James");
        user.setAge(35);
        user.setPhone("15161175930");
        user.setCreateTime(new Date());
        userMapperTwo.insert(user);
        System.out.println("自增主键为: " + user.getId());
    }

    @Test
    public void testGetAllTwo() {
        List<User> userList = userMapperTwo.getAll();
        System.out.println(userList);
    }

    @Test
    public void testFindByIdTwo() {
        User user = userMapperTwo.findById(1L);
        System.out.println(user);
    }

    @Test
    public void testUpdateTwo() {
        User user = new User();
        user.setId(1L);
        user.setName("kobe");
        user.setAge(39);
        user.setPhone("15161175939");
        user.setCreateTime(new Date());
        userMapperTwo.update(user);
    }

    @Test
    public void testDeleteTwo() {
        userMapperTwo.delete(1L);
    }
}
