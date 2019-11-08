package com.cimc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Nginx负载均衡测试
 *
 * @author chenz
 * @create 2019-10-24 9:02
 */
@RestController
public class NginxTestController {

    @Autowired
    private Environment environment;

    @RequestMapping("getPort")
    public String getPort(){
        return "我的端口号为: " + environment.getProperty("local.server.port");
    }

}
