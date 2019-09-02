package org.crazyit.activiti;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

public class DataMultiInstance {

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
				.addClasspathResource("bpmn/DataMultiInstance.bpmn").deploy();
		// 初始化参数
		Map<String, Object> vars = new HashMap<String, Object>();
		List<String> datas1 = new ArrayList<String>();
		datas1.add("a");
		datas1.add("b");
		List<String> datas2 = new ArrayList<String>();
		datas2.add("c");
		datas2.add("d");
		datas2.add("e");
		vars.put("datas1", datas1);
		vars.put("datas2", datas2);
		// 启动流程
		ProcessInstance pi = runtimeService.startProcessInstanceByKey(
				"process1", vars);
		// 循环完成第一个任务的全部实例
		List<Task> tasks = taskService.createTaskQuery()
				.processInstanceId(pi.getId()).list();
		System.out.println("第一个任务的实例数量：" + tasks.size());
		// 完成全部任务
		for (Task task : tasks) {
			taskService.complete(task.getId());
		}
		tasks = taskService.createTaskQuery().processInstanceId(pi.getId())
				.list();
		System.out.println("第二个任务的实例数量：" + tasks.size());
	}

}
