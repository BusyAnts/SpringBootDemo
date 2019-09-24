package com.cimc.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author chenz
 * @create 2019-09-09 11:23
 */
@ApiModel(description = "用户信息")
@Data
public class User {
    @ApiModelProperty(value = "ID", name = "id", example = "1")
    private Long id;

    @ApiModelProperty(value = "姓名", name = "name")
    private String name;

    @ApiModelProperty(value = "年龄", name = "age", example = "20")
    private Integer age;

    @ApiModelProperty(value = "生日", name = "birthday")
    private Date birthday;
}
