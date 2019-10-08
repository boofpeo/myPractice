package com.zhangyu.three.practicedemo.design.settle.service.impl;

import com.zhangyu.three.practicedemo.design.settle.service.AbstractTaskAdapterStep;
import com.zhangyu.three.practicedemo.design.settle.service.TaskFlowStep;

/**
 * @author yu.zhang
 * @Description: TODO
 * @date 2019/8/9 10:57
 */
public class DefaultTaskEngineImpl extends AbstractTaskAdapterStep {

    @Override
    protected void doWorkBefore(String obj) {
        return;
    }

    @Override
    protected void doWorkAfter(String obj) {
        return;
    }

    @Override
    protected boolean Ignore(String obj) {
        return false;
    }
}
