package org.crazyit.activiti;

import java.io.File;
import java.io.FileInputStream;
import java.util.zip.ZipInputStream;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.DeploymentBuilder;

/**
 * 调用DeploymentBuilder的AddZipInputStream方法
 * @author yangenxiong
 *
 */
public class AddZipInputStream {

	public static void main(String[] args) throws Exception {
		//创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		//得到流程存储服务对象
		RepositoryService repositoryService = engine.getRepositoryService();
		//创建DeploymentBuilder实例
		DeploymentBuilder builder = repositoryService.createDeployment();
		//获取zip文件的输入流
		FileInputStream fis = new FileInputStream(new File("resource/artifact/ZipInputStream.zip"));
		//读取zip文件，创建ZipInputStream对象
		ZipInputStream zi = new ZipInputStream(fis);
		//添加Zip压缩包资源
		builder.addZipInputStream(zi);
		//执行部署（写入到数据库中）
		builder.deploy();
	}

}
