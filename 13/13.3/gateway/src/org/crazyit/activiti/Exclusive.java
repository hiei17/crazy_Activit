package org.crazyit.activiti;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

public class Exclusive {

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
		repositoryService
				.createDeployment()
				.addClasspathResource(
						"bpmn/Exclusive.bpmn")
				.deploy();
		// 初始化参数
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("days", 6);
		ProcessInstance pi = runtimeService.startProcessInstanceByKey("process1", vars);
		// 查询当前任务
		Task task = taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();
		System.out.println("当前任务：" + task.getName());
		//完成任务，设置参数为10
		vars.put("days", 10);
		taskService.complete(task.getId(), vars);
		// 查询当前任务
		task = taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();
		System.out.println("当前任务：" + task.getName());
		// 完成任务，设置参数为15
		vars.put("days", 15);
		// 此时会抛出异常
		taskService.complete(task.getId(), vars);
	}

}
