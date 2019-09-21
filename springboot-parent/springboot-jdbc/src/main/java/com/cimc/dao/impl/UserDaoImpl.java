package com.cimc.dao.impl;

import com.cimc.dao.UserDao;
import com.cimc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author chenz
 * @create 2019-09-18 23:03
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(User user) {
        String sql = "insert into user(name, phone, age, create_time) values (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, user.getName(), user.getPhone(), user.getAge(), user.getCreateTime());
    }

    @Override
    public List<User> getAll() {
        String sql = "select * from user";
        return jdbcTemplate.query(sql, new UserRowMapper());
    }

    @Override
    public User findById(Long id) {
        String sql = "select * from user where id = ?";
        return jdbcTemplate.queryForObject(sql, new UserRowMapper(), id);
    }

    @Override
    public void update(User user) {
        String sql = "update user set name=?,age=?,phone=? where id = ?";
        jdbcTemplate.update(sql, user.getName(), user.getAge(), user.getPhone(), user.getId());
    }

    @Override
    public void delete(Long userId) {
        String sql = "delete from user where id = ?";
        jdbcTemplate.update(sql, userId);
    }

}

class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setName(resultSet.getString("name"));
        user.setAge(resultSet.getInt("age"));
        user.setPhone(resultSet.getString("phone"));
        user.setCreateTime(resultSet.getDate("create_time"));
        return user;
    }
}
