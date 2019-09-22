package com.cimc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author chenz
 * @create 2019-09-22 18:38
 */
@ConfigurationProperties(prefix = "mysql.datasource.one")
@Data
public class DBConfigOne {
    private String url;
    private String username;
    private String password;
    private int minPoolSize;
    private int maxPoolSize;
    private int maxLifetime;
    private int borrowConnectionTimeout;
    private int loginTimeout;
    private int maintenanceInterval;
    private int maxIdleTime;
    private String testQuery;
}
