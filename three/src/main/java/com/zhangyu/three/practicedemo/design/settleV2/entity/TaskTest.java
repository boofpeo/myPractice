package com.zhangyu.three.practicedemo.design.settleV2.entity;


import com.zhangyu.three.practicedemo.design.settleV2.TaskFlowStepProxy;
import com.zhangyu.three.practicedemo.design.settleV2.service.TaskFlowService;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author yu.zhang
 * @Description: TODO
 * @date 2019/8/9 15:41
 */
public class TaskTest {
//    public static void main(String[] args) {
//        LinkedList<TaskFlowService> list = new LinkedList<TaskFlowService>();
//        OperateObj obj = new OperateObj();
//        obj.setWorkResponse(WorkResponse.CONTINUE);
//        FirstTask firstTask = new FirstTask();
//        list.add(firstTask);
//        SecondTask secondTask = new SecondTask();
//        list.add(secondTask);
//        ThirdTask thirdTask = new ThirdTask();
//        list.add(thirdTask);
//        List<TaskFlowStepProxy> build = build(list);
//        build.get(0).execute(obj);
//    }

    public static void main(String[] args) {
        Map<String ,Obj> map = new HashMap<String, Obj>();
        Obj obj = new Obj();
        map.put("obj",obj);
        Obj obj1 = map.get("obj");
        obj1.setName("1111");
        System.out.println(obj1 == obj);
    }

    static class Obj {
        private String name ;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    public static List<TaskFlowStepProxy> build(LinkedList<TaskFlowService> list) {
        LinkedList<TaskFlowStepProxy> proxys = new LinkedList<TaskFlowStepProxy>();
        TaskFlowStepProxy lastProxy =  new TaskFlowStepProxy();
        if (list.size() > 0 ) {
            TaskFlowService lastTast = list.removeLast();
            lastProxy.setCurrent(lastTast);
            lastProxy.setNextProxy(null);
            proxys.addFirst(lastProxy);
        }
        while ( list.size() > 0) {
            TaskFlowService current = list.removeLast();
            TaskFlowStepProxy proxy = new TaskFlowStepProxy();
            proxy.setCurrent(current);
            proxy.setNextProxy(lastProxy);
            proxys.addFirst(proxy);
            lastProxy = proxy;
        }
        return proxys;
    }

    public boolean getLock(Long instId){
        boolean lock = false;
        Integer selectState=Math.random()>0.5?1:0;//根据instId查询数据库获取到状态 1表示未获取到锁 0 表示 已经有锁 null 表示未有数据插入
        if (selectState == 1) {
            lock = false;
        } else if (selectState == 0) {//          更新状态返回更新条数 防止同时查询到0的情况
            int updateRan = Math.random()>0.5?1:0;//          未更新到，已经有人更新，那么锁应该给已经更新的对象
            if ( updateRan == 0) {
                lock = false;
            } else {
                lock = true;
            }
        } else if(selectState == null) {//如果第一次操作(第一次点击经办复核)
            try {//          插入 通过唯一键和返回条数来控制获取到锁的唯一
                int insertRan = Math.random() > 0.5 ? 1 : 0;
                if(insertRan == 1) {
                    lock = true;
                } else {
                    lock = false;
                }
            }catch (Exception E) {
                lock = false;
            }
        }
        return lock;
    }
}
