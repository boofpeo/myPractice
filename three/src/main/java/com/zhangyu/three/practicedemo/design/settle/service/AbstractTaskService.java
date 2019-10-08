package com.zhangyu.three.practicedemo.design.settle.service;

/**
 * @author yu.zhang
 * @Description: TODO
 * @date 2019/8/9 10:29
 */
public abstract class AbstractTaskService implements TaskService {

//  操作的对象
    private String obj;

    public void setWorkContext(String obj) {
        this.obj = obj;
    }
    /**
     * 任务操作
     */
    public void work() {
        doCheck(obj);
        doWork(obj);
    }

    /**
     * 任务的检查 统一使用同一个大对象，包含操作的所有数据
     */
    protected abstract void doCheck(String obj);

    /**
     * 当前任务是否忽略
     */
    protected abstract boolean Ignore();

    /**
     * 任务的工作方法
     */
    protected abstract void doWork(String obj);

}
