package com.fc.dao.iml;

import com.fc.dao.UserDao;

public class UserDaoOracleImpl implements UserDao {
    @Override
    public void useDateBase() {
        System.out.println("使用Oracle数据库");
    }
}
