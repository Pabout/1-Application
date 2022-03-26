package com.fc.dao.impl;

import com.fc.dao.UserDao;
import com.fc.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaoMySQLImpl implements UserDao {
    @Override
    public List<User> findAll() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(1,"雷电","777777"));
        users.add(new User(2,"真是","555555"));
        users.add(new User(3,"我的","666666"));
        return users;
    }
}
