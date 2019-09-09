package com.cimc.controller;

import com.cimc.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenz
 * @create 2019-09-09 11:25
 */
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 根据id获取用户信息
     *
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public User get(@PathVariable("id") Integer id, @RequestParam(value = "page", defaultValue = "1") String page) {
        System.out.println(page);
        User user = new User();
        user.setId(id);
        user.setName("James");
        user.setAge(35);
        user.setBirthday(new Date());
        return user;
    }

    /**
     * 保存
     *
     * @param user
     * @return
     */
    @PostMapping("/save")
    public User save(@RequestBody User user) {
        return user;
    }

    /**
     * 更新
     *
     * @param user
     * @return
     */
    @PutMapping("/update/{id}")
    public User update(@PathVariable("id") Integer id, @RequestBody User user) {
        User resUser = new User();
        resUser = user;
        resUser.setId(id);
        return resUser;
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public User delete(@PathVariable("id") Integer id) {
        User user = new User();
        user.setId(id);
        return user;
    }

    /**
     * 获取请求头里的信息
     * @param access_token
     * @return
     */
    @GetMapping("/getHeader")
    public Map<String, Object> getHeader(@RequestHeader("access_token") String access_token) {
        Map<String, Object> map = new HashMap<>();
        map.put("access_token", access_token);
        return map;
    }

}
