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
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;

public class ElementInstance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到流程存储服务组件
		RepositoryService repositoryService = engine.getRepositoryService();
		// 得到运行时服务组件
		RuntimeService runtimeService = engine.getRuntimeService();
		// 部署流程文件
		repositoryService.createDeployment()
				.addClasspathResource("bpmn/ElementInstance.bpmn").deploy();
		Map<String, Object> vars = new HashMap<String, Object>();
		// 设置参数
		List<String> datas1 = new ArrayList<String>();
		datas1.add("a");
		datas1.add("b");
		vars.put("datas1", datas1);
		List<String> datas2 = new ArrayList<String>();
		datas2.add("c");
		datas2.add("d");
		vars.put("datas2", datas2);
		// 启动流程
		ProcessInstance pi = runtimeService.startProcessInstanceByKey(
				"process1", vars);
		// 查询执行流
		Execution exe = runtimeService.createExecutionQuery()
				.processInstanceId(pi.getId()).onlyChildExecutions()
				.singleResult();
		System.out.println("主执行流id：" + exe.getId());
	}

}
