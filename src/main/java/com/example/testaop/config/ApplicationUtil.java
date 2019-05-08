package com.example.testaop.config;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;

/**
 * @Auther: gaoyang
 * @Date: 2018/12/14 08:42
 * @Description:
 */
public class ApplicationUtil {
    private final static ApplicationUtil app = new ApplicationUtil();
    private ApplicationContext applicationContext;

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public static ApplicationUtil getInstance() {
        return app;
    }

    public ApplicationUtil setApplication(ApplicationContext applicationContext) {
        app.setApplicationContext(applicationContext);
        return app;
    }

    public Object getBean(Class aClass) {
        return this.applicationContext.getBean(aClass);
    }

    public Object getBeanByInterface(Class aClass) {
        AutowireCapableBeanFactory autowireCapableBeanFactory = this.applicationContext.getAutowireCapableBeanFactory();
        return autowireCapableBeanFactory.getBean(aClass);
    }
}
