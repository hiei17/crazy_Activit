package org.crazyit.activiti;

import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;

/**
 * 调用ProcessEngines的init方法
 * 
 * @author yangenxiong
 * 
 */
public class Init {

	public static void main(String[] args) {
		// 初始化ProcessEngines的Map,
		// 再加载Activiti默认的配置文件（classpath下的activiti.cfg.xml文件）
		// 如果与Spring整合，则读取classpath下的activiti-context.xml文件
		ProcessEngines.init();
		// 得到ProcessEngines的Map
		Map<String, ProcessEngine> engines = ProcessEngines.getProcessEngines();
		System.out.println(engines.size());
		System.out.println(engines.get("default"));
	}

}
