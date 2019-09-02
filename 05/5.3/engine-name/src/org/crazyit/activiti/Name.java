package org.crazyit.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;

/**
 * 流程引擎名称
 * @author yangenxiong
 *
 */
public class Name {


	public static void main(String[] args) {
		ProcessEngineConfiguration config = ProcessEngineConfiguration.
				createProcessEngineConfigurationFromResource("name.xml");
		//设置流程引擎名称
		config.setProcessEngineName("test");
		ProcessEngine engine = config.buildProcessEngine();
		//根据名称查询流程引擎
		ProcessEngine engineTest = ProcessEngines.getProcessEngine("test");
		System.out.println("创建的引擎实例：" + engine);
		System.out.println("查询的引擎实例：" + engineTest);
	}

}
