package com.cimc.repository.test1;

import com.cimc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTest1Repository extends JpaRepository<User, Long> {

    User findById(long id);

}