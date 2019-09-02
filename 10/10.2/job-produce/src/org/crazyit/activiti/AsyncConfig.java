package org.crazyit.activiti;

import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * 异步任务产生工作
 * @author yangenxiong
 *
 */
public class AsyncConfig {

	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到流程存储服务实例
		RepositoryService repositoryService = engine.getRepositoryService();
		// 得到管理服务实例
		ManagementService managementService = engine.getManagementService();
		// 得到运行时服务组件
		RuntimeService runtimeService = engine.getRuntimeService();
		// 部署流程文件
		repositoryService.createDeployment().addClasspathResource("bpmn/async-continuation.bpmn")
			.deploy();	
		// 产生由async-continuation处理的工作
		ProcessInstance pi1 = runtimeService.startProcessInstanceByKey("async-continuation");
		// 查询工作数量
		System.out.println("工作数量：" + managementService.createJobQuery().count());		
	}

}
