package com.cimc.dao;

import com.cimc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 接口
 *
 * @author chenz
 */
public interface UserRepository extends JpaRepository<User, Integer> {}