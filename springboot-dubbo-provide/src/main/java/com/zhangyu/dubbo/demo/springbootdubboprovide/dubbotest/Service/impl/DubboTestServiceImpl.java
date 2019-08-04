package com.zhangyu.dubbo.demo.springbootdubboprovide.dubbotest.Service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zhangyu.dubbo.demo.springbootdubboprovide.dubbotest.Service.DubboTestService;
import org.springframework.stereotype.Component;


/**
 * @author yu.zhang
 * @Description: TODO
 * @date 2019/7/15 11:43
 */

@Service
@Component
public class DubboTestServiceImpl implements DubboTestService {

    @Override
    public String saidHelloDubbo(String str) {
        String result ="dubboTestSaid: " + str;
        System.out.println(result);
        return result;
    }
}
