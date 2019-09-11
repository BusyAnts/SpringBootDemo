package com.cimc.exp;

import com.cimc.entity.ResultEnum;

/**
 * 枚举形式定义异常
 *
 * @author chenz
 */
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
