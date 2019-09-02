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

public class SimpleCallActivity {

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
		// 任务服务组件
		TaskService taskService = engine.getTaskService();
		// 部署流程文件
		repositoryService
				.createDeployment()
				.addClasspathResource(
						"bpmn/SimpleCallActivity.bpmn")
				.addClasspathResource("bpmn/SubProcess.bpmn")
				.deploy();
		// 启动流程
		ProcessInstance pi = runtimeService
				.startProcessInstanceByKey("process1");
		// 查询任务
		Task task = taskService.createTaskQuery().processInstanceId(pi.getId())
				.singleResult();
		System.out.println("完成任务：" + task.getName());
		taskService.complete(task.getId());
		// 查询当前的流程实例
		List<ProcessInstance> pis = runtimeService.createProcessInstanceQuery()
				.list();
		System.out.println("当前的流程实例数量：" + pis.size());
		// 查询当前全部的执行流数量
		List<Execution> executions = runtimeService.createExecutionQuery()
				.list();
		System.out.println("当前执行流数量：" + executions.size());
		// 查询当前任务
		task = taskService.createTaskQuery().singleResult();
		System.out.println("当前任务名称：" + task.getName());
	}

}
