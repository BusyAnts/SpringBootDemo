package com.cimc.two.mapper;


import com.cimc.entity.User;

import java.util.List;

/**
 * User接口
 *
 * @author chenz
 */
public interface UserMapperTwo {

    int insert(User user);

    List<User> getAll();

    User findById(Long id);

    void update(User user);

    void delete(Long userId);

}