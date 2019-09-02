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

public class CallActivityVariable {

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
						"bpmn/CallActivityVariable.bpmn")
				.addClasspathResource("bpmn/SubProcess.bpmn")
				.deploy();		
		// 启动流程
		ProcessInstance pi = runtimeService
				.startProcessInstanceByKey("process1");
		// 完成填写申请任务并设置参数
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("days", 10);
		Task task = taskService.createTaskQuery().singleResult();
		taskService.complete(task.getId(), vars);
		// 查询新建的流程实例
		ProcessInstance subPi = runtimeService.createProcessInstanceQuery()
				.processDefinitionKey("SubProcess").singleResult();
		// 在主流程中查询参数
		Integer days = (Integer) runtimeService.getVariable(pi.getId(), "days");
		System.out.println("使用days名称查询参数：" + days);
		// 在调用式子流程中查询参数
		days = (Integer) runtimeService.getVariable(subPi.getId(), "newDays");
		System.out.println("使用newDays名称查询参数：" + days);
		// 设置流程参数
		runtimeService.setVariable(subPi.getId(), "myDays", (days - 5));
		// 完成子流程全部任务
		task = taskService.createTaskQuery().singleResult();
		System.out.println("当前任务：" + task.getName());
		taskService.complete(task.getId());
		task = taskService.createTaskQuery().singleResult();
		System.out.println("当前任务：" + task.getName());
		taskService.complete(task.getId());
		// 在主流程中查询参数
		days = (Integer) runtimeService.getVariable(pi.getId(), "resultDays");
		System.out.println("使用resultDays名称查询参数：" + days);
	}

}
