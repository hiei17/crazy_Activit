package org.crazyit.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 执行流查询
 * @author yangenxiong
 *
 * mark
 * 都是
 *  runtimeService
 * 				.createExecutionQuery()
 * 				.各种查询条件
 * 				.list/.singleResult()
 *
 */
public class ExecutionQuery {


	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到流程存储服务实例
		RepositoryService repositoryService = engine.getRepositoryService();
		// 得到运行时服务组件
		RuntimeService runtimeService = engine.getRuntimeService();
		// 部署流程描述文件
		repositoryService.createDeployment()
				.addClasspathResource("bpmn/ExecutionQuery.bpmn").deploy();
		//设置参数
		Map<String, Object> vars1 = new HashMap<String, Object>();
		vars1.put("days", 5);
		Map<String, Object> vars2 = new HashMap<String, Object>();
		vars2.put("days", 6);
		Map<String, Object> vars3 = new HashMap<String, Object>();
		vars3.put("days", 7);
		vars3.put("name", "crazyit");


		// 开始流流程
		ProcessInstance pi1 = runtimeService.startProcessInstanceByKey("testProcess", 
				"businessKey1", vars1);
		ProcessInstance pi2 = runtimeService.startProcessInstanceByKey("testProcess", 
				"businessKey2", vars2);
		ProcessInstance pi3 = runtimeService.startProcessInstanceByKey("testProcess", 
				"businessKey3", vars3);


		// 使用执行流查询方法
		List<Execution> exes = runtimeService
				.createExecutionQuery()
				//mark <process id="testProcess 查实例
				.processDefinitionKey("testProcess")//.singleResult() 多于一个会报错
				.list();

		System.out.println("使用processDefinitionKey方法查询执行流：" + exes.size());

		exes = runtimeService
				.createExecutionQuery()
				// mark 启动实例时传的 businessKey 查
				.processInstanceBusinessKey("businessKey1")
				.list();
		System.out.println("使用processInstanceBusinessKey方法查询执行流：" + exes.size());

		exes = runtimeService
				.createExecutionQuery()
				//mark 消息事件 查
				.messageEventSubscriptionName("messageName")
				.list();
		System.out.println("使用messageEventSubscriptionName方法查询执行流：" + exes.size());

		// 根据节点id属性查询当前的执行流
		Execution exe = runtimeService
				.createExecutionQuery()
				// mark 当前停在这个节点的执行流
				.activityId("messageintermediatecatchevent1")
				.processInstanceId(pi1.getId())
				.singleResult();
		System.out.println("使用activityId和processInstanceId方法查询执行流，得到执行ID：" + exe.getId());

		//触发:让流程往下执行
		runtimeService.messageEventReceived("messageName", exe.getId());
		exes = runtimeService
				.createExecutionQuery()
				//mark 信号事件 查
				.signalEventSubscriptionName("signalName")
				.list();
		System.out.println("使用signalEventSubscriptionName方法查询执行流：" + exes.size());

		// 根据 mark 参数查询执行流
		exes = runtimeService
				.createExecutionQuery()
				.variableValueEquals("name", "crazyit")
				.list();
		System.out.println("使用variableValueEquals方法查询执行流：" + exes.size());

		exes = runtimeService.createExecutionQuery().variableValueGreaterThan("days", 5).list();
		System.out.println("使用variableValueGreaterThan方法查询执行流：" + exes.size());

		exes = runtimeService.createExecutionQuery().variableValueGreaterThanOrEqual("days", 5).list();
		System.out.println("使用variableValueGreaterThanOrEqual方法查询执行流：" + exes.size());

		exes = runtimeService.createExecutionQuery().variableValueLessThan("days", 6).list();
		System.out.println("使用variableValueLessThan方法查询执行流：" + exes.size());

		exes = runtimeService.createExecutionQuery().variableValueLessThanOrEqual("days", 6).list();
		System.out.println("使用variableValueLessThanOrEqual方法查询执行流：" + exes.size());

		exes = runtimeService.createExecutionQuery().variableValueLike("name", "%crazy%").list();
		System.out.println("使用variableValueLike方法查询执行流：" + exes.size());

		exes = runtimeService.createExecutionQuery().variableValueNotEquals("days", 8).list();
		System.out.println("使用variableValueNotEquals方法查询执行流：" + exes.size());
	}

}
