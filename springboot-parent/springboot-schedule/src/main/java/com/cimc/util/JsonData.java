package com.cimc.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 返回Json格式数据
 *
 * @author chenz
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonData implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 状态码 0表示成功，1表示处理中，-1表示失败
     */
    private Integer code;

    /**
     * 数据
     */
    private Object data;

    /**
     * 描述
     */
    private String msg;

    /**
     * 成功，不传入数据
     *
     * @return
     */
    public static JsonData buildSuccess() {
        return new JsonData(0, null, null);
    }

    /**
     * 成功，传入数据
     *
     * @param data
     * @return
     */
    public static JsonData buildSuccess(Object data) {
        return new JsonData(0, data, null);
    }

    /**
     * 成功，传入数据,及描述信息
     *
     * @param data
     * @param msg
     * @return
     */
    public static JsonData buildSuccess(Object data, String msg) {
        return new JsonData(0, data, msg);
    }

    /**
     * 失败，传入描述信息
     *
     * @param msg
     * @return
     */
    public static JsonData buildError(String msg) {
        return new JsonData(-1, null, msg);
    }

    /**
     * 失败，传入状态码，描述信息
     *
     * @param code
     * @param msg
     * @return
     */
    public static JsonData buildError(Integer code, String msg) {
        return new JsonData(code, null, msg);
    }

}