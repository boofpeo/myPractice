package com.zhangyu.three.practicedemo.design.settleV2.service;

import com.zhangyu.three.practicedemo.design.settleV2.TaskFlowStepProxy;
import com.zhangyu.three.practicedemo.design.settleV2.entity.OperateObj;
import com.zhangyu.three.practicedemo.design.settleV2.entity.WorkResponse;

/**
 * @author yu.zhang
 * @Description: TODO
 * @date 2019/8/9 14:31
 */
public abstract class AbstractTaskFlowAdapterService implements TaskFlowService {

    protected String task;

    @Override
    public void execute(OperateObj obj) {

    }

    @Override
    public void execute(TaskFlowService currenTask, TaskFlowStepProxy nextProxy, OperateObj operateObj) {
        WorkResponse currentWorkResponse = operateObj.getWorkResponse();
        if (WorkResponse.CONTINUE == currentWorkResponse) {
            WorkResponse workResponse = doWorkBefore();
            if (workResponse == null) {
                throw new RuntimeException("不能为空就是了");
            }
            operateObj.setWorkResponse(workResponse);
        }
        if (WorkResponse.CONTINUE == currentWorkResponse) {
            WorkResponse workResponse = doWork();
            if (workResponse == null) {
                throw new RuntimeException("不能为空就是了");
            }
            operateObj.setWorkResponse(workResponse);
        }
        if (WorkResponse.CONTINUE == currentWorkResponse) {
            WorkResponse workResponse = doWorkAfter();
            if (workResponse == null) {
                throw new RuntimeException("不能为空就是了");
            }
            operateObj.setWorkResponse(workResponse);
        }
        if (WorkResponse.CONTINUE == currentWorkResponse) {
            if (nextProxy == null) {
                return;
            }
            nextProxy.execute(operateObj);
        }
    }

    /**
     * 任务流工作前方法
     */
    protected abstract WorkResponse doWorkBefore();

    /**
     * 任务流工作后方法
     */
    protected abstract WorkResponse doWorkAfter();

    protected abstract WorkResponse doWork();
}
