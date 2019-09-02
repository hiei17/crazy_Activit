package org.crazyit.activiti;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.crazyit.activiti.entity.Person;

public class TestMain {

	public static void main(String[] args) {
		// 创建实体管理工厂
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJpaUnit");
		// 创建实体管理器
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
		// 关闭实体管理工厂
		factory.close();
	}

}
