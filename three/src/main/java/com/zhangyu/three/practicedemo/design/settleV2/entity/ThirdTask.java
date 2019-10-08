package com.zhangyu.three.practicedemo.design.settleV2.entity;

import com.zhangyu.three.practicedemo.design.settleV2.service.AbstractTaskFlowAdapterService;

/**
 * @author yu.zhang
 * @Description: TODO
 * @date 2019/8/9 15:40
 */
public class ThirdTask extends AbstractTaskFlowAdapterService {
    public ThirdTask() {
        this.task = "third";
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
        return "third";
    }

    @Override
    public String getTaskName() {
        return "third";
    }
}
