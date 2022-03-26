package com.fc.demo2;

import org.junit.Test;

public class Client {
    @Test
    public void test(){
        //冰淇淋上号
        GamePlay gamePayer = new GamePlayer();
        //代练上号
        GamePlayProxy proxy = new GamePlayProxy(gamePayer);
        proxy.login();
        proxy.killBoss();
        proxy.upgrade();
    }
}
