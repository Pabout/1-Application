package com.fc.test;

import com.fc.config.AopConfig;
import com.fc.service.UserService;
import com.fc.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XMLTest {
    @Test
    public void testAnnotation(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AopConfig.class);
        UserServiceImpl userService = applicationContext.getBean(UserServiceImpl.class);
        userService.add();
    }

    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService bean = applicationContext.getBean(UserService.class);
        bean.add();
        bean.update();
    }
}
