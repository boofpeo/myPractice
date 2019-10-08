package com.zhangyu.three.practicedemo.design.settle.service;

/**
 * @author yu.zhang
 * @Description: TODO
 * @date 2019/8/9 10:35
 */
public abstract class AbstractTaskAdapterStep implements TaskFlowStep {

    //  当前步骤执行的流程
    private TaskService taskService;

    private TaskFlowStep nextFlowStep;

    private String obj;

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    public void setNextFlowStep(TaskFlowStep nextFlowStep) {
        this.nextFlowStep = nextFlowStep;
    }

    public void setObj(String obj) {
        this.obj = obj;
    }

    public void execute() {
        taskService.setWorkContext(obj);
        doWorkBefore(obj);
        taskService.work();
        doWorkAfter(obj);
        nextFlowStep.execute();
    }


    /**
     * 任务流工作前方法
     */
    protected abstract void doWorkBefore(String obj);

    /**
     * 任务流工作后方法
     */
    protected abstract void doWorkAfter(String obj);

    /**
     * 当前任务是否忽略
     */
    protected abstract boolean Ignore(String obj);
}
