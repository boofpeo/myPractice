package com.zhangyu.three.Config.FlowType;

public enum FlowType {
    Oper(1,"经办"),
    Settle(2,"结算"),
    Batch(3,"批量"),
    OperFx(4,"外汇经办"),
    SettleFx(5,"外汇结算");
    private int flowType;
    private String flowTypeStr;
    private String flowTypeName;

    FlowType(int flowType, String flowTypeName) {
        this.flowType = flowType;
        this.flowTypeStr = flowType + "";
        this.flowTypeName = flowTypeName;
    }

    public int getFlowType() {
        return flowType;
    }

    public void setFlowType(int flowType) {
        this.flowType = flowType;
        //排除默认值0
        if (flowType == 0 ) {
            this.flowTypeStr = null;
            return;
        }
        this.flowTypeStr = flowType +"";
    }

    public String getFlowTypeStr() {
        return flowTypeStr;
    }

    public String getFlowTypeName() {
        return flowTypeName;
    }

    public void setFlowTypeName(String flowTypeName) {
        this.flowTypeName = flowTypeName;
    }

    private void test() throws Exception{
        FlowType[] enumConstants = this.getClass().getEnumConstants();
    }
}