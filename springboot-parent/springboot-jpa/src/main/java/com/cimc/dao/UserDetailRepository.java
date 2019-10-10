package com.cimc.dao;

import com.cimc.entity.UserDetail;
import com.cimc.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author chenz
 * @create 2019-10-10 10:38
 */
public interface UserDetailRepository extends JpaRepository<UserDetail, Long> {

    @Query("select u.name as name, d.email as email,d.address as address,d.hobby as hobby from User u, UserDetail d " +
            "where u.id = d.id and d.hobby=?1")
    List<UserInfo> findUserInfo(String hobby);

}
