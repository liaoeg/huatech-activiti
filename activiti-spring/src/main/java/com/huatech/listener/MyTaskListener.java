package com.huatech.listener;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 * 监听器
 * @author 廖恩光
 * @version 1.0
 * @date 2021/3/19 9:24
 */
public class MyTaskListener implements TaskListener {

    public void notify(DelegateTask delegateTask) {
        //        判断当前的任务 是 创建申请 并且  是 create事件
        if("创建申请".equals(delegateTask.getName()) &&
                "create".equals(delegateTask.getEventName())){
            delegateTask.setAssignee("张三");
        }
    }


}
