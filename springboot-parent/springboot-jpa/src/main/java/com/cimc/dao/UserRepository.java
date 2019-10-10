package com.cimc.dao;

import com.cimc.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 接口
 *
 * @author chenz
 */
public interface UserRepository extends JpaSpecificationExecutor<User>, JpaRepository<User, Long> {

    @Query("select u from User u")
    Page<User> findAllUser(Pageable pageable);

    @Query(value = "select * from t_user u where u.name= ?1", nativeQuery = true)
    Page<User> findByName(String name, Pageable pageable);

    @Query(value = "select * from t_user u where u.name= :name", nativeQuery = true)
    Page<User> findByName2(@Param("name") String name, Pageable pageable);

    @Transactional(timeout = 10)
    @Modifying
    @Query(value = "update t_user set name = ?1 where id = ?2", nativeQuery = true)
    int modifyById(String name, Long id);

    List<User> findByName(String name);

    List<User> findByAge(Integer age);

    User findFirstByOrderByNameAsc();

    User findTopByOrderByAgeDesc();

    Page<User> queryFirst10ByName(String name, Pageable pageable);

    List<User> findFirst10ByName(String name, Sort sort);

    List<User> findTop10ByName(String name, Pageable pageable);

}