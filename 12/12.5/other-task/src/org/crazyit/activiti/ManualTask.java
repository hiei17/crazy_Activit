package org.crazyit.activiti;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

public class ManualTask {

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
		// 获取任务服务组件
		TaskService taskService = engine.getTaskService();
		// 部署流程文件
		repositoryService.createDeployment()
				.addClasspathResource("bpmn/ManualTask.bpmn").deploy();
		// 启动流程
		ProcessInstance pi = runtimeService
				.startProcessInstanceByKey("process1");
		// 查询当前任务
		List<Task> tasks = taskService.createTaskQuery().list();
		System.out.println("执行手工任务之后、接收任务之前的任务数量：" + tasks.size());
		List<ProcessInstance> pis = runtimeService.createProcessInstanceQuery()
				.list();
		System.out.println("执行手工任务之后、接收任务之前的流程实例数量：" + pis.size());
		Execution exe = runtimeService.createExecutionQuery()
				.processInstanceId(pi.getId()).onlyChildExecutions()
				.singleResult();
		// 让流程向前执行
		runtimeService.trigger(exe.getId());
		// 查询流程
		pis = runtimeService.createProcessInstanceQuery().list();
		System.out.println("执行接收任务后的流程实例数量：" + pis.size());
	}

}
