package org.crazyit.activiti;

import java.net.URL;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineInfo;
import org.activiti.engine.ProcessEngines;

/**
 * 使用ProcessEngines的destroy方法
 * 
 * @author yangenxiong
 *
 */
public class Destroy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 进行初始化并且返回默认的ProcessEngine实例
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		System.out.println("调用getDefaultProcessEngine方法后引擎数量："
				+ ProcessEngines.getProcessEngines().size());
		// 调用销毁方法
		ProcessEngines.destroy();
		// 最终结果为0
		System.out.println("调用destroy方法后引擎数量："
				+ ProcessEngines.getProcessEngines().size());

		// 得到资源文件的URL实例
		ClassLoader cl = Destroy.class.getClassLoader();
		URL url = cl.getResource("activiti.cfg.xml");
		// 调用retry方法创建ProcessEngine实例
		ProcessEngines.retry(url.toString());
		System.out.println("只调用 retry方法后引擎数量："
				+ ProcessEngines.getProcessEngines().size());
		// 调用销毁方法，没有效果
		ProcessEngines.destroy();
		System.out.println("调用destory无效果，引擎数量："
				+ ProcessEngines.getProcessEngines().size());
	}

}
