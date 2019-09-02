package org.crazyit.activiti;

import org.activiti.engine.*;
import org.activiti.engine.task.Task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 错误结束事件
 * @author yangenxiong
 *
 */
public class ErrorEndEvent {

	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到流程存储服务组件
		RepositoryService repositoryService = engine.getRepositoryService();
		// 得到运行时服务组件
		RuntimeService runtimeService = engine.getRuntimeService();
		//获取流程任务组件
		TaskService taskService = engine.getTaskService();
		// 部署流程文件
		repositoryService.createDeployment()
			.addClasspathResource("bpmn/ErrorEndEvent.bpmn").deploy();
		// 启动流程
		runtimeService.startProcessInstanceByKey("errorEndProcess");		
		// 结束子流程中的任务，并设置结束参数
		Task subTask = taskService.createTaskQuery().singleResult();
		Map<String, Object> vars = new HashMap<String, Object>();
		//设置success参数
		vars.put("success", "false");
		taskService.complete(subTask.getId(), vars);

		// 查看到达的任务
		List<Task> tasks = taskService.createTaskQuery().list();
		for (Task task : tasks) {
			System.out.println(task.getName());
		}
	}

}
