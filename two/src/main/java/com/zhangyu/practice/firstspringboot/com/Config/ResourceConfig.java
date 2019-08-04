package com.zhangyu.practice.firstspringboot.com.Config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author yu.zhang
 * @Description: TODO
 * @date 2019/8/2 15:36
 */
@Configuration
@ConfigurationProperties(prefix = "com")
@PropertySource( value = "classpath:mapper/resource.properties")
public class ResourceConfig {
}
