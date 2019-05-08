package com.example.testaop.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Auther: gaoyang
 * @Date: 2018/12/13 16:10
 * @Description:
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.METHOD)
public @interface Gao {
    String confirm();

    String cancel();

    Class interface_();
}
