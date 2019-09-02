package org.crazyit.activiti;

import org.activiti.engine.ProcessEngineConfiguration;

/**
 * 使用CreateProcessEngineConfigurationFromResource方法创建ProcessEngineConfiguration实例
 * 
 * @author Administrator
 * 
 */
public class CreateFromResource_2 {

	public static void main(String[] args) {
		// 指定配置文件创建ProcessEngineConfiguration
		ProcessEngineConfiguration config = ProcessEngineConfiguration
				.createProcessEngineConfigurationFromResource(
						"my-activiti2.xml", "test2");
		System.out.println(config.getProcessEngineName());
	}

}
