package com.cimc.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 用户信息表
 *
 * @author chenz
 */
@Entity
@Table(name = "t_user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
    private Date birthday;
}
