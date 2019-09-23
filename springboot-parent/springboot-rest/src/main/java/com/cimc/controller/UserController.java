package com.cimc.controller;

import com.cimc.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author chenz
 * @create 2019-09-09 11:25
 */
@RestController
@RequestMapping("/")
public class UserController {

    /**
     * 分页获取用户信息
     *
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/users")
    public List<User> list(@RequestParam(value = "page", defaultValue = "1") String page, @RequestParam(value = "size", defaultValue = "10") String size) {
        System.out.println("page: " + page);
        System.out.println("size: " + size);
        User user = new User();
        user.setId(1L);
        user.setName("James");
        user.setAge(35);
        user.setBirthday(new Date());

        User user2 = new User();
        user2.setId(2L);
        user2.setName("Kobe");
        user2.setAge(40);
        user2.setBirthday(new Date());

        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user2);
        return userList;
    }


    /**
     * 根据id获取用户信息
     *
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    public User get(@PathVariable("id") Long id) {
        User user = new User();
        user.setId(id);
        user.setName("James");
        user.setAge(35);
        user.setBirthday(new Date());
        return user;
    }

    /**
     * 新建用户
     *
     * @param user
     * @return
     */
    @PostMapping("/user")
    public User create(@RequestBody User user) {
        return user;
    }

    /**
     * 更新
     *
     * @param user
     * @return
     */
    @PutMapping("/user")
    public User update(@RequestBody User user) {
        return user;
    }

    /**
     * 更新用户name字段
     *
     * @param user
     * @return
     */
    @PatchMapping("/user/name")
    public User patch(User user) {
        return user;
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/user/{id}")
    public User delete(@PathVariable("id") Long id) {
        User user = new User();
        user.setId(id);
        return user;
    }

    /**
     * 获取请求头里的信息
     *
     * @param access_token
     * @return
     */
    @GetMapping("/user/header")
    public Map<String, Object> header(@RequestHeader("access_token") String access_token) {
        Map<String, Object> map = new HashMap<>();
        map.put("access_token", access_token);
        return map;
    }

}
