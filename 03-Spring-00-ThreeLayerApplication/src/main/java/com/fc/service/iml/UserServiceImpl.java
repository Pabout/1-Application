package com.fc.service.iml;

import com.fc.dao.UserDao;
import com.fc.dao.iml.UserDaoImpl;
import com.fc.dao.iml.UserDaoMySQLImpl;
import com.fc.dao.iml.UserDaoOracleImpl;
import com.fc.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao=new UserDaoMySQLImpl();

    @Override
    public void useDateBase() {
        userDao.useDateBase();
    }

    @Override
    public void setUserDao(UserDao userDao) {
        this.userDao=userDao;
    }
}
