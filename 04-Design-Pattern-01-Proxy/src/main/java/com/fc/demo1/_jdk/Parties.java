package com.fc.demo1._static;

//原告被代理的对象
public class Parties implements Lawsuit{

    @Override
    public void submit() {
        System.out.println("老板那跑路了");
    }

    @Override
    public void defend() {
        System.out.println("还我血汗钱");
    }
}
