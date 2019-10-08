package com.zhangyu.three.practicedemo.design.settle.service;

public interface TaskService {

    /**
     * 获取任务的Id
     */
    public String getTaskId();

    /**
     * 获取任务的名称 统一使用同一个大对象，包含操作的所有数据
     */
    public String getTaskName();

    /**
     * 任务操作
     */
    public void work();

    public void setWorkContext(String obj);
}
