package com.cimc.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author chenz
 * @create 2019-09-09 11:23
 */
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private Date birthday;
}
