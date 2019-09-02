package org.crazyit.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;

public class MessageStartEvent {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到流程存储服务组件
		RepositoryService repositoryService = engine.getRepositoryService();
		// 得到运行时服务组件
		RuntimeService runtimeService = engine.getRuntimeService();
		// 部署流程文件
		repositoryService.createDeployment()
			.addClasspathResource("bpmn/MessageStartEvent.bpmn").deploy();	
		// 启动流程
		runtimeService.startProcessInstanceByMessage("msgA");
		// 查询流程
		System.out.println("流程实例数量：" + runtimeService.createProcessInstanceQuery().count());
	}

}
