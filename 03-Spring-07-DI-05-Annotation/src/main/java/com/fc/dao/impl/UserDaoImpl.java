package com.fc.dao.impl;

import com.fc.dao.UserDao;
import com.fc.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public List<User> findAll() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(1,"八嘎雅鹿","123456"));
        users.add(new User(2,"丰原玩也","111111"));
        users.add(new User(3,"神里绫华","222222"));
        return users;
    }
}
