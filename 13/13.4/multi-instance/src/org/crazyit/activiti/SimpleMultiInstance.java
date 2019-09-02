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

public class SimpleMultiInstance {

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
		// 得到任务服务组件
		TaskService taskService = engine.getTaskService();
		// 部署流程文件
		repositoryService.createDeployment()
				.addClasspathResource("bpmn/SimpleMultiInstance.bpmn").deploy();
		// 启动流程
		ProcessInstance pi = runtimeService
				.startProcessInstanceByKey("process1");
		// 查询执行流
		List<Execution> exes = runtimeService.createExecutionQuery()
				.processInstanceId(pi.getId()).list();
		System.out.println("使用顺序执行的多实例活动，流程数量：" + exes.size());
		// 完成全部任务
		for (int i = 0; i < 2; i++) {
			Task task = taskService.createTaskQuery()
					.processInstanceId(pi.getId()).singleResult();
			System.out.println("任务id：" + task.getId());
			taskService.complete(task.getId());
		}
		// 流程到达第二个多实例活动（并行的）
		exes = runtimeService.createExecutionQuery()
				.processInstanceId(pi.getId()).list();
		System.out.println("使用并行执行的多实例活动，流程数量：" + exes.size());
	}

}
