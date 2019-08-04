package com.zhangyu.practice.firstspringboot.com.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.zhangyu.dubbo.demo.springbootdubboprovide.dubbotest.Service.DubboTestService;
import com.zhangyu.practice.firstspringboot.com.entity.Tuser;
import com.zhangyu.practice.firstspringboot.com.rabbitmq.service.impl.RabbitMqSendServiceImpl;
import com.zhangyu.practice.firstspringboot.com.service.TuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private TuserService tuserService;
    @Autowired
    private RedisTemplate redisTemplate;

    @Reference
    private DubboTestService dubboTestService;

    @Autowired
    private RabbitMqSendServiceImpl rabbitMqSendService;

    @RequestMapping("/hello")
    public String hello() {
        Tuser result = tuserService.getphone(109);
        Object obj = null;
        if (redisTemplate == null) {
            System.out.println("模版为空");
        } else {
            System.out.println("有模版可以操作");
            obj = result.getUserId() == null ? null : redisTemplate.opsForValue().get(result.getUserId());
            if (obj == null) {
                redisTemplate.opsForValue().set(result.getUserId(), result);
            }
            obj = result.getUserId() == null ? null : redisTemplate.opsForValue().get(result.getUserId());
        }

        return "Hello Spring Boot!" + result.toString() + "    " + "redis  :" + obj == null ? null : obj.toString();
    }

    @RequestMapping("/rabbitMq")
    public String rabbitMq() {
        boolean flag = true;
        int num = 10;
        while (flag) {
            rabbitMqSendService.sendStr("发送：" + num);
            num--;
//        rabbitMqSendService.sendObj();
            if (num < 0) {
                flag = false;
            }
        }
        return "true";
    }

    @RequestMapping("/dubboTe")
    public String dubboTe() {
        return dubboTestService.saidHelloDubbo("GGG");
    }

    public static void main(String[] args) {
        char sep = (char) 0x04;
        System.out.println(sep);
    }
}