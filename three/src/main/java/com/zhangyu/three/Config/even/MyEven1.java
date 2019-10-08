package com.zhangyu.three.Config.even;

import org.springframework.stereotype.Component;

/**
 * @author yu.zhang
 * @Description: TODO
 * @date 2019/9/24 17:27
 */
@Component
public class MyEven1 implements MyEvenInter{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void initEven() {
        System.out.println("initEven");
    }

    public MyEven1() {
        System.out.println("hehMyEven1");
    }
}
