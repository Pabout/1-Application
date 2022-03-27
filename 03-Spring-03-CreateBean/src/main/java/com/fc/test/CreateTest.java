package com.fc.test;

import com.fc.entity.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CreateTest {
    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationConfig.xml");
        Student student = applicationContext.getBean("student", Student.class);
        System.out.println(student);
    }
    @Test
    public void test2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationConfig.xml");
        Student student2 = applicationContext.getBean("student2", Student.class);
        System.out.println(student2);
    }
    @Test
    public void test3(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationConfig.xml");
        Student student3 = applicationContext.getBean("student3", Student.class);
        System.out.println(student3);
    }
}
