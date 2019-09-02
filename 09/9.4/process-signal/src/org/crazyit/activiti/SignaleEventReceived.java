package org.crazyit.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;

import java.util.List;

/**
 * 使用signaleEventReceived方法
 * @author yangenxiong
 *
 */
public class SignaleEventReceived {

	public static void main(String[] args) {

		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();

		// 得到流程存储服务实例
		RepositoryService repositoryService = engine.getRepositoryService();

		// 得到运行时服务组件
		RuntimeService runtimeService = engine.getRuntimeService();



		// 部署流程描述文件
		Deployment deploy = repositoryService
				.createDeployment()
				.addClasspathResource("bpmn/signalEventReceived.bpmn")
				.deploy();

		// 开始流程
		ProcessInstance pi = runtimeService.startProcessInstanceByKey(deploy.getId());

		// 查询执行流
		Execution exe = runtimeService
				.createExecutionQuery()
				.activityId("usertask1")
				.singleResult();
		System.out.println("当前节点：" + exe.getActivityId());

		// 触发receiveTask
		runtimeService.trigger(exe.getId());

		// 查询当前节点
		exe = runtimeService.createExecutionQuery()
				.activityId("signalCatchEvent")
				.singleResult();
		System.out.println("调用trigger方法后当前节点：" + exe.getActivityId());

		//mark  发送信号给事件，流程结束
		runtimeService.signalEventReceived("testSignal");
		List exes = runtimeService.createExecutionQuery()
				.processInstanceId(pi.getId()).list();

		System.out.println("触发Catch事件后，执行流数量：" + exes.size());
	}

}
