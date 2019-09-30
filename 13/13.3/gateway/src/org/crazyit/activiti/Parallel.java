package org.crazyit.activiti;

import org.activiti.engine.*;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parallel {

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
				.addClasspathResource("bpmn/Parallel.bpmn").deploy();
		// 启动流程
		ProcessInstance pi = runtimeService
				.startProcessInstanceByKey("process1");



		// 完成填写申请任务并设置参数
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("days", 6);
		Task task = taskService.createTaskQuery().processInstanceId(pi.getId())
				.singleResult();
		taskService.complete(task.getId(), vars);

		// 查询执行流数量
		List<Execution> exes = runtimeService.createExecutionQuery()
				.processInstanceId(pi.getId()).list();
		System.out.println("当前的执行流数量：" + exes.size());

		// 完成任务1
		task = taskService.createTaskQuery().processInstanceId(pi.getId())
				.taskName("task1").singleResult();

		System.out.println("当前任务：" + task.getName());
		taskService.complete(task.getId(), vars);
		System.out.println("完成任务：" + task.getName());

		// 查询执行流数量
		exes = runtimeService.createExecutionQuery()
				.processInstanceId(pi.getId()).list();
		System.out.println("当前执行流数量：" + exes.size());

		// 完成并行任务2
		task = taskService.createTaskQuery().processInstanceId(pi.getId())
				.taskName("task2").singleResult();
		System.out.println("当前任务：" + task.getName());

		taskService.complete(task.getId(), vars);
		System.out.println("完成任务:"+task.getName());

		// 查询执行流数量
		exes = runtimeService.createExecutionQuery()
				.processInstanceId(pi.getId()).list();
		System.out.println("当前执行流数量：" + exes.size());

		engine.close();
	}

}
