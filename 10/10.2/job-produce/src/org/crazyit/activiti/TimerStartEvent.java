package org.crazyit.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;

/**
 * 定时开始时间产生的工作
 * @author yangenxiong
 *
 */
public class TimerStartEvent {

	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到流程存储服务实例
		RepositoryService repositoryService = engine.getRepositoryService();
		// 部署流程文件
		repositoryService
				.createDeployment()
				.addClasspathResource("bpmn/timer-start-event.bpmn")
				.deploy();
		// 查询工作数量
		System.out.println("工作数量：" + engine.getManagementService().createTimerJobQuery().count());
	}

}
