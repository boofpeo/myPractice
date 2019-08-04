package com.zhangyu.dubbo.demo.springbootdubboprovide.dubbotest.Service;

public interface DubboTestService {
    String BEAN_NAME = "dubboTestServiceImpl";
    String saidHelloDubbo(String str);
}
