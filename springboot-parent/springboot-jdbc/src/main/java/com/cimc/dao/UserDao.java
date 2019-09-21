package com.cimc.dao;


import com.cimc.entity.User;

import java.util.List;

/**
 * UserDao接口
 *
 * @author chenz
 */
public interface UserDao {

    int insert(User user);

    List<User> getAll();

    User findById(Long id);

    void update(User user);

    void delete(Long userId);

}