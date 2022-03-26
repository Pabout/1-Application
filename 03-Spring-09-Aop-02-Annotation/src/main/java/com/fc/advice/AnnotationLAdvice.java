package com.fc.advice;

import org.aspectj.lang.ProceedingJoinPoint;

public class AnnotationLAdvice {
    public void before(){
        System.out.println("前置通知，会在方法执行之前执行");
    }
    public void afterReturning(){
        System.out.println("后置通知，会在方法执行之后执行");
    }
    public void afterThrowing(){
        System.out.println("异常通知，发生异常执行执行");
    }
    public void after(){
        System.out.println("最终通知，无论发生异常都会通知");
    }
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕通知，之前");
        Object proceed = joinPoint.proceed();
        System.out.println("环绕通知，之后");
        return proceed;
    }
}
