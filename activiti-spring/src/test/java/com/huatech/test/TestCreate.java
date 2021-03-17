package com.huatech.test;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.junit.Test;

/**
 * @author 廖恩光
 * @version 1.0
 * @date 2021/3/16 14:52
 */
public class TestCreate {

    /**
     * 生成 activiti的数据库表
     */
    @Test
    public void testCreateDbTable() {
//        需要使用avtiviti提供的工具类 ProcessEngines ,使用方法getDefaultProcessEngine
//        getDefaultProcessEngine会默认从resources下读取名字为actviti.cfg.xml的文件
//        创建processEngine时，就会创建mysql的表
//
//        默认方式
//        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
//        RepositoryService repositoryService = processEngine.getRepositoryService();
//        repositoryService.createDeployment();
//
//        使用自定义方式
//        配置文件的名字可以自定义,bean的名字也可以自定义
        ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration.
                createProcessEngineConfigurationFromResource("activiti.cfg.xml",
                        "processEngineConfiguration");

//        获取流程引擎对象
        ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();

        RuntimeService runtimeService = processEngine.getRuntimeService();
        System.out.println(processEngine);



    }

}
