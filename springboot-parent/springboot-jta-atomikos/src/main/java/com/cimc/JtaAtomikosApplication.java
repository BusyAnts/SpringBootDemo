package com.cimc;

import com.cimc.config.DBConfigOne;
import com.cimc.config.DBConfigTwo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author chenz
 * @create 2019-09-22 18:34
 */
@SpringBootApplication
@EnableConfigurationProperties(value = {DBConfigOne.class, DBConfigTwo.class})
public class JtaAtomikosApplication {

    public static void main(String[] args) {
        SpringApplication.run(JtaAtomikosApplication.class, args);
    }
}
