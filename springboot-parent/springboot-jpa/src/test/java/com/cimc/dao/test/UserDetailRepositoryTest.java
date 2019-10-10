package com.cimc.dao.test;

import com.cimc.dao.UserDetailRepository;
import com.cimc.entity.UserDetail;
import com.cimc.entity.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author chenz
 * @create 2019-10-10 10:43
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserDetailRepositoryTest {

    @Autowired
    private UserDetailRepository userDetailRepository;

    @Test
    public void saveTest() {
        UserDetail userDetail = new UserDetail();
        userDetail.setAddress("苏州");
        userDetail.setEmail("chenz@163.com");
        userDetail.setHobby("钓鱼");
        userDetailRepository.save(userDetail);
    }

    @Test
    public void findUserInfoTest() {
        List<UserInfo> userInfos = userDetailRepository.findUserInfo("钓鱼");
        for (UserInfo userInfo : userInfos) {
            System.out.println("userInfo: " + userInfo.getName() + "-" + userInfo.getEmail()
                    + "-" + userInfo.getAddress() + "-" + userInfo.getHobby());
        }
    }

}
