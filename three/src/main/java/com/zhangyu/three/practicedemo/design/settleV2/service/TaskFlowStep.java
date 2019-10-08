package com.zhangyu.three.practicedemo.design.settleV2.service;

import com.zhangyu.three.practicedemo.design.settleV2.entity.OperateObj;

public interface TaskFlowStep {
    /**
     * 任务步骤执行方法
     */
    public void execute(OperateObj obj);
}
