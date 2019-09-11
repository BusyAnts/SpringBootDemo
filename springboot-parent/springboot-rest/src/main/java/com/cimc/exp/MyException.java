package com.cimc.exp;

/**
 * 自定义异常
 *
 * @author chenz
 */
public class MyException extends RuntimeException {
    public MyException(String message) {
        super(message);
    }
}
