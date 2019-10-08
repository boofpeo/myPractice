package com.zhangyu.three.Config.FlowType;

/**
 * @author yu.zhang
 * @Description: TODO
 * @date 2019/8/30 13:40
 */
public class tll {
    public static void main(String[] args) {
        Class<FlowType> flowTypeClass = FlowType.class;
        // 2.得到所有枚举常量
        FlowType[] objects = flowTypeClass.getEnumConstants();
        for (FlowType obj : objects){
            // 3.调用对应方法，得到枚举常量中字段的值
        }
    }
}
