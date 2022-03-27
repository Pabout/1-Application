package test;


import dao.AccountDao;
import entity.Account;
import entity.TAccount;
import org.junit.Test;
import util.MybatisUtil;

import java.util.List;

public class MybatisTest {
    @Test
    public void testCamelCase(){
        AccountDao accountDao = MybatisUtil.getMapper(AccountDao.class);
        List<TAccount> accounts = accountDao.findAllByCamelCase();
        for (TAccount account : accounts) {
            System.out.println(account);
        }
        MybatisUtil.commit();
    }

    @Test
    public void testMap(){
        AccountDao accountDao = MybatisUtil.getMapper(AccountDao.class);
        Account account = accountDao.findById(2);
        System.out.println(account);
        MybatisUtil.commit();
    }
    @Test
    public void test(){
        AccountDao accountDao = MybatisUtil.getMapper(AccountDao.class);
        List<Account> accounts =accountDao.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
        MybatisUtil.commit();
    }

}
