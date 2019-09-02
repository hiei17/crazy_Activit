package org.crazyit.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * 使用Shell Task
 * 
 * @author yangenxiong
 * 
 */
public class ShellTask {

	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到流程存储服务组件
		RepositoryService repositoryService = engine.getRepositoryService();
		// 得到运行时服务组件
		RuntimeService runtimeService = engine.getRuntimeService();
		// 部署流程文件
		repositoryService.createDeployment()
				.addClasspathResource("bpmn/ShellTask.bpmn").deploy();
		// 启动流程
		ProcessInstance pi = runtimeService
				.startProcessInstanceByKey("process1");
		// 查询流程参数
		System.out.println("运行Shell Task得到JAVA_HOME的环境变量值为："
				+ runtimeService.getVariable(pi.getId(), "javaHome"));
	}

}
