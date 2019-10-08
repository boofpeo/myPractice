package com.zhangyu.three.practicedemo.design.settleV2.entity;

/**
 * @author yu.zhang
 * @Description: 任务的自定义配置JSON转实体
 * @date 2019/8/13 14:21
 */
public class TaskInitParam {

    private int needHandCheck;

    private String ko;

    public String getKo() {
        return ko;
    }

    public void setKo(String ko) {
        this.ko = ko;
    }

    public int getNeedHandCheck() {
        return needHandCheck;
    }

    public void setNeedHandCheck(int needHandCheck) {
        this.needHandCheck = needHandCheck;
    }
}
