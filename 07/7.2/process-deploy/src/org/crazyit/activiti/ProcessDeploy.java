package org.crazyit.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.DeploymentBuilder;

/**
 * 部署流程文件
 * @author yangenxiong
 *
 */
public class ProcessDeploy {

	public static void main(String[] args) {
		//创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();

		//得到流程存储服务对象
		RepositoryService repositoryService = engine.getRepositoryService();

		//创建DeploymentBuilder实例
		DeploymentBuilder builder = repositoryService.createDeployment();

		builder.addClasspathResource("bpmn/processDeploy.bpmn").deploy();
	}

}
