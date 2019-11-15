package com.cimc.mapper;

import com.cimc.entity.Purchase;

import java.util.List;

/**
 * @author chenz
 * @create 2019-11-14 13:41
 */
public interface PurchaseMapper {

    List<Purchase> getAll();

    Integer insertPurchase(Purchase purchase);

    Integer insertPurchaseBatch(List<Purchase> purchases);

}
