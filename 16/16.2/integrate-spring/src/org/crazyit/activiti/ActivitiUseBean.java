package org.crazyit.activiti;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class ActivitiUseBean {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "activiti.use.bean.xml" });

		// 得到Activiti的服务组件
		RepositoryService repositoryService = (RepositoryService) ctx.getBean("repositoryService");

		RuntimeService runtimeService = (RuntimeService) ctx.getBean("runtimeService");

		// 部署流程文件
		repositoryService.createDeployment().addClasspathResource("bpmn/ActivitiUseBean.bpmn").deploy();

		// 初始化流程参数
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("name", "crazyit");
		// 启动流程
		runtimeService.startProcessInstanceByKey("process1", vars);
	}

}
