package com.cimc.entity;

import lombok.Data;
import java.util.Date;

/**
 * @author chenz
 * @create 2019-09-12 16:55
 */
@Data
public class User {
    private Long id;

    private String name;

    private String phone;

    private Integer age;

    private Date createTime;
}
