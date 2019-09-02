package org.crazyit.activiti;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.apache.log4j.Logger;

/**
 * 删除部署数据
 * 
 * @author yangenxiong
 * 
 */
public class DeleteDeployment {

	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到流程存储服务对象
		RepositoryService repositoryService = engine.getRepositoryService();
		// 部署一份流程文件与相应的流程图文件
		Deployment dep = repositoryService.createDeployment()
				.addClasspathResource("bpmn/deleteDeployment.bpmn")
				.deploy();
		// 查询流程定义
		ProcessDefinition def = repositoryService.createProcessDefinitionQuery()
						.deploymentId(dep.getId()).singleResult();
		// 开始流程
		engine.getRuntimeService().startProcessInstanceById(def.getId());
		try {
			// 删除部署数据失败，此时将会抛出异常，由于cascade为false
			repositoryService.deleteDeployment(dep.getId());
		} catch (Exception e) {
			System.out.println("删除失败，流程开始，没有设置cascade为true");
		}
		System.out.println("============分隔线");
		// 成功删除部署数据
		repositoryService.deleteDeployment(dep.getId(), true);
	}

}
