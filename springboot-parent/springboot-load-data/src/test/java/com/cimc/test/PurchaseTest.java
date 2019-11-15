package com.cimc.test;

import com.cimc.entity.Purchase;
import com.cimc.mapper.PurchaseMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author chenz
 * @create 2019-11-14 13:25
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class PurchaseTest {

    @Autowired
    private PurchaseMapper purchaseMapper;

    @Test
    public void getAllTest() {
        List<Purchase> purchases = purchaseMapper.getAll();
        System.out.println(purchases);
    }

    @Test
    public void insertPurchaseTest() {
        Purchase purchase = new Purchase();
        purchase.setId(3);
        BigDecimal price = new BigDecimal(5.72);
        purchase.setPurchasePrice(price);
        purchase.setPurchaseNum(6);
        BigDecimal sum = new BigDecimal(34.32);
        purchase.setPurchaseSum(sum);
        purchase.setPurchaseBuyer(2);
        purchase.setPurchaseDate(new Date());
        purchase.setCompanyId(3);
        purchase.setGoodsId(4);
        purchaseMapper.insertPurchase(purchase);
    }

    @Test
    public void insertPurchaseBatchTest() {
        List<Purchase> purchases = new ArrayList<>();

        for (int i = 1; i <= 1000000; i++) {
            Purchase purchase = new Purchase();
            purchase.setId(i);
            BigDecimal price = new BigDecimal(5.72);
            purchase.setPurchasePrice(price);
            purchase.setPurchaseNum(6);
            BigDecimal sum = new BigDecimal(34.32);
            purchase.setPurchaseSum(sum);
            purchase.setPurchaseBuyer(2);

            SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
            try {
                purchase.setPurchaseDate(sdf.parse("2018-07-12"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            purchase.setCompanyId(3);
            purchase.setGoodsId(4);
            purchases.add(purchase);

            if (i % 2000 == 0) {
                purchaseMapper.insertPurchaseBatch(purchases);
                purchases.clear();
            }
        }

    }
}
