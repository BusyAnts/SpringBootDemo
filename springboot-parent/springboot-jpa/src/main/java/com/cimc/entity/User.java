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
@NamedQueries({
        @NamedQuery(name = "User.findByName",query = "select u from User u where u.name=?1"),
        @NamedQuery(name = "User.findByAge",query = "select u from User u where u.age=?1"),
})
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
