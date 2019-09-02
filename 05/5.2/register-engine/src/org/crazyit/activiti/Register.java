package org.crazyit.activiti;

import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;

/**
 * 注册与注销ProcessEngine实例
 * @author yangenxiong
 *
 */
public class Register {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//读取自定义配置
		ProcessEngineConfiguration config = ProcessEngineConfiguration.
				createProcessEngineConfigurationFromResource("register.xml");
		//创建ProcessEngine实例
		ProcessEngine engine = config.buildProcessEngine();
		//获取ProcessEngine的Map
		Map<String, ProcessEngine> engines = ProcessEngines.getProcessEngines();
		System.out.println("注册后引擎数：" + engines.size());
		//注销ProcessEngine实例
		ProcessEngines.unregister( engine);
		System.out.println("调用unregister后引擎数：" + engines.size());
	}

}
