package com.fc.test;

import com.fc.config.TxConfig;
import com.fc.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PropagateTest {
    @Test
    public void test(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TxConfig.class);
        AccountService accountService = applicationContext.getBean(AccountService.class);
        accountService.addAccount("比基尼海滩","海绵宝宝");
    }
}
