package org.crazyit.activiti;

import java.io.InputStream;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;

/**
 * 查询部署资源
 * 
 * @author yangenxiong
 * 
 */
public class GetResource {

	public static void main(String[] args) throws Exception {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到流程存储服务对象
		RepositoryService repositoryService = engine.getRepositoryService();
		// 部署一份txt文件
		Deployment dep = repositoryService.createDeployment()
				.addClasspathResource("artifact/GetResource.txt").deploy();
		// 查询资源文件
		InputStream is = repositoryService.getResourceAsStream(dep.getId(), 
				"artifact/GetResource.txt");
		// 读取输入流
		int count = is.available();
		byte[] contents = new byte[count];
		is.read(contents);
		String result = new String(contents);
		//输入结果
		System.out.println(result);
	}

}
