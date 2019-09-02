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
import org.crazyit.activiti.webservice.Sale;

public class WebService {

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
				.addClasspathResource("bpmn/WebService.bpmn").deploy();
		// 初始化参数
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("creatorVar", "angus");
		vars.put("createDateVar", "2018-02-02 10:10:10");
		ProcessInstance pi = runtimeService.startProcessInstanceByKey(
				"testProcess", vars);
		// 完成第一个任务
		Task task = taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();
		taskService.complete(task.getId());
		// 输出调用Web Service后的参数
		Sale sale = (Sale) runtimeService.getVariable(pi.getId(), "saleVar");
		System.out.println("请求创建销售单后，返回的销售单号：" + sale.getSaleCode());
	}

}
