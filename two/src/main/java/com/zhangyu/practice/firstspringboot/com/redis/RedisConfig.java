package com.zhangyu.practice.firstspringboot.com.redis;

import com.alibaba.fastjson.parser.ParserConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@Slf4j
public class RedisConfig  {


    @Bean
    public RedisSerializer fastJson2JsonRedisSerializer() {
        return new FastJson2JsonRedisSerializer<Object>(Object.class);
    }



    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory redis) {
        System.out.println("开始本地模版");
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(redis);
        ParserConfig.getGlobalInstance().addAccept("com.zhangyu.");

        // 开启事务
        redisTemplate.setEnableTransactionSupport(true);

//      key
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setKeySerializer(new StringRedisSerializer());

//      value
        redisTemplate.setValueSerializer(fastJson2JsonRedisSerializer());
        redisTemplate.setHashValueSerializer(fastJson2JsonRedisSerializer());

        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

}
