package com.zhangyu.practice.firstspringboot.com.rabbitmq.service.impl;

import com.zhangyu.practice.firstspringboot.com.rabbitmq.config.RabbitConfig;
import com.zhangyu.practice.firstspringboot.com.rabbitmq.entity.EntityA;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author yu.zhang
 * @Description: TODO
 * @date 2019/7/11 17:11
 */
@Service
public class RabbitMqSendServiceImpl implements RabbitTemplate.ConfirmCallback  {

    @Autowired
    private RabbitTemplate rabbitTemplate;



//  普通发送
    public void sendStr(Object content) {
        rabbitTemplate.setConfirmCallback(this);
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        //把消息放入ROUTINGKEY_A对应的队列当中去，对应的是队列A
        rabbitTemplate.convertAndSend("A", content,correlationId);
    }

//  对象的发送
    public void sendObj() {
        EntityA entityA = new EntityA();
        entityA.setId("11");
        entityA.setName("wangba");
        System.out.println("发送OBJ");
        rabbitTemplate.convertAndSend(entityA);
    }

    /**
    * @Author yu.zhang
    * @Date 2019/7/11 19:19
    */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        System.out.println("MsgSendConfirmCallBack  , 回调id:" + correlationData);
        if (ack) {
            System.out.println("消息消费成功");
        } else {
            System.out.println("消息消费失败:" + cause+"\n重新发送");
        }
    }
}
