package com.fc.service.impl;

import com.fc.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("添加一个雪山");
    }

    @Override
    public void update() {
        System.out.println("修改了一个雪山");
    }
}
