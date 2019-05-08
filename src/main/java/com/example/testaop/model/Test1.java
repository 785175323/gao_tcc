package com.example.testaop.model;

import javax.validation.constraints.NotNull;

/**
 * @Auther: gaoyang
 * @Date: 2018/12/29 16:49
 * @Description:
 */
public class Test1 {

    @NotNull
    private String name;
    private Integer age;

    private Test2 Test2;

    public Test2 getTest2() {
        return Test2;
    }

    public void setTest2(Test2 test2) {
        Test2 = test2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Test1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", Test2='" + Test2 + '\'' +
                '}';
    }
}
