package com.fc.service.impl;

import com.fc.dao.AccountDao;
import com.fc.service.AccountService;

public class AnnotationServiceImpl implements AccountService {
    private AccountDao accountDao;

    @Override
    public void transfer(Integer from, Integer to, Long money) {
        //开启一个事务
        accountDao.decreaseMoney(from,money);
        accountDao.increaseMoney(to,money);
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
}
