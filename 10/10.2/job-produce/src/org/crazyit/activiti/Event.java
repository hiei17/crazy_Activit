package org.crazyit.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

/**
 * 流程抛出事件产生的工作
 * @author yangenxiong
 *
 */
public class Event {

	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到流程存储服务实例
		RepositoryService repositoryService = engine.getRepositoryService();
		// 得到运行时服务组件
		RuntimeService runtimeService = engine.getRuntimeService();
		// 任务服务组件
		TaskService taskService = engine.getTaskService();
		// 部署流程文件
		repositoryService
				.createDeployment()
				.addClasspathResource("bpmn/event.bpmn")
				.deploy();		
		runtimeService.startProcessInstanceByKey("event");
		// 将task1的工作完成后，就会产生工作 
		Task task = taskService.createTaskQuery().taskName("Task1").singleResult();
		taskService.complete(task.getId());
		// 查询工作数量
		System.out.println("工作数量：" + engine.getManagementService().createJobQuery().count());	
	}

}
