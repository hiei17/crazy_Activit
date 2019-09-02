package org.crazyit.activiti;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.crazyit.activiti.entity.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJpaSpring {

	public static void main(String[] args) {
		// 启动Spring容器
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] { "activiti.cfg.xml" });		
		// 创建流程引擎
		ProcessEngine engine = (ProcessEngine)ctx.getBean("processEngine");
		// 获取流程引擎配置实例
		ProcessEngineConfiguration config = engine.getProcessEngineConfiguration();
		// 通过配置对象获取实体管理工厂
		EntityManagerFactory factory = (EntityManagerFactory)config.getJpaEntityManagerFactory();
		// 通过Spring容器获取EntityManagerFactory实例
		EntityManagerFactory factory2 = (EntityManagerFactory)ctx.getBean("entityManagerFactory");
		System.out.println(factory);
		System.out.println(factory2);
	}
}
