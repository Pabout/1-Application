package com.fc.demo2._jdk;

//游戏玩家，被代理
public class GamePlayer implements GamePlay {
    @Override
    public void login() {
        System.out.println("使用冰淇淋登录游戏");
    }

    @Override
    public void killBoss() {
        System.out.println("冰淇淋一刀999");
    }

    @Override
    public void upgrade() {
        System.out.println("恭喜冰淇淋300级");
    }
}
