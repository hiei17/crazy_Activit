package org.crazyit.activiti;

import org.activiti.engine.ProcessEngineConfiguration;

/**
 * 使用CreateStandaloneProcessEngineConfiguration方法创建ProcessEngineConfiguration
 * 
 * @author yangenxiong
 * 
 */
public class CreateStandalone {

	public static void main(String[] args) {
		ProcessEngineConfiguration config = ProcessEngineConfiguration
				.createStandaloneProcessEngineConfiguration();
		// 默认值为 false
		System.out.println(config.getDatabaseSchemaUpdate());
		// 默认值为 jdbc:h2:tcp://localhost/~/activiti
		System.out.println(config.getJdbcUrl());
	}

}
