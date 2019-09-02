package org.crazyit.activiti;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.crazyit.activiti.service.PersonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class Sample {

	public static void main(String[] args)  {
		// 启动Spring容器
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] { "activiti.cfg.xml" });
		// 获取bean的实例
		RuntimeService runtimeService = (RuntimeService) ctx
				.getBean("runtimeService");
		RepositoryService repositoryService = (RepositoryService)ctx.getBean("repositoryService");
		PersonService personService = (PersonService) ctx
				.getBean("personService");
		// 部署流程定义
		repositoryService.createDeployment().addClasspathResource("bpmn/test.bpmn").deploy();
		// 查询数据
		System.out.println("启动流程前数据量：" + personService.countPerson());
		// 设置启动参数，name和age参数将用来创建Person
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("name", "Angus");
		vars.put("age", 10);
		runtimeService.startProcessInstanceByKey("myProcess", vars);
		System.out.println("启动流程后数据量：" + personService.countPerson());
	}

}
