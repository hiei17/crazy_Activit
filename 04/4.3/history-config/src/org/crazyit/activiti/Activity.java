package org.crazyit.activiti;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * 将history属性设置为none
 * @author yangenxiong
 *
 */
public class Activity {

	public static void main(String[] args) {
		// 读取Activiti配置
		ProcessEngineConfiguration config = ProcessEngineConfiguration
				.createProcessEngineConfigurationFromResource("history-activity.xml");		
		//初始化流程引擎
		ProcessEngine engine = config.buildProcessEngine();
		//得到流程存储对角
		RepositoryService repositoryService = engine.getRepositoryService();
		//部署流程文件
		repositoryService.createDeployment().addClasspathResource("bpmn/history.bpmn20.xml").deploy();
		//得到运行服务对象
		RuntimeService runtimeService = engine.getRuntimeService();
		//创建参数
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("day", 10);
		//开始流程
		ProcessInstance pi = runtimeService.startProcessInstanceByKey("vacationProcess", vars);
		System.exit(0);
	}

}
