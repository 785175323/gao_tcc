package com.example.testaop.model;

import javax.validation.constraints.NotNull;

/**
 * @Auther: gaoyang
 * @Date: 2018/12/29 16:49
 * @Description:
 */
public class Test2 {

    private Double aa;

    @NotNull
    private Integer age;

    public Double getAa() {
        return aa;
    }

    public void setAa(Double aa) {
        this.aa = aa;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Test2{" +
                "aa=" + aa +
                ", age=" + age +
                '}';
    }
}
