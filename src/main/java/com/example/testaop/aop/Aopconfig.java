package com.example.testaop.aop;

import com.example.testaop.config.ApplicationUtil;
import com.example.testaop.service.MyService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


/**
 * @Auther: gaoyang
 * @Date: 2018/12/13 16:13
 * @Description:
 */
@Aspect
@Component
public class Aopconfig implements ApplicationContextAware {

    @Autowired
    MyService myService;

    private ApplicationContext applicationContext;

    @Pointcut(value = "@annotation(com.example.testaop.config.Gao)")
    public void gao() {
    }

    @Around(value = "gao()")
    public Object test(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] before = myService.before(joinPoint);
        Object proceed = null;
        String flag = null;
        Object[] args = joinPoint.getArgs();
        try {
            proceed = joinPoint.proceed();
            myService.todo(joinPoint, (String)before[0],(Class)before[2],args);
        } catch (Exception e) {
            myService.todo(joinPoint, (String)before[1],(Class)before[2],args);
            throw new Throwable(e);
        }
        return proceed;
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationUtil.getInstance().setApplication(applicationContext);
    }
}
