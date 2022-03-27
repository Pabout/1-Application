package com.fc.service.impl;

import com.fc.dao.AccountDao;
import com.fc.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class AnnotationServiceImpl implements AccountService {
    @Autowired
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
