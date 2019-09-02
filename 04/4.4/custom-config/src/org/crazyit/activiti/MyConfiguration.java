package org.crazyit.activiti;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.interceptor.CommandContextInterceptor;
import org.activiti.engine.impl.interceptor.CommandInterceptor;

/**
 * 自定义配置类
 * @author yangenxiong
 *
 */
public class MyConfiguration extends ProcessEngineConfigurationImpl {
	
	public MyConfiguration() {
		// 做自定义设置
	}
	
	//测试属性，需要在processEngineConfiguration注入
	private String userName;
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserName() {
		return this.userName;
	}
	public CommandInterceptor createTransactionInterceptor() {
		return null;
	}
}
