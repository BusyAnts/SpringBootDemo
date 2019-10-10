package com.cimc.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 用户详情表
 *
 * @author chenz
 * @create 2019-10-10 10:29
 */
@Entity
@Table(name = "t_user_detail")
@Data
public class UserDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String hobby;
    private String address;

}
