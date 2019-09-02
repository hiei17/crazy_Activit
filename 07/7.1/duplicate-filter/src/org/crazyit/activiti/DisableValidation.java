package org.crazyit.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.DeploymentBuilder;

public class DisableValidation {

	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到流程存储服务实例
		RepositoryService repositoryService = engine.getRepositoryService();
		// 部署一份错误的xml文件，不会报错
		DeploymentBuilder builderA = repositoryService.createDeployment();
		builderA.addClasspathResource("bpmn/xmlError.bpmn")
				.disableSchemaValidation().deploy();
		// 部署一份不可执行bpmn文件，不会报错
		DeploymentBuilder builderB = repositoryService.createDeployment();
		builderB.addClasspathResource("bpmn/bpmnError.bpmn")
				.disableBpmnValidation().deploy();
	}

}
