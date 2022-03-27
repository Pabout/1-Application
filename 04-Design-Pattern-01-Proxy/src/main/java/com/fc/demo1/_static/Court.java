package com.fc.demo1._static;

import org.junit.Test;

public class Court {
    @Test
    public void test(){
        //原告
        Lawsuit parties = new Parties();
        //代理律师
        Lawyer lawyer = new Lawyer(parties);
        lawyer.submit();
        lawyer.defend();
    }
}
