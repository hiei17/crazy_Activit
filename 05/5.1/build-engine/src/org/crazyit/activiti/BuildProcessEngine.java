package org.crazyit.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;

/**
 * 使用ProcessEngineConfiguration的buildProcessEngine方法
 * 
 * @author yangenxiong
 * 
 */
public class BuildProcessEngine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 读取配置
		ProcessEngineConfiguration config = ProcessEngineConfiguration
				.createProcessEngineConfigurationFromResource("build_engine.xml");
		// 创建ProcessEngine
		ProcessEngine engine = config.buildProcessEngine();
	}

}
