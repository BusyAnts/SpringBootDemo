package com.cimc.entity;

import lombok.Data;

/**
 * 用户参数
 *
 * @author chenz
 */
@Data
public class UserParam extends User {

    private Integer minAge;

    private Integer maxAge;
}
