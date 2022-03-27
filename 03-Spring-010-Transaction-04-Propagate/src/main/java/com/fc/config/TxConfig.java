package com.fc.config;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.fc.dao.AccountDao;
import com.fc.dao.LocationDao;
import com.fc.dao.impl.AccountDaoImpl;
import com.fc.dao.impl.LocationDaoImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@PropertySource("classpath:jdbc.properties")
//指定包扫描路径，会扫描指定包下的所以注解
@ComponentScan("com.fc")
//当前类就是配置类
@Configuration
//开启
@EnableTransactionManagement
public class TxConfig {
    @Value("${jdbc.driver}")
    private String driverClassName;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    // @Bean注解用于将指定方法的返回值作为容器中的对象
    //id就是方法名
    @Bean
    public DataSource dataSource(){

        Properties properties = new Properties();

        properties.setProperty("driverClassName",driverClassName);
        properties.setProperty("url",url);
        properties.setProperty("username",username);
        properties.setProperty("password",password);

        DataSource dataSource=null;

        try {
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataSource;
    }
    @Bean
    public LocationDao locationDao(DataSource dataSource){
        LocationDaoImpl locationDao = new LocationDaoImpl();
        locationDao.setDataSource(dataSource());
        return locationDao;

    }
    @Bean
    public AccountDao accountDao(DataSource dataSource){
        AccountDaoImpl accountDao = new AccountDaoImpl();
        accountDao.setDataSource(dataSource);
        return accountDao;
    }
    @Bean
    public TransactionManager transactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
