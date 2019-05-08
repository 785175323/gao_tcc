package com.example.testaop.service;

import com.example.testaop.config.ApplicationUtil;
import com.example.testaop.config.Gao;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: gaoyang
 * @Date: 2018/12/14 08:46
 * @Description:
 */
@Service
public class MyServiceImpl implements MyService {
    public final static ThreadPoolExecutor executor =
            new ThreadPoolExecutor(10, 100, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

    @Override
    public void todo(ProceedingJoinPoint joinPoint, String flag, Class aclass, Object[] args) throws Throwable {
        if (aclass.isInterface()) {
            Object beanByInterface = ApplicationUtil.getInstance().getBeanByInterface(aclass);
            Method[] methods = aclass.getMethods();
            for (Method m : methods) {
                if (flag.equals(m.getName())) {
                    executor.execute(() -> {
                        try {
                            m.invoke(beanByInterface, args);
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    });
                }
            }
        } else {
            Method[] methods = aclass.getMethods();
            for (Method m : methods) {
                if (flag.equals(m.getName())) {
                    executor.execute(() -> {
                        try {
                            m.invoke(ApplicationUtil.getInstance().getBean(aclass), args);
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    });
                }
            }
        }
    }


    @Override
    public Object[] before(ProceedingJoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Gao gao = method.getAnnotation(Gao.class);
        String succ = gao.confirm();
        String fail = gao.cancel();
        Class aClass = gao.interface_();
        return new Object[]{succ, fail, aClass};
    }
}
