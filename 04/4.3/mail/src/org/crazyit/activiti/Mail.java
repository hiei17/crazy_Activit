package org.crazyit.activiti;

import org.activiti.engine.ProcessEngineConfiguration;


public class Mail {

	public static void main(String[] args) {
		ProcessEngineConfiguration config = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("mail.xml");
		System.out.println(config.getMailServerHost());
	}

}
