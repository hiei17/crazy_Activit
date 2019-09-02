package org.crazyit.activiti;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

/**
 * 删除历史任务数据
 * 
 * @author yangenxiong
 * 
 */
public class Delete {

	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到流程存储服务实例
		RepositoryService repositoryService = engine.getRepositoryService();
		// 得到运行时服务组件
		RuntimeService runtimeService = engine.getRuntimeService();
		// 得到历史服务组件
		HistoryService historyService = engine.getHistoryService();
		// 任务组件
		TaskService taskService = engine.getTaskService();
		// 部署流程文件
		repositoryService.createDeployment()
				.addClasspathResource("bpmn/Delete.bpmn").deploy();
		// 开始流程
		ProcessInstance pi1 = runtimeService
				.startProcessInstanceByKey("testProcess");
		ProcessInstance pi2 = runtimeService
				.startProcessInstanceByKey("testProcess");
		// 完成第一个流程实例
		Task task = taskService.createTaskQuery()
				.processInstanceId(pi1.getId()).singleResult();
		taskService.setVariableLocal(task.getId(), "name", "crazyit");
		taskService.complete(task.getId());

		task = taskService.createTaskQuery()
				.processInstanceId(pi1.getId()).singleResult();
		taskService.complete(task.getId());
		
		
		// 第二个流程实例完成第一个节点
		task = taskService.createTaskQuery().processInstanceId(pi2.getId())
				.singleResult();
		taskService.complete(task.getId());

		System.out.println("删除前任务数量："
				+ historyService.createHistoricTaskInstanceQuery().count());
		// 删除第二个流程实例的历史任务数据
		historyService.deleteHistoricTaskInstance(task.getId());
		System.out.println("删除后任务数量："
				+ historyService.createHistoricTaskInstanceQuery().count());
		System.out.println("删除前流程实例数量："
				+ historyService.createHistoricProcessInstanceQuery().count());
		// 删除第一个流程实例的历史流程数据
		historyService.deleteHistoricProcessInstance(pi1.getId());
		// 抛出错误，删除没有完成的流程实例历史数据
		historyService.deleteHistoricProcessInstance(pi2.getId());
		System.out.println("删除后流程实例数量："
				+ historyService.createHistoricProcessInstanceQuery().count());
	}

}
