package org.crazyit.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.DeploymentBuilder;

/**
 * 调用DeploymentBuilder的AddString方法
 * @author yangenxiong
 *
 */
public class AddString {

	public static void main(String[] args) {

		//创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		//得到流程存储服务对象
		RepositoryService repositoryService = engine.getRepositoryService();


		//创建DeploymentBuilder实例
		DeploymentBuilder builder = repositoryService.createDeployment();

		//添加String资源
		builder.addString("test", "this is string method");

		//执行部署（写入到数据库中）
		builder.deploy();
	}

}
