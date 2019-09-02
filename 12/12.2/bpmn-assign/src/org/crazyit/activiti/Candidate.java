package org.crazyit.activiti;

import org.activiti.engine.*;
import org.activiti.engine.task.Task;

import java.util.List;

public class Candidate {

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
		TaskService taskService = engine.getTaskService();
		// 部署流程文件
		repositoryService.createDeployment()
				.addClasspathResource("bpmn/Candidate.bpmn").deploy();
		// 启动流程
		runtimeService.startProcessInstanceByKey("process1");

		// 根据用户组查询任务 因为xml里面配了
		List<Task> tasks = taskService
				.createTaskQuery()
				.taskCandidateGroup("boss")
				.list();
		System.out.println("分配到boss用户组下的任务数量：" + tasks.size());

		// 根据用户查询任务
		tasks = taskService
				.createTaskQuery()
				.taskCandidateUser("angus")
				.list();
		System.out.println("用户angus下的任务数量为：" + tasks.size());

		tasks.forEach(t->taskService.complete(t.getId()));
	}

}
