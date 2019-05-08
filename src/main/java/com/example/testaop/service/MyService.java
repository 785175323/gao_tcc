package com.example.testaop.service;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @Auther: gaoyang
 * @Date: 2018/12/14 08:46
 * @Description:
 */
public interface MyService {
    public void todo(ProceedingJoinPoint joinPoint, String flag,Class a,Object[] args)throws Throwable;
    public Object[] before(ProceedingJoinPoint joinPoint);
}
