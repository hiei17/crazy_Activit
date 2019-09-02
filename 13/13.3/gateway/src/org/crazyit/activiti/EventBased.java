package org.crazyit.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

public class EventBased {

	public static void main(String[] args) throws Exception {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到流程存储服务组件
		RepositoryService repositoryService = engine.getRepositoryService();
		// 得到运行时服务组件
		RuntimeService runtimeService = engine.getRuntimeService();
		// 得到任务服务组件
		TaskService taskService = engine.getTaskService();
		// 部署流程文件
		repositoryService.createDeployment()
				.addClasspathResource("bpmn/EventBased.bpmn").deploy();
		// 启动流程
		ProcessInstance pi = runtimeService
				.startProcessInstanceByKey("process1");
		// 发送消息
		runtimeService.signalEventReceived("mySignal");
		// 查询当前任务
		Task task = taskService.createTaskQuery().processInstanceId(pi.getId())
				.singleResult();
		System.out.println("当前任务：" + task.getName());
		// 完成任务，结束流程
		taskService.complete(task.getId());
		// 重新启动流程
		ProcessInstance pi2 = runtimeService
				.startProcessInstanceByKey("process1");
		System.out.println("第二次启动流程");
		// 暂停10秒，等待定时器事件触发
		Thread.sleep(10000);
		// 查询当前任务
		task = taskService.createTaskQuery().processInstanceId(pi2.getId())
				.singleResult();
		System.out.println("当前任务：" + task.getName());
	}

}
