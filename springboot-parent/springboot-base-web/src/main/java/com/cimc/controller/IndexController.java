package com.cimc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenz
 * @create 2019-09-23 10:20
 */
@RestController
public class IndexController {

    @GetMapping("/index")
    public String index() {
        System.out.println("index");
        return "index";
    }

}
