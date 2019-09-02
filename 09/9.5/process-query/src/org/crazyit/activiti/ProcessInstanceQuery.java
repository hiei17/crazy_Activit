package org.crazyit.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 执行流查询
 * 
 * @author yangenxiong
 * 
 */
public class ProcessInstanceQuery {

	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到流程存储服务实例
		RepositoryService repositoryService = engine.getRepositoryService();
		// 得到运行时服务组件
		RuntimeService runtimeService = engine.getRuntimeService();
		// 部署流程描述文件
		repositoryService.createDeployment()
				.addClasspathResource("bpmn/ProcessInstanceQuery.bpmn")
				.deploy();
		ProcessInstance pi1 = runtimeService.startProcessInstanceByKey(
				"testProcess", "key1");
		ProcessInstance pi2 = runtimeService.startProcessInstanceByKey(
				"testProcess", "key2");
		ProcessInstance pi3 = runtimeService.startProcessInstanceByKey(
				"testProcess", "key3");


		// 查询流程实例
		List<ProcessInstance> pis = runtimeService.createProcessInstanceQuery()
				.processDefinitionKey("testProcess").list();
		System.out.println("使用processDefinitionKey方法查询流程实例：" + pis.size());

		// 将流程置为中断状态
		runtimeService.suspendProcessInstanceById(pi1.getId());
		pis = runtimeService
				.createProcessInstanceQuery()
				.active().list();// mark 中断的不要
		System.out.println("使用active方法查询流程实例：" + pis.size());

		//mark 根据驱动端时候设置的BusinessKey 查询
		pis = runtimeService.createProcessInstanceQuery()
				.processInstanceBusinessKey("key2").list();
		System.out.println("使用processInstanceBusinessKey方法查询流程实例：" + pis.size());

		//mark  根据多个流程实例ID查询
		Set<String> ids = new HashSet<String>();
		ids.add(pi1.getId());
		ids.add(pi2.getId());
		pis = runtimeService.createProcessInstanceQuery()
				.processInstanceIds(ids).list();
		System.out.println("使用processInstanceIds方法查询流程实例：" + pis.size());
	}

}
