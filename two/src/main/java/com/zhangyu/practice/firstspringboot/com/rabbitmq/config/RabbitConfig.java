package com.zhangyu.practice.firstspringboot.com.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;


/**
 * @author yu.zhang
 * @Description: TODO
 * @date 2019/7/11 16:49
 */
@Configurable
public class RabbitConfig {

    private static final String QUEUE_A = "A";

    private static final String QUEUE_B = "B";

    private static final String FIRST_EXCHANGE = "firstExchange";

    @Autowired
    private ConnectionFactory connectionFactory;
//  使用队列A
    @Bean
    public Queue queueA() {
        return new Queue(RabbitConfig.QUEUE_A);
    }

    //  使用队列B
    @Bean
    public Queue queueB() {
        return new Queue(RabbitConfig.QUEUE_B);
    }

//  交换机
    @Bean
    FanoutExchange fanoutExchange() {
       return new FanoutExchange(RabbitConfig.FIRST_EXCHANGE);
    }

//  交换机绑定队列
    @Bean
    Binding bindingA() {
        return BindingBuilder.bind(queueA()).to(fanoutExchange());
    }

//  交换机绑定队列
    @Bean
    Binding bindingB() {
        return BindingBuilder.bind(queueB()).to(fanoutExchange());
    }

}
