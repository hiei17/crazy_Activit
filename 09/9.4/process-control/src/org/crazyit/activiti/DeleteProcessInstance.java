package org.crazyit.activiti;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * 删除流程实例
 * @author yangenxiong
 *
 */
public class DeleteProcessInstance {


	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到流程存储服务实例
		RepositoryService repositoryService = engine.getRepositoryService();
		// 得到运行时服务组件
		RuntimeService runtimeService = engine.getRuntimeService();
		// 部署流程描述文件
		repositoryService.createDeployment()
				.addClasspathResource("bpmn/DeleteProcess.bpmn").deploy();
		// 开始流流程
		ProcessInstance pi = runtimeService.startProcessInstanceByKey("testProcess");
		long count = runtimeService.createProcessInstanceQuery().count();
		System.out.println("启动时流程实例数量：" + count);
		// 删除流程
		runtimeService.deleteProcessInstance(pi.getId(), "abc");
		count = runtimeService.createProcessInstanceQuery().count();
		System.out.println("删除后流程实例数量：" + count);
	}

}
