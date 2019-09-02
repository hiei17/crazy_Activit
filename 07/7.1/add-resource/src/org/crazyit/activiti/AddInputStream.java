package org.crazyit.activiti;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.DeploymentBuilder;

/**
 * 调用DeploymentBuilder的AddInputStream方法
 * 
 * @author yangenxiong
 * 
 */
public class AddInputStream {

	public static void main(String[] args) throws Exception {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到流程存储服务实例
		RepositoryService repositoryService = engine.getRepositoryService();
		// 第一个资源输入流
		InputStream is1 = new FileInputStream(new File(
				"resource/artifact/flow_inputstream1.png"));
		// 第二个资源输入流
		InputStream is2 = new FileInputStream(new File(
				"resource/artifact/flow_inputstream1.png"));
		// 创建DeploymentBuilder实例
		DeploymentBuilder builder = repositoryService.createDeployment();
		// 为DeploymentBuilder添加资源输入流
		builder.addInputStream("inputA", is1);
		builder.addInputStream("inputB", is2);
		// 执行部署方法
		builder.deploy();
	}

}
