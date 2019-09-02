package org.crazyit.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;

/**
 * 部署流程图
 * 
 * @author yangenxiong
 *
 */
public class DeployDiagram {

	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到流程存储服务实例
		RepositoryService repositoryService = engine.getRepositoryService();		
		//部署流程描述文件与流程图
		Deployment dep = repositoryService.createDeployment()
				.addClasspathResource("bpmn/diagram.bpmn")
				.addClasspathResource("bpmn/diagram.png").deploy();
		//查询流程定义实体
		ProcessDefinition def = repositoryService.createProcessDefinitionQuery()
				.deploymentId(dep.getId()).singleResult();
		// 输出结果为 bpmn/diagram.vacationProcess.png
		System.out.println(def.getDiagramResourceName());
	}
}
