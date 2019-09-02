package org.crazyit.activiti;

import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.Job;
import org.activiti.engine.runtime.ProcessInstance;

public class DeadletterJob {

	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到流程存储服务实例
		RepositoryService repositoryService = engine.getRepositoryService();
		// 得到运行时服务组件
		RuntimeService runtimeService = engine.getRuntimeService();
		// 管理服务组件
		ManagementService managementService = engine.getManagementService();
		repositoryService.createDeployment()
				.addClasspathResource("bpmn/deadletter.bpmn").deploy();
		// 启动流程
		ProcessInstance pi = runtimeService.startProcessInstanceByKey("deadletter");
		// 设置重试次数
		Job job = managementService.createJobQuery().singleResult();
		managementService.setJobRetries(job.getId(), 1);
		// 重新执行该工作，抛出异常
		try {
			managementService.executeJob(job.getId());
		} catch (Exception e) {
			
		}
		// 查询无法执行工作表
		long deadCount = managementService.createDeadLetterJobQuery().count();
		System.out.println("无法执行的工作，数据量：" + deadCount);
	}

}
