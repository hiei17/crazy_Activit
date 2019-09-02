package org.crazyit.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;

/**
 * 
 * @author yangenxiong
 *
 */
public class DuplicateFilter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		//得到流程存储服务实例
		RepositoryService repositoryService = engine.getRepositoryService();
		//创建第一个部署对象
		DeploymentBuilder builderA = repositoryService.createDeployment();
		builderA.addClasspathResource("artifact/DuplicateFilter.txt");
		builderA.name("DuplicateFilterA");
		builderA.deploy();		
		//由于资源一样，并且调用了enableDuplicateFiltering方法，因此不会再写入到数据库中
		DeploymentBuilder builderB = repositoryService.createDeployment();
		builderB.addClasspathResource("artifact/DuplicateFilter.txt");
		builderB.name("DuplicateFilterA");
		builderB.enableDuplicateFiltering();
		builderB.deploy();
		//由于资源发生变化，即使调用了enableDuplicateFiltering方法，也会写到数据库中
		DeploymentBuilder builderC = repositoryService.createDeployment();
		builderC.addClasspathResource("artifact/DuplicateFilterB.txt");
		builderC.name("DuplicateFilterA");
		builderC.enableDuplicateFiltering();
		builderC.deploy();
	}

}
