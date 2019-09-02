package org.crazyit.activiti;

import java.util.Iterator;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;

public class MyCacheTest {

	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngineConfigurationImpl config =
				 (ProcessEngineConfigurationImpl) ProcessEngineConfiguration
				.createProcessEngineConfigurationFromResource("my-cache.cfg.xml");
		ProcessEngine engine = config.buildProcessEngine();		
		// 得到流程存储服务实例
		RepositoryService repositoryService = engine.getRepositoryService();
		// 进行10次部署
		for (int i = 0; i < 10; i++) {
			repositoryService.createDeployment()
					.addClasspathResource("bpmn/default-cache.bpmn")
					.name("dep_" + i).key("key_" + i).deploy();
		}
		// 获取缓存
		MyCacheBean cache = (MyCacheBean) config
				.getProcessDefinitionCache();
		// 遍历缓存，输出Map中的key
		for (Iterator it = cache.cache.keySet().iterator(); it.hasNext();) {
			String key = (String) it.next();
			System.out.println(key);
		}
	}

}
