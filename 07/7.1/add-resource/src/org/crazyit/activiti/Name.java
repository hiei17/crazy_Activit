package org.crazyit.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.DeploymentBuilder;

/**
 * 使用DeploymentBuilder的name方法
 * @author yangenxiong
 *
 */
public class Name {

	public static void main(String[] args) {
		//创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		//得到流程存储服务对象
		RepositoryService repositoryService = engine.getRepositoryService();
		//创建DeploymentBuilder实例
		DeploymentBuilder builder = repositoryService.createDeployment();
		//设置各个属性
		builder.name("crazyit").tenantId("tenanId").key("myKey").category("myCategory");
		//执行部署（写入到数据库中）
		builder.deploy();
	}

}
