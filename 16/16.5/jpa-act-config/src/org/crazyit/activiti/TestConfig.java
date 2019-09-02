package org.crazyit.activiti;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.crazyit.activiti.entity.Person;

public class TestConfig {

	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		ProcessEngineConfiguration config = engine.getProcessEngineConfiguration();
		// 获取实体管理工厂
		EntityManagerFactory factory = (EntityManagerFactory)config.getJpaEntityManagerFactory();
		EntityManager em = factory.createEntityManager();
		// 开启事务
		em.getTransaction().begin();
		// 写入新数据
		Person p1 = new Person();
		p1.setName("Angus");
		p1.setAge(30);
		// 持久化对象
		em.persist(p1);
		// 提交事务
		em.getTransaction().commit();
		// 查询数据
		Query query = em.createQuery("SELECT p FROM PERSON p");
		List<Person> persons = query.getResultList();
		// 输出查询数据
		for(Person p : persons) {
			System.out.println("名称：" + p.getName() + ", 年龄：" + p.getAge());
		}
	}

}
