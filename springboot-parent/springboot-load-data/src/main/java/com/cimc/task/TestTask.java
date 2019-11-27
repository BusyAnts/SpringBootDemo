package com.cimc.task;

import org.springframework.stereotype.Component;

/**
 * @author chenz
 * @create 2019-11-27 22:13
 */
@Component
public class TestTask {

    //@Scheduled(cron = "*/1 * * * * *")
    public void sayHello() {
        System.out.println("HelloWorld");
    }

}
