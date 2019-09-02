package org.crazyit.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.TaskService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class EngineConfigurationTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 创建Spring上下文
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] { "activiti.cfg.xml" });
		// 获取processEngine bean
		ProcessEngine engine = (ProcessEngine)ctx.getBean("processEngine");
		System.out.println("流程引擎实现类：" + engine.getClass().getName());
		// 获取Activiti服务组件
		TaskService taskService = (TaskService)ctx.getBean("taskService");
		System.out.println("任务服务实例：" + taskService);
	}

}
