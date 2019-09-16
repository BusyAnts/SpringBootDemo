package com.cimc.model;

import java.util.Date;

public class User {
    private Integer id;

    private String name;

    private String phone;

    private Date createTime;

    private Integer age;

    public User(Integer id, String name, String phone, Date createTime, Integer age) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.createTime = createTime;
        this.age = age;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}