package org.crazyit.activiti;

import java.io.Serializable;
import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

/**
 * 使用activiti扩展属性分配任务角色
 * @author yangenxiong
 *
 */
public class HumanExtention implements Serializable {
	
	public void user() {
		System.out.println("users");
	}

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
				.addClasspathResource("bpmn/HumanExtention.bpmn").deploy();
		// 启动流程
		ProcessInstance pi = runtimeService.startProcessInstanceByKey("process1");
		List<Task> tasks = taskService.createTaskQuery().taskAssignee("user1").list();
		System.out.println(tasks.size());		
		//完成任务1，当前为任务2，可以看到 activiti:candidateUsers="user1, user2" 效果
		Task task = taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();
		taskService.complete(task.getId());
		tasks = taskService.createTaskQuery().taskCandidateUser("user1").list();
		System.out.println(tasks.size());
		//完成任务2，当前为任务3，可以看到 activiti:candidateGroups="group1,group2" 效果
		task = taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();
		taskService.complete(task.getId());
		tasks = taskService.createTaskQuery().taskCandidateGroup("group1").list();
		System.out.println(tasks.size());
	}

}
