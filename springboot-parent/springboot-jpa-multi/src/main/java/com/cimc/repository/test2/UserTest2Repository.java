package com.cimc.repository.test2;

import com.cimc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTest2Repository extends JpaRepository<User, Long> {
    User findById(long id);
}