package com.fc.test;

import com.fc.entity.Student;
import com.fc.entity.Teacher;
import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OldTest {
   static ApplicationContext applicationContext=null;
    @BeforeClass
    public static void before(){
        System.out.println("获取容器");
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    }
    @AfterClass
    public static void after(){
        ((ClassPathXmlApplicationContext) applicationContext).close();
        System.out.println("关闭容器");
    }


    @Test
    public void test1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = applicationContext.getBean("student", Student.class);
        System.out.println(student);
        Teacher teacher = applicationContext.getBean("teacher", Teacher.class);
        System.out.println(teacher);
    }
}
