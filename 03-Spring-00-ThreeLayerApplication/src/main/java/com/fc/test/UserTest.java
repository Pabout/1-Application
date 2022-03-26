package com.fc.test;

import com.fc.dao.iml.UserDaoImpl;
import com.fc.service.iml.UserServiceImpl;
import org.junit.Test;

public class UserTest {
@Test
    public void test(){
    UserServiceImpl userService = new UserServiceImpl();
    userService.setUserDao(new UserDaoImpl());
    userService.useDateBase();
}

}
