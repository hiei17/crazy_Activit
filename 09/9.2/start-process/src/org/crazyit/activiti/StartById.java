package org.crazyit.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;

import java.util.HashMap;
import java.util.Map;

public class StartById {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到流程存储服务实例
		RepositoryService repositoryService = engine.getRepositoryService();
		RuntimeService runtimeService = engine.getRuntimeService();
		// 部署流程描述文件
		Deployment dep = repositoryService.createDeployment()
				.addClasspathResource("bpmn/startById.bpmn20.xml").deploy();

		// 查找流程定义(就是xml的解析结果)
		ProcessDefinition pd = repositoryService
				.createProcessDefinitionQuery()
				.deploymentId(dep.getId())
				.singleResult();
		String processDefinitionId = pd.getId();

		//流程参数
		Map<String, Object> vars = new HashMap<>();
		vars.put("days", 5);

		//启动流程
		runtimeService.startProcessInstanceById(processDefinitionId);
		runtimeService.startProcessInstanceById(processDefinitionId, vars);
		runtimeService.startProcessInstanceById(processDefinitionId, "vacationRequest1");
		runtimeService.startProcessInstanceById(processDefinitionId, "vacationRequest2", vars);
		// 查询流程实例，结果为4
		long count = runtimeService.createProcessInstanceQuery().count();
		System.out.println("流程实例数量：" + count);
	}

}
