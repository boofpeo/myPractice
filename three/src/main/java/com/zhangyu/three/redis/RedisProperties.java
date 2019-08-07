package com.zhangyu.three.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

/**
 * @author yu.zhang
 * @Description: TODO
 * @date 2019/8/7 15:15
 */

@Configuration
@PropertySource(value = "classpath:redis.properties")
public class RedisProperties {

    @Value("${redis.hostName}")
    private String hostName;

    @Value("${redis.database}")
    private Integer database;

    @Value("${redis.password}")
    private String password;

    @Value("${redis.port}")
    private Integer port;

    @Value("${redis.maxIdle}")
    private Integer maxIdle;

    @Value("${redis.timeout}")
    private Integer timeout;

    @Value("${redis.maxTotal}")
    private Integer maxTotal;

    @Value("${redis.maxWaitMillis}")
    private Integer maxWaitMillis;

    @Value("${redis.minEvictableIdleTimeMillis}")
    private Integer minEvictableIdleTimeMillis;

    @Value("${redis.numTestsPerEvictionRun}")
    private Integer numTestsPerEvictionRun;

    @Value("${redis.timeBetweenEvictionRunsMillis}")
    private long timeBetweenEvictionRunsMillis;

    @Value("${redis.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${redis.testWhileIdle}")
    private boolean testWhileIdle;

//  手工创建Jedis的连接工厂，并且注入到Spring中

    /**
     * @Author yu.zhang
     * @Date 2019/8/7 16:44
     * 配置redis客户端的工厂方法
     */
    @Bean
    public JedisConnectionFactory getJedisConnectionFactory() {
//      创建一个redis的config配置
        System.out.println("创建一个redisConfig");
        RedisStandaloneConfiguration redisConfig = new RedisStandaloneConfiguration();
        redisConfig.setHostName(hostName);
        //由于我们使用了动态配置库,所以此处省略
        redisConfig.setDatabase(database);
        redisConfig.setPort(port);

//      获得客户端的配置建造者
//        JedisClientConfiguration.JedisClientConfigurationBuilder clientBuilder = JedisClientConfiguration.builder();
//        clientBuilder.connectTimeout(Duration.ofMillis(timeout));
//      获得客户端对象
//        JedisClientConfiguration clientConfig = clientBuilder.build();
//      创建Jedis连接工厂
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(redisConfig,
                JedisClientConfiguration.builder().connectTimeout(Duration.ofMillis(timeout)).build());
        return jedisConnectionFactory;
    }


    @Bean
    public RedisSerializer getFastJson2JsonRedisSerializer(){
        System.out.println("向spring注入json方法");
        return new FastJson2JsonRedisSerializer<Object>(Object.class);
    }

    @Bean
    public RedisTemplate getRedisTemp(RedisConnectionFactory redisConnectionFactory) {
        System.out.println("创建配置初始化Redis，或者redisTemp");
        RedisTemplate redisTemplate = new RedisTemplate();
        //如果不配置Serializer，那么存储的时候缺省使用String，如果用User类型存储，那么会提示错误User can't cast to String！

        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());

        redisTemplate.setHashValueSerializer(getFastJson2JsonRedisSerializer());
        redisTemplate.setValueSerializer(getFastJson2JsonRedisSerializer());
        // 开启事务
        redisTemplate.setEnableTransactionSupport(true);
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        return redisTemplate;
    }

}
