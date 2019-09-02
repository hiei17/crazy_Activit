package org.crazyit.activiti;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.interceptor.CommandInterceptor;

/**
 * 自定义配置类
 */
public class TestConfiguration extends ProcessEngineConfigurationImpl {
	
	public CommandInterceptor createTransactionInterceptor() {
		// 不实现事务拦截器
		return null;
	}
	
	/**
	 * 重写初始化命令拦截器方法
	 */
	public void initCommandInterceptors() {
		// 为父类的命令集合添加拦截器
		customPreCommandInterceptors = new ArrayList<CommandInterceptor>();
		// 依次将A和B两个拦截器加入集合（责任链）
		customPreCommandInterceptors.add(new InterceptorA());
		customPreCommandInterceptors.add(new InterceptorB());
		// 再调用父类的实始化方法
		super.initCommandInterceptors();
	}
}
