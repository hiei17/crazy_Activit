package org.crazyit.activiti;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

public class JavaBeanServiceTask {

	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到流程存储服务组件
		RepositoryService repositoryService = engine.getRepositoryService();
		// 得到运行时服务组件
		RuntimeService runtimeService = engine.getRuntimeService();
		// 部署流程文件
		repositoryService.createDeployment()
				.addClasspathResource("bpmn/JavaBeanServiceTask.bpmn").deploy();
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("myBean", new MyJavaBean());
		// 启动流程
		ProcessInstance pi = runtimeService.startProcessInstanceByKey(
				"process1", vars);
		// 进行任务参数查询
		System.out.println("运行两个Service Task的myName参数值为："
				+ runtimeService.getVariable(pi.getId(), "myName"));
	}

}
