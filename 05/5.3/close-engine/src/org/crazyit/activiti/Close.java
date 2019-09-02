package org.crazyit.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;

/**
 * 调用 ProcessEngine的close方法
 * @author yangenxiong
 *
 */
public class Close {

	public static void main(String[] args) throws Exception {
		//读取配置
		ProcessEngineConfiguration config = ProcessEngineConfiguration.
				createProcessEngineConfigurationFromResource("close.xml");
		//创建流程引擎
		ProcessEngine engine = config.buildProcessEngine();		
		System.out.println("完成流程引擎创建");
		Thread.sleep(10000);
		//执行close方法
		engine.close();
	}

}
