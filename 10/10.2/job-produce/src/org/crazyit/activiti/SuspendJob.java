package org.crazyit.activiti;

import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;

public class SuspendJob {

	public static void main(String[] args) throws Exception {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到流程存储服务实例
		RepositoryService repositoryService = engine.getRepositoryService();
		// 得到运行时服务组件
		RuntimeService runtimeService = engine.getRuntimeService();
		// 管理服务组件
		ManagementService managementService = engine.getManagementService();		
		// 部署流程文件
		Deployment dep = repositoryService
				.createDeployment()
				.addClasspathResource("bpmn/SuspendJob.bpmn")
				.deploy();		
		// 启动流程实例
		ProcessInstance pi = runtimeService.startProcessInstanceByKey("suspendJob");
		// 查询定时器表的数量
		long timerCount = managementService.createTimerJobQuery().count();
		System.out.println("中断前定时器表的数据量：" + timerCount);	
		// 查询中断表的数量
		long suspendCount = managementService.createSuspendedJobQuery().count();
		System.out.println("中断前中断表数据量：" + suspendCount);
		// 中断流程实例
		runtimeService.suspendProcessInstanceById(pi.getId());
		// 查询定时器表的数量
		timerCount = managementService.createTimerJobQuery().count();
		System.out.println("中断后定时器表的数据量：" + timerCount);
		// 查询中断表的数量
		suspendCount = managementService.createSuspendedJobQuery().count();
		System.out.println("中断后中断表数据量：" + suspendCount);
	}

	
}
