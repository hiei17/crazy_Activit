package org.crazyit.activiti;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;

public class CompleteCondition {
	
	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到流程存储服务组件
		RepositoryService repositoryService = engine.getRepositoryService();
		// 得到运行时服务组件
		RuntimeService runtimeService = engine.getRuntimeService();
		// 部署流程文件
		repositoryService.createDeployment()
				.addClasspathResource("bpmn/CompleteCondition.bpmn")
				.deploy();
		// 初始化参数
		Map<String, Object> vars = new HashMap<String, Object>();
		List<String> datas = new ArrayList<String>();
		datas.add("a");
		datas.add("b");
		datas.add("c");
		datas.add("d");
		vars.put("datas", datas);
		// 启动流程
		runtimeService.startProcessInstanceByKey("process1", vars);
	}
}
