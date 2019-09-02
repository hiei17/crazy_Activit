package org.crazyit.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

public class TerminateEndEvent {

	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到流程存储服务组件
		RepositoryService repositoryService = engine.getRepositoryService();
		// 得到运行时服务组件
		RuntimeService runtimeService = engine.getRuntimeService();
		// 部署流程文件
		repositoryService
				.createDeployment()
				.addClasspathResource(
						"bpmn/TerminateEndEvent_TerminateAll.bpmn")
				.addClasspathResource("bpmn/TerminateEndEvent.bpmn").deploy();
		// 启动含有terminateAll属性的流程
		ProcessInstance pi1 = runtimeService
				.startProcessInstanceByKey("terminateAll");
		// 查询执行流数量
		long exeCount = runtimeService.createExecutionQuery()
				.processInstanceId(pi1.getId()).count();
		System.out.println("含有 terminateAll 属性的流程，中断结束事件触发后执行流数量：" + exeCount);
		// 启动不含 有 terminateAll属性的流程
		ProcessInstance pi2 = runtimeService
				.startProcessInstanceByKey("terminateEvent");
		// 查询全部执行流数量
		exeCount = runtimeService.createExecutionQuery()
				.processInstanceId(pi2.getId()).count();
		System.out.println("不含有terminateAll 属性的流程，中断结束事件触发后执行流数量：" + exeCount);
	}

}
