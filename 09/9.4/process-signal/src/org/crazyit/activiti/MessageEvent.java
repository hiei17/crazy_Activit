package org.crazyit.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * 使用 messageEventReceived 方法
 * 
 * @author yangenxiong
 *
 */
public class MessageEvent {

	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到流程存储服务实例
		RepositoryService repositoryService = engine.getRepositoryService();
		// 得到运行时服务组件
		RuntimeService runtimeService = engine.getRuntimeService();
		// 部署流程描述文件
		repositoryService.createDeployment()
				.addClasspathResource("bpmn/MessageEvent.bpmn").deploy();
		// 开始流流程
		ProcessInstance testProcess = runtimeService.startProcessInstanceByKey("testProcess");
		// 查询当前节点
		Execution exe = runtimeService.createExecutionQuery()
				.activityId("messageintermediatecatchevent1").singleResult();
		System.out.println("当前流程节点：" + exe.getActivityId());
		// 触发消息事件
		runtimeService.messageEventReceived("testMsg", exe.getId());
		// 查询当前事件
		exe = runtimeService.createExecutionQuery().activityId("usertask1")
				.singleResult();
		System.out.println("当前流程节点：" + exe.getActivityId());
	}

}
