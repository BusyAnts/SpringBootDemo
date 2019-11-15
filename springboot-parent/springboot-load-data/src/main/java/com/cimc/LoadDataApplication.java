package com.cimc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author chenz
 * @create 2019-11-08 15:24
 */
@SpringBootApplication
@MapperScan(basePackages = "com.cimc.mapper")
public class LoadDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoadDataApplication.class, args);

    }
}
