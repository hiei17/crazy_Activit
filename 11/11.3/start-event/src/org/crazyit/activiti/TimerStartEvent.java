package org.crazyit.activiti;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * 定时器开始事件
 * @author yangenxiong
 *
 */
public class TimerStartEvent {

	public static void main(String[] args) throws Exception {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();		
		// 得到流程存储服务组件
		RepositoryService repositoryService = engine.getRepositoryService();
		// 得到运行时服务组件
		RuntimeService runtimeService = engine.getRuntimeService();
		// 部署流程文件
		repositoryService.createDeployment()
			.addClasspathResource("bpmn/TimerStartEvent.bpmn").deploy();
		// 等待时间条件
		Thread.sleep(70 * 1000);
		// 查询流程实例
		List<ProcessInstance> ints = runtimeService.createProcessInstanceQuery().list();
		System.out.println(ints.size());
		System.exit(0);
	}

}
