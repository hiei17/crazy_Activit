package org.crazyit.activiti;

import org.activiti.engine.ProcessEngineConfiguration;

/**
 * 使用createStandaloneInMemProcessEngineConfiguration创建ProcessEngineConfiguration
 * 
 * @author yangenxiong
 * 
 */
public class CreateStandaloneInMem {

	public static void main(String[] args) {
		ProcessEngineConfiguration config = ProcessEngineConfiguration
				.createStandaloneInMemProcessEngineConfiguration();
		// 值为create-drop
		System.out.println(config.getDatabaseSchemaUpdate());
		// 值为jdbc:h2:mem:activiti
		System.out.println(config.getJdbcUrl());
	}

}
