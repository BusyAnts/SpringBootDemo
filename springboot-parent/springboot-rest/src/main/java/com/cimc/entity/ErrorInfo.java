package com.cimc.entity;

import lombok.Data;

/**
 * 自定义异常类
 *
 * @author chenz
 * @param <T>
 */
@Data
public class ErrorInfo<T> {
    public static final Integer OK = 0;
    public static final Integer ERROR = 100;
    private Integer code;
    private String message;
    private String url;
    private T data;
}
