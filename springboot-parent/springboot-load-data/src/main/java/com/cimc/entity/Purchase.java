package com.cimc.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author chenz
 * @create 2019-11-14 13:36
 */
@Data
public class Purchase {

    private Integer id;
    private BigDecimal purchasePrice;
    private Integer purchaseNum;
    private BigDecimal purchaseSum;
    private Integer purchaseBuyer;
    private Date purchaseDate;
    private Integer companyId;
    private Integer goodsId;
}
