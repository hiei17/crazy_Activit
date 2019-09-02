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
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

public class Converge {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		RepositoryService repositoryService = engine.getRepositoryService();
		TaskService taskService = engine.getTaskService();
		RuntimeService runtimeService = engine.getRuntimeService();
		// 部署文件
		Deployment dep = repositoryService.createDeployment()
				.addClasspathResource("bpmn/Converge_1.bpmn").deploy();
		// 流程定义
		ProcessDefinition pd = repositoryService.createProcessDefinitionQuery()
				.deploymentId(dep.getId()).singleResult();
		// 初始化多实例任务的数据 
		List<Integer> datas = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			datas.add(i);
		}
		// 初始化流程参数
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("datas", datas);
		vars.put("pass", true);
		// 启动流程
		ProcessInstance pi = runtimeService.startProcessInstanceByKey(
				"Converge", vars);
		// 任务查询
		List<Task> tasks = taskService.createTaskQuery()
				.processInstanceId(pi.getId()).list();
		System.out.println("当前任务总数：" + tasks.size());
		// 完成第三个任务，否决会签
		Map<String, Object> taskResult = new HashMap<String, Object>();
		taskResult.put("pass", false);
		taskService.complete(tasks.get(2).getId(), taskResult);
		// 流程实例为null，流程结束
		ProcessInstance currentPi = runtimeService.createProcessInstanceQuery()
				.processDefinitionId(pd.getId()).singleResult();
		System.out.println(currentPi);
	}

}
