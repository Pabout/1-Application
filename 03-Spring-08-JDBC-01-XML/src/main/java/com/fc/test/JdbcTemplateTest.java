package com.fc.test;

import com.fc.dao.impl.JDBCTemplateDaoImpl;
import com.fc.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class JdbcTemplateTest {
    @Test
    public void testDelete(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        JDBCTemplateDaoImpl userDao = applicationContext.getBean(JDBCTemplateDaoImpl.class);
        int affect = userDao.delete(5);
        System.out.println(affect);
    }
    @Test
    public void testupdate(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        JDBCTemplateDaoImpl userDao = applicationContext.getBean(JDBCTemplateDaoImpl.class);
        int affect = userDao.update(new User(5,"王中王","123456"));
        System.out.println(affect);
    }
    @Test
    public void testInsert(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        JDBCTemplateDaoImpl userDao = applicationContext.getBean(JDBCTemplateDaoImpl.class);
        int affect = userDao.insert(new User(null,"王中王","123456"));
        System.out.println(affect);
    }
    @Test
    public void testFindCount(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        JDBCTemplateDaoImpl userDao = applicationContext.getBean(JDBCTemplateDaoImpl.class);
        int count = userDao.findCount();
        System.out.println(count);
    }
    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        JDBCTemplateDaoImpl userDao = applicationContext.getBean(JDBCTemplateDaoImpl.class);
        List<User> list = userDao.findAll();
        System.out.println(list);
    }
    @Test
    public void testId(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        JDBCTemplateDaoImpl userDao = applicationContext.getBean(JDBCTemplateDaoImpl.class);
        User user = userDao.findById(1);
        System.out.println(user);
    }

}
