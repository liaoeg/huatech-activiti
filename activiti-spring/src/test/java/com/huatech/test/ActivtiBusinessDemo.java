package com.huatech.test;

import org.activiti.engine.*;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

/**
 * @author 廖恩光
 * @version 1.0
 * @date 2021/3/18 15:02
 */
public class ActivtiBusinessDemo {

    /**
     * 启动流程实例，添加businessKey
     */
    @Test
    public void addBusinessKey(){
//        1、得到ProcessEngine
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
//        2、得到RunTimeService
        RuntimeService runtimeService = processEngine.getRuntimeService();
//        3、启动流程实例，同时还要指定业务标识businessKey，也就是出差申请单id，这里是1001
        ProcessInstance processInstance = runtimeService.
                startProcessInstanceByKey("myEvection","1001");
//        4、输出processInstance相关属性
        System.out.println("业务id=="+processInstance.getBusinessKey());

    }

    /**
     * 全部流程实例的 挂起和 激活
     * suspend 暂停
     */
    @Test
    public void suspendAllProcessInstance(){
//        1、获取流程引擎
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
//        2、获取Repositoryservice
        RepositoryService repositoryService = processEngine.getRepositoryService();
//        3、查询流程定义,获取流程定义的查询对象
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .processDefinitionKey("myEvection")
                .singleResult();
//        4、获取当前流程定义的实例是否都是挂起状态
        boolean suspended = processDefinition.isSuspended();
//        5、获取流程定义的id
        String definitionId = processDefinition.getId();
//        6、如果是挂起状态，改为激活状态
        if(suspended){
//            如果是挂起，可以执行激活的操作,参数1：流程定义id 参数2：是否激活，参数3：激活时间
            repositoryService.activateProcessDefinitionById(definitionId,
                    true,
                    null);
            System.out.println("流程定义id:"+definitionId+"，已激活");
        }else {
//        7、如果是激活状态，改为挂起状态,参数1：流程定义id 参数2：是否暂停 参数3 ：暂停的时间
            repositoryService.suspendProcessDefinitionById(definitionId,
                    true,
                    null);
            System.out.println("流程定义id:"+definitionId+"，已挂起");
        }
    }

    /**
     * 挂起、激活单个流程实例
     */
    @Test
    public void suspendSingleProcessInstance(){
//        1、获取流程引擎
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
//        2、RuntimeService
        RuntimeService runtimeService = processEngine.getRuntimeService();
//        3、通过RuntimeService获取流程实例对象
        ProcessInstance instance = runtimeService.createProcessInstanceQuery()
                .processInstanceId("15001")
                .singleResult();
//        4、得到当前流程实例的暂停状态,true-已暂停  false -激活
        boolean suspended = instance.isSuspended();
//        5、获取流程实例id
        String instanceId = instance.getId();
//        6、判断是否已经暂停，如果已经暂停，就执行激活操作
        if(suspended){
//            如果已经暂停，就执行激活
            runtimeService.activateProcessInstanceById(instanceId);
            System.out.println("流程实例id:"+instanceId+"已经激活");
        }else {
//        7、如果是激活状态，就执行暂停操作
            runtimeService.suspendProcessInstanceById(instanceId);
            System.out.println("流程实例id:"+instanceId+"已经暂停");
        }
    }

    /**
     * 完成个人任务
     */
    @Test
    public void completTask(){
//        1、获取流程引擎
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
//        2、获取TaskService
        TaskService taskService = processEngine.getTaskService();
//        3、使用taskservice获取任务,参数 流程实例的id，负责人
        Task task = taskService.createTaskQuery()
                .processInstanceId("15001")
                .taskAssignee("zhangsan")
                .singleResult();
        System.out.println("流程实例id=="+task.getProcessInstanceId());
        System.out.println("流程任务id=="+task.getId());
        System.out.println("负责人=="+task.getAssignee());
        System.out.println("任务名称=="+task.getName());
//        4、根据任务的id完成任务
        taskService.complete(task.getId());
    }

}
