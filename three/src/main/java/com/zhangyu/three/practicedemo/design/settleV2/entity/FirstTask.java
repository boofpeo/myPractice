package com.zhangyu.three.practicedemo.design.settleV2.entity;

import com.zhangyu.three.practicedemo.design.settleV2.service.AbstractTaskFlowAdapterService;

/**
 * @author yu.zhang
 * @Description: TODO
 * @date 2019/8/9 15:37
 */
public class FirstTask extends AbstractTaskFlowAdapterService {
    public FirstTask() {
        this.task = "first";
    }

    @Override
    protected WorkResponse doWorkBefore() {
        System.out.println("doWorkBefore : " + this.task);
        return WorkResponse.CONTINUE;
    }

    @Override
    protected WorkResponse doWorkAfter() {
        System.out.println("doWorkAfter : " + this.task);
        return WorkResponse.CONTINUE;
    }

    @Override
    protected WorkResponse doWork() {
        System.out.println("doWork : " + this.task);
        return WorkResponse.CONTINUE;
    }

    @Override
    public String getTaskId() {
        return "first";
    }

    @Override
    public String getTaskName() {
        return "first";
    }
}
