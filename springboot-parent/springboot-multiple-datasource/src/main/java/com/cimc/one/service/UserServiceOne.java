package com.cimc.one.service;

import com.cimc.entity.User;
import com.cimc.one.mapper.UserMapperOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author chenz
 * @create 2019-09-22 17:08
 */
@Service
public class UserServiceOne {

    @Autowired
    private UserMapperOne userMapperOne;

    @Transactional(transactionManager = "transactionManagerOne")
    public int insert(User user) {
        int res = userMapperOne.insert(user);
        int i = 1 / 0;
        return res;
    }

}
