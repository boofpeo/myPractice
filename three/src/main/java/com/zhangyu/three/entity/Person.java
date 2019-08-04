package com.zhangyu.three.entity;

/**
 * @author yu.zhang
 * @Description: TODO
 * @date 2019/8/2 17:31
 */
public class Person {
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
