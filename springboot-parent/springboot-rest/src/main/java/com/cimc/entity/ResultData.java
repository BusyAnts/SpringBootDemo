package com.cimc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author chenz
 * @create 2019-09-10 11:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultData implements Serializable {
    /**
     * 状态码,0表示成功，-1表示失败
     */
    private int code;

    /**
     * 结果
     */
    private Object data;

    /**
     * 错误描述
     */
    private String msg;
}
