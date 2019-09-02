package org.crazyit.activiti;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

public class Inclusive {

	public static void main(String[] args) {
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
				.addClasspathResource("bpmn/Inclusive.bpmn").deploy();
		// 初始化参数
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("days", 6);
		ProcessInstance pi1 = runtimeService.startProcessInstanceByKey(
				"process1", vars);
		// 完成填写申请任务
		Task task = taskService.createTaskQuery()
				.processInstanceId(pi1.getId()).singleResult();
		System.out.println("当前任务：" + task.getName());
		taskService.complete(task.getId());
		// 查询执行流
		List<Execution> exes = runtimeService.createExecutionQuery()
				.processInstanceId(pi1.getId()).list();
		System.out.println("参数为6时执行流数量：" + exes.size());
		// 完成全部任务
		List<Task> tasks = taskService.createTaskQuery()
				.processInstanceId(pi1.getId()).list();
		for (Task taskObj : tasks) {
			taskService.complete(taskObj.getId());
		}
		// 完成总经理审批任务
		task = taskService.createTaskQuery().processInstanceId(pi1.getId())
				.singleResult();
		System.out.println("当前任务：" + task.getName());
		taskService.complete(task.getId());
		System.out.println("再次启动流程=============");
		// 再次启动流程，参数为10
		vars.put("days", 10);
		ProcessInstance pi2 = runtimeService.startProcessInstanceByKey(
				"process1", vars);
		// 完成填写申请任务
		task = taskService.createTaskQuery().processInstanceId(pi2.getId())
				.singleResult();
		System.out.println("当前任务：" + task.getName());
		taskService.complete(task.getId());
		// 查询执行流
		exes = runtimeService.createExecutionQuery()
				.processInstanceId(pi2.getId()).list();
		System.out.println("参数为10时执行流数量：" + exes.size());
	}

}
