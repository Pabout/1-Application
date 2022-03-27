package com.fc.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

//把当前类对象放进容器中
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class User {
    @Value("100")
    private Integer id;
    @Value("雷电jun")
    private String username;
    @Value("123")
    private String password;

    //和init-method相同，会在对象创建后执行此方法
    @PostConstruct
    public void eat(){
        System.out.println("老碗面");
    }
    public void sleep(){
        System.out.println("吃完睡觉");
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
