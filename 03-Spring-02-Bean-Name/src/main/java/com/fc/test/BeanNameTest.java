package com.fc.test;

import com.fc.entity.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanNameTest {
    @Test
    public void testId(){
        ApplicationContext ApplicationContext = new ClassPathXmlApplicationContext("applicationConfig.xml");
        Student bean = ApplicationContext.getBean("student",Student.class);
        System.out.println(bean);
    }
}
