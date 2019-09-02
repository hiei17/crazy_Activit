package org.crazyit.activiti;

import java.net.URL;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineInfo;
import org.activiti.engine.ProcessEngines;

/**
 * 使用ProcessEngines的retry方法
 * @author yangenxiong
 *
 */
public class Retry {

	public static void main(String[] args) {
		//得到资源文件的URL实例
		ClassLoader cl = Retry.class.getClassLoader();
		URL url = cl.getResource("retry.xml");
		//调用retry方法创建ProcessEngine实例
		ProcessEngineInfo info = ProcessEngines.retry(url.toString());
		//得到流程实例保存对象
		Map<String, ProcessEngine> engines = ProcessEngines.getProcessEngines();
		System.out.println("调用retry方法后引擎数：" + engines.size());
	}

}
