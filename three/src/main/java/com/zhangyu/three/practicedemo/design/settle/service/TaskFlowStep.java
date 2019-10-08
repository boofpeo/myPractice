package com.zhangyu.three.practicedemo.design.settle.service;

public interface TaskFlowStep {

    /**
     * 任务步骤执行方法
     */
    public void execute();

    public void setTaskService(TaskService taskService);

    public void setNextFlowStep(TaskFlowStep nextFlowStep);

    public void setObj(String obj);
}
