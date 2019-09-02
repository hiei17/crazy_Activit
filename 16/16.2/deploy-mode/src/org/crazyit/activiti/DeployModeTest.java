package org.crazyit.activiti;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class DeployModeTest {

	public static void main(String[] args) throws Exception {
		// 初始化Sprin容器，加载配置文件
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] { "activiti.cfg.xml" });
		// 创建引擎配置对象
		SpringProcessEngineConfiguration engineConfig = (SpringProcessEngineConfiguration) ctx
				.getBean("processEngineConfiguration");
		// 设置部署资源，测试default值
		Resource[] res = createResources(new String[] {
				"bpmn/default-config/1.txt", "bpmn/default-config/2.txt" });
		engineConfig.setDeploymentResources(res);
		/*
		 * 设置部署模式为default（默认值）
		 */
		engineConfig.setDeploymentMode("default");
		// 创建流程引擎
		ProcessEngine engine = engineConfig.buildProcessEngine();
		// 查询部署数据
		long depCount = engine.getRepositoryService().createDeploymentQuery()
				.count();
		System.out.println("部署模式为默认值，部署后数量：" + depCount);
		// 关闭流程引擎
		engine.close();
		/*
		 * 测试设置部署模式为 resource-parent-folder
		 */
		res = createResources(new String[] {
				"bpmn/parent-folder/folder1/3.txt",
				"bpmn/parent-folder/folder1/4.txt",
				"bpmn/parent-folder/folder2/5.txt",
				"bpmn/parent-folder/folder2/6.txt" });
		engineConfig.setDeploymentResources(res);
		engineConfig.setDeploymentMode("resource-parent-folder");
		engineConfig.buildProcessEngine();
		depCount = engine.getRepositoryService().createDeploymentQuery()
				.count();
		System.out.println("部署模式为 resource-parent-folder，部署后数量：" + depCount);
		engine.close();
		/*
		 * 测试设置部署模式为 single-resource
		 */
		res = createResources(new String[] { "bpmn/single-resource/7.txt",
				"bpmn/single-resource/8.txt" });
		engineConfig.setDeploymentResources(res);
		engineConfig.setDeploymentMode("single-resource");
		engineConfig.buildProcessEngine();
		depCount = engine.getRepositoryService().createDeploymentQuery()
				.count();
		System.out.println("部署模式为 single-resource，部署后数量：" + depCount);
		engine.close();
	}

	/**
	 * 创建资源数组
	 */
	private static Resource[] createResources(String[] paths) {
		List<Resource> res = new ArrayList<Resource>();
		for (String path : paths) {
			Resource r = new ClassPathResource(path);
			res.add(r);
		}
		return res.toArray(new Resource[] {});
	}

}
