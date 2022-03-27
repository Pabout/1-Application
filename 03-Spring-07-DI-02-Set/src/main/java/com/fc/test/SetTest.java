package com.fc.test;

import com.fc.entity.Student;
import com.fc.entity.Teacher;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.rmi.CORBA.Stub;

public class SetTest {
    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationConfig.xml");
        Student student = applicationContext.getBean("student", Student.class);
        System.out.println(student);
        Teacher teacher = applicationContext.getBean("teacher", Teacher.class);
        System.out.println(teacher);
    }
}
