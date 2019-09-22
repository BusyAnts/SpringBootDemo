package com.cimc.one.mapper;


import com.cimc.entity.User;

import java.util.List;

/**
 * User接口
 *
 * @author chenz
 */
public interface UserMapperOne {

    int insert(User user);

    List<User> getAll();

    User findById(Long id);

    void update(User user);

    void delete(Long userId);

}