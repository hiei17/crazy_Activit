package org.crazyit.activiti;

import org.activiti.engine.ProcessEngineConfiguration;

/**
 * 使用createProcessEngineConfigurationFromResourceDefault方法
 * 创建ProcessEngineConfiguration实例
 * @author Administrator
 *
 */
public class CreateDefault {

	public static void main(String[] args) {
		//使用Activiti默认的方式创建ProcessEngineConfiguration
		ProcessEngineConfiguration config = ProcessEngineConfiguration.createProcessEngineConfigurationFromResourceDefault();	
	}

}
