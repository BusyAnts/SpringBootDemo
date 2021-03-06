package com.cimc.mapper;


import com.cimc.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * User接口
 *
 * @author chenz
 */
public interface UserMapper {
    @Insert("insert into user(name, phone, age, create_time) values (#{name}, #{phone}, #{age}, #{createTime})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int insert(User user);

    @Select("select * from user")
    @Results({
            @Result(column = "create_time",property = "createTime")
    })
    List<User> getAll();

    @Select("select * from user where id = #{id}")
    @Results({
            @Result(column = "create_time",property = "createTime")
    })
    User findById(Long id);

    @Update("update user set name=#{name} where id =#{id}")
    void update(User user);

    @Delete("delete from user where id =#{userId}")
    void delete(Long userId);

}