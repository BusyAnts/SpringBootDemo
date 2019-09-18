package com.cimc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenz
 * @create 2019-09-18 22:06
 */
@RestController
@RequestMapping("user")
public class UserController {

    @GetMapping("login")
    public String login(String username, String password) {
        System.out.println("username:" + username + ",password:" + password);
        return "success";
    }

}
