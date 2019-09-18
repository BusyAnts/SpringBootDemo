package com.cimc.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenz
 * @create 2019-09-18 11:29
 */
@RestController
@RequestMapping("/logback")
@Slf4j
public class LogBackController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("log")
    public Object testLog() {
        logger.debug("this is debug level");
        logger.info("this is info level ");
        logger.warn("this is warn level ");
        logger.error("this is error level");
        log.debug("this is debug level");
        log.info("this is info level ");
        log.warn("this is warn level ");
        log.error("this is error level");

        String name = "lbj";
        String password = "123456";
        log.info("name=" + name + ",password=" + password);
        // 使用占位符 推荐使用
        log.info("name={},password={}", name, password);

        return "Success";
    }

}
