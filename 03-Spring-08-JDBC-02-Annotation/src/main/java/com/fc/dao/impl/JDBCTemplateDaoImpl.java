package com.fc.dao.impl;

import com.fc.entity.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JDBCTemplateDaoImpl {
    private JdbcTemplate jdbcTemplate;

    public int findCount(){
        String sql="select count(1) from user";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }

    public int delete(Integer id){
        String sql="delete from user where id = ?";
        int affect = jdbcTemplate.update(sql, id);
        return affect;
    }

    public int update(User user){
        String sql="update user set password = ? where id = ?";
        int update = jdbcTemplate.update(sql, user.getUsername(), user.getPassword());
        return update;
    }

    public int insert(User user){
        String sql="insert into user(username,password) values (?,?)";
        int update = jdbcTemplate.update(sql, user.getUsername(), user.getPassword());
        return update;

    }

    public List<User> findAll(){
        String sql="select * from user";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        return users;
    }
     public User findById(Integer id){
        String sql="select * from user where id = ?";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class),id);
        return users.get(0);

    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
