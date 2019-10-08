package com.zhangyu.three.Config.even;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

/**
 * @author yu.zhang
 * @Description: TODO
 * @date 2019/9/24 18:22
 */
@Configuration
public class MyEvenConfig {

    //首先执行，后执行对应类里面的方法
    @Bean( initMethod = "initEven")
    @DependsOn(
            value = "myEven1"
    )
    public MyEven myEven() {
        MyEven even = new MyEven();
        even.setName("ggggEven");
        return even;
    }

    public void initEven() {
        System.out.println("initEven");
    }
}
