package org.crazyit.activiti;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.IdentityLink;
import org.activiti.engine.task.Task;

public class JUELAuth {

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
		// 任务组件
		TaskService taskService = engine.getTaskService();
		// 部署流程文件
		repositoryService.createDeployment()
				.addClasspathResource("bpmn/JUELAuth.bpmn").deploy();
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("authService", new AuthService());
		// 启动流程
		ProcessInstance pi = runtimeService.startProcessInstanceByKey("process1", vars);
		// 查询第一个任务
		Task task = taskService.createTaskQuery().singleResult();
		System.out.println("第一个任务代理人：" + task.getAssignee());
		//完成第一个任务
		taskService.complete(task.getId());
		// 查询第二个任务
		task = taskService.createTaskQuery().singleResult();
		// 查询任务与用户的关联 
		List<IdentityLink> links = taskService.getIdentityLinksForTask(task.getId());
		System.out.println("第二个任务的候选用户：");//结果2
		for (IdentityLink link : links) {
			System.out.println("    " + link.getUserId());
		}
		//完成第二个任务
		taskService.complete(task.getId());
		// 查询第三个任务
		task = taskService.createTaskQuery().singleResult();
		links = taskService.getIdentityLinksForTask(task.getId());
		System.out.println("第三个任务的候选用户组：");//结果2
		for (IdentityLink link : links) {
			System.out.println("    " + link.getGroupId());
		}
		// 完成第三个任务
		taskService.complete(task.getId());
		// 查找第四个任务
		task = taskService.createTaskQuery().singleResult();
		System.out.println("第四个用户的代理人：" + task.getAssignee());
	}

}
