package com.zhangyu.three.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yu.zhang
 * @Description: TODO
 * @date 2019/8/7 11:23
 */
@Configuration
public class MyBeanConfig {

    @Bean
    public ConfigBean getConfigBean() {
        return new ConfigBean();
    }
}
