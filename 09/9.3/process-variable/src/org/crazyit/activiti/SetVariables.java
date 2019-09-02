package org.crazyit.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * 参数设置
 * @author yangenxiong
 *
 */
public class SetVariables {


	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到流程存储服务实例
		RepositoryService repositoryService = engine.getRepositoryService();
		RuntimeService runtimeService = engine.getRuntimeService();
		// 部署流程描述文件
		repositoryService.createDeployment()
				.addClasspathResource("bpmn/variables.bpmn20.xml").deploy();

		//启动流程
		ProcessInstance pi = runtimeService.startProcessInstanceByKey("vacationRequest");
		//查询流程实例的执行流
		Execution exe = runtimeService.createExecutionQuery().processInstanceId(pi.getId()).singleResult();
		//mark 设置流程参数
		runtimeService.setVariable(exe.getId(), "days", 5);
		//查找参数
		System.out.println("获取流程参数：" + runtimeService.getVariable(exe.getId(), "days"));
	}

}
