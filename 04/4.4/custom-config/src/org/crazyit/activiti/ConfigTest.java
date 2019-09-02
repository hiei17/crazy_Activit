package org.crazyit.activiti;

import org.activiti.engine.ProcessEngineConfiguration;

/**
 * 自定义配置测试
 * @author yangenxiong
 *
 */
public class ConfigTest {

	public static void main(String[] args) {
		//创建ProcessEngineConfiguration，并强制转换为MyConfiguration
		MyConfiguration config = (MyConfiguration)ProcessEngineConfiguration.
				createProcessEngineConfigurationFromResource("my-config.xml");
		config.buildProcessEngine();
		//打印出结果为crazyit
		System.out.println(config.getUserName());
	}

}
