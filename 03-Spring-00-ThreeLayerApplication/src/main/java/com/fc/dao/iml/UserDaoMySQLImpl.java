package com.fc.dao.iml;

import com.fc.dao.UserDao;

public class UserDaoMySQLImpl implements UserDao {
    @Override
    public void useDateBase() {
        System.out.println("连接MySQL数据库");
    }
}
