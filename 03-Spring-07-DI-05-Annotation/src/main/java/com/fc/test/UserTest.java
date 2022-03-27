package com.fc.test;

import com.fc.controller.UserController;
import com.fc.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserTest {
    @Test
    public void testIoc(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.fc");
        UserController userController = applicationContext.getBean(UserController.class);
        System.out.println(userController);
    }
    @Test
    public void testContext(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationConfig.xml");
        UserController userController = applicationContext.getBean(UserController.class);
        List<User> list = userController.findAll();
        System.out.println(list);
    }
    @Test
    public void testValue(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationConfig.xml");
        User user = applicationContext.getBean(User.class);
        System.out.println(user);
    }
}
