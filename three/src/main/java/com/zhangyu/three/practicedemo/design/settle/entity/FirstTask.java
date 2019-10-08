package com.zhangyu.three.practicedemo.design.settle.entity;

import com.zhangyu.three.practicedemo.design.settle.service.AbstractTaskService;

/**
 * @author yu.zhang
 * @Description: TODO
 * @date 2019/8/9 11:02
 */
public class FirstTask extends AbstractTaskService {

    @Override
    protected void doCheck(String obj) {

    }

    @Override
    protected boolean Ignore() {
        return false;
    }

    @Override
    protected void doWork(String obj) {
        System.out.println("FirstTask" + obj);
    }

    @Override
    public String getTaskId() {
        return "first";
    }

    @Override
    public String getTaskName() {
        return "第一个";
    }
}
