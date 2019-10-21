package com.cimc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chenz
 * @create 2019-10-17 16:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailResult {
    private String rspCode;
    private String rspMsg;

    public static MailResult success() {
        return new MailResult("00","发送成功");
    }

}
