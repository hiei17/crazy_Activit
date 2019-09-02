package org.crazyit.activiti;

import java.util.List;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

/**
 * 查询历史流程实例
 * @author yangenxiong
 *
 */
public class ProcessInstanceQuery {

	public static void main(String[] args) throws Exception {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到流程存储服务实例
		RepositoryService repositoryService = engine.getRepositoryService();
		// 得到运行时服务组件
		RuntimeService runtimeService = engine.getRuntimeService();
		// 得到历史服务组件
		HistoryService historyService = engine.getHistoryService();
		TaskService taskService = engine.getTaskService();
		// 部署流程文件
		Deployment deploy = repositoryService.createDeployment()
				.addClasspathResource("bpmn/ProcessInstanceQuery.bpmn").deploy();
		// 查询流程定义 
		ProcessDefinition define = repositoryService
				.createProcessDefinitionQuery().deploymentId(deploy.getId()).singleResult();
		// 开始流程
		ProcessInstance pi1 = runtimeService.startProcessInstanceByKey("testProcess", "businessKey1");
		ProcessInstance pi2 = runtimeService.startProcessInstanceByKey("testProcess", "businessKey2");
		// 完成第一条流程
		Task task = taskService.createTaskQuery().processInstanceId(pi1.getId()).singleResult();
		taskService.complete(task.getId());
		task = taskService.createTaskQuery().processInstanceId(pi1.getId()).singleResult();
		taskService.complete(task.getId());
		// 查询已完成的流程
		List<HistoricProcessInstance> datas = historyService
				.createHistoricProcessInstanceQuery().finished().list();
		System.out.println("使用finished方法：" + datas.size());
		// 根据流程定义ID查询
		datas = historyService.createHistoricProcessInstanceQuery()
				.processDefinitionId(define.getId()).list();
		System.out.println("使用processDefinitionId方法： " + datas.size());
		// 根据流程定义key（流程描述文件的process节点id属性）查询
		datas = historyService.createHistoricProcessInstanceQuery()
				.processDefinitionKey(define.getKey()).list();
		System.out.println("使用processDefinitionKey方法： " + datas.size());
		// 根据业务主键查询
		datas = historyService.createHistoricProcessInstanceQuery()
				.processInstanceBusinessKey("businessKey1").list();
		System.out.println("使用processInstanceBusinessKey方法： " + datas.size());
		// 根据流程实例ID查询
		datas = historyService.createHistoricProcessInstanceQuery()
				.processInstanceId(pi1.getId()).list();
		System.out.println("使用processInstanceId方法： " + datas.size());
		// 查询没有完成的流程实例
		historyService.createHistoricProcessInstanceQuery().unfinished().list();
		System.out.println("使用unfinished方法： " + datas.size());
	}
}
