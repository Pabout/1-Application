package com.fc.demo1._static;

//律师，代理
public class Lawyer implements Lawsuit{
    //代理类中包含了一个被代理对象
    private final Lawsuit parties;

    //通过构造方法进行赋值
    public Lawyer(Lawsuit parties) {
        this.parties = parties;
    }

    @Override
    public void submit() {
        parties.submit();
        this.gatherEvidence();
    }

    @Override
    public void defend() {
        parties.defend();
        this.exchangeOpinions();
    }
    private void gatherEvidence(){
        System.out.println("收集证据");
    }
    //交换意见
    private void exchangeOpinions(){
        System.out.println("交换意见");
    }
}
