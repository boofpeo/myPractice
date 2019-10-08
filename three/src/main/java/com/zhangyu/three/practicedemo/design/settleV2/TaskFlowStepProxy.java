package com.zhangyu.three.practicedemo.design.settleV2;

import com.zhangyu.three.practicedemo.design.settleV2.entity.OperateObj;
import com.zhangyu.three.practicedemo.design.settleV2.service.TaskFlowService;
import com.zhangyu.three.practicedemo.design.settleV2.service.TaskFlowStep;

/**
 * @author yu.zhang
 * @Description: TODO
 * @date 2019/8/9 14:20
 */
public class TaskFlowStepProxy  implements TaskFlowStep {

    private TaskFlowService current;

    private TaskFlowStepProxy nextProxy;

    public void setCurrent(TaskFlowService current) {
        this.current = current;
    }

    public void setNextProxy(TaskFlowStepProxy nextProxy) {
        this.nextProxy = nextProxy;
    }

    public TaskFlowService getCurrent() {
        return current;
    }

    @Override
    public void execute(OperateObj operateObj) {
        current.execute(current, nextProxy, operateObj);
    }

    public void prin(){
        System.out.println("current : " + current.getTaskId() + "   nextCurren :" + (nextProxy != null ? nextProxy.getCurrent().getTaskId(): null));
    }

}
