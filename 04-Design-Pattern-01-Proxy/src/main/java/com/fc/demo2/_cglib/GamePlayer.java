package com.fc.demo2._cglib;

import com.fc.demo2._static.GamePlay;

//游戏玩家，被代理
public class GamePlayer implements GamePlay {
    private final String username;

    public GamePlayer(String username) {
        this.username = username;
    }

    @Override
    public void login() {
        System.out.println(username+"使用冰淇淋登录游戏");
    }

    @Override
    public void killBoss() {
        System.out.println(username+"冰淇淋一刀999");
    }

    @Override
    public void upgrade() {
        System.out.println(username+"恭喜冰淇淋300级");
    }
}
