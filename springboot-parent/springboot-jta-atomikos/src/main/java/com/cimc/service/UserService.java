package com.cimc.service;

import com.cimc.entity.User;
import com.cimc.one.mapper.UserMapperOne;
import com.cimc.two.mapper.UserMapperTwo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author chenz
 * @create 2019-09-22 19:15
 */
@Service
public class UserService {

    @Autowired
    private UserMapperOne userMapperOne;

    @Autowired
    private UserMapperTwo userMapperTwo;

    @Transactional
    public int insertUserOneAndUserTwo(User user) {
        // 传统分布式事务解决方案 jta+atomikos 注册同一个全局事务中
        // 第一个数据源
        int insertUserResult01 = userMapperOne.insert(user);
        // 第二个数据源
        int insertUserResult02 = userMapperTwo.insert(user);
        int i = 1 / 0;
        int result = insertUserResult01 + insertUserResult02;
        // test01入库 test02回滚
        return result;
    }
}
