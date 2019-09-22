package com.cimc.service;

import com.cimc.dao.UserRepository;
import com.cimc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author chenz
 * @create 2019-09-22 10:00
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void save(User user) {
        userRepository.save(user);
        int i = 1 / 0;
    }

}
