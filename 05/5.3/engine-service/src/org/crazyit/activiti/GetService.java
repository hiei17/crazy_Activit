package org.crazyit.activiti;

import org.activiti.engine.DynamicBpmnService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;

/**
 * 获取各个业务组件实例
 * @author yangenxiong
 *
 */
public class GetService {

	public static void main(String[] args) {
		//读取流程引擎配置
		ProcessEngineConfiguration config = ProcessEngineConfiguration.
				createProcessEngineConfigurationFromResource("service.xml");
		//创建流程引擎
		ProcessEngine engine = config.buildProcessEngine();
		//得到各个业务组件实例
		RepositoryService repositoryService = engine.getRepositoryService();
		RuntimeService runtimeService = engine.getRuntimeService();
		TaskService taskService = engine.getTaskService();
		IdentityService identityService = engine.getIdentityService();
		ManagementService managementService = engine.getManagementService();
		HistoryService historyService = engine.getHistoryService();
		DynamicBpmnService dynamicBpmnService = engine.getDynamicBpmnService();
		// 输入类名
		System.out.println(repositoryService.getClass().getName());
		System.out.println(runtimeService.getClass().getName());
		System.out.println(taskService.getClass().getName());
		System.out.println(identityService.getClass().getName());
		System.out.println(managementService.getClass().getName());
		System.out.println(historyService.getClass().getName());
		System.out.println(dynamicBpmnService.getClass().getName());
		
	}

}
