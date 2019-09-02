package org.crazyit.activiti;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;

/**
 * 查询部署资源名称
 * 
 * @author yangenxiong
 * 
 */
public class GetResourceNames {

	public static void main(String[] args) throws Exception {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到流程存储服务对象
		RepositoryService repositoryService = engine.getRepositoryService();
		// 部署一份流程文件与相应的流程图文件
		Deployment dep = repositoryService.createDeployment()
				.addClasspathResource("bpmn/GetResourceNames.bpmn")
				.addClasspathResource("bpmn/GetResourceNames.png").deploy();
		// 查询资源文件名称集合
		List<String> names = repositoryService.getDeploymentResourceNames(dep.getId());
		for (String name : names) {
			System.out.println(name);
		}
	}

}
