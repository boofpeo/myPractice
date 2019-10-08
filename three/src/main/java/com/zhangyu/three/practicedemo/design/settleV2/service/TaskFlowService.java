package com.zhangyu.three.practicedemo.design.settleV2.service;

import com.zhangyu.three.practicedemo.design.settleV2.TaskFlowStepProxy;
import com.zhangyu.three.practicedemo.design.settleV2.entity.OperateObj;

public interface TaskFlowService extends TaskFlowStep,TaskService {
    /**
     * 任务步骤执行方法
     */
    public void execute(TaskFlowService currenTask, TaskFlowStepProxy nextProxy, OperateObj operateObj);

}
