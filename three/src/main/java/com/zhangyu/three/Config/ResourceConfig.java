package com.zhangyu.three.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author yu.zhang
 * @Description: TODO
 * @date 2019/8/2 16:29
 */
@Configuration
//@ConfigurationProperties( prefix = "com")
@PropertySource(value = "classpath:resource.properties")
//@EnableConfigurationProperties(ResourceConfig.class)
public class ResourceConfig {

    @Value("${com.name}")
    private String name;

    @Value("${com.age}")
    private Integer age;

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
