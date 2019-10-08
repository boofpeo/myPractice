package com.zhangyu.three.practicedemo.design.settle.entity;

import com.zhangyu.three.practicedemo.design.settle.service.TaskFlowStep;
import com.zhangyu.three.practicedemo.design.settle.service.TaskService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yu.zhang
 * @Description: TODO
 * @date 2019/8/9 11:01
 */
public class Test {

    public static void main(String[] args) {
        LinkedList<TaskService> list = new LinkedList<TaskService>();
        String obj = "operate Object";
        FirstTask firstTask = new FirstTask();
        list.add(firstTask);
        NextTask nextTask = new NextTask();
        list.add(nextTask);
//        build(list);
    }
//    public static void build(LinkedList<TaskService> list){
//        List<TaskFlowStep> taskFlowSteps = new ArrayList<TaskFlowStep>();
//        if (list.size() > 0 ) {
//            TaskService lastService = list.removeLast();
//            TaskFlowStep lastTaskFlowStep
//        }
//        while ( list.size() > 0){
//            System.out.println(list.size());
//            TaskService taskService = list.removeLast();
//            System.out.println(list.size() + taskService.getTaskId());
//        }
//    }

}
