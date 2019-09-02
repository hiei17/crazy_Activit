package org.crazyit.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;

/**
 * 中断流程
 * @author yangenxiong
 *
 */
public class SuspendProcessDef {

	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到流程存储服务实例
		RepositoryService repositoryService = engine.getRepositoryService();
		// 部署流程描述文件
		Deployment dep = repositoryService.createDeployment()
				.addClasspathResource("bpmn/suspendProcessDef.bpmn")
				.deploy();
		//查询流程定义实体
		ProcessDefinition def = repositoryService.createProcessDefinitionQuery()
				.deploymentId(dep.getId()).singleResult();		
		// 调用suspendProcessDefinitionById中止流程定义 
		repositoryService.suspendProcessDefinitionById(def.getId());
		// 调用activateProcessDefinitionById激活流程定义 
		repositoryService.activateProcessDefinitionById(def.getId());
		// 调用suspendProcessDefinitionByKey中止流程定义 
		repositoryService.suspendProcessDefinitionByKey(def.getKey());
		// 调用activateProcessDefinitionByKey激活流程定义 
		repositoryService.activateProcessDefinitionByKey(def.getKey());
	}

}
