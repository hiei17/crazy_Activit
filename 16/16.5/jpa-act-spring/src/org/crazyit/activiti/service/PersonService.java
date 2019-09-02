package org.crazyit.activiti.service;

import java.math.BigInteger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.crazyit.activiti.entity.Person;
import org.springframework.transaction.annotation.Transactional;

/**
 * Person服务类
 * @author yangenxiong
 *
 */
public class PersonService {

	@PersistenceContext
	private EntityManager entityManager;
	
	/**
	 * 创建Person并保存到数据库
	 */
	@Transactional
	public void createPerson(String name, int age) {
		Person p = new Person();
		p.setName(name);
		p.setAge(age);
		// 保存到数据库
		entityManager.persist(p);
	}
	
	/**
	 * 查询PERSON表数据
	 */
	public BigInteger countPerson() {
		Query query = entityManager.createNativeQuery("select count(*) from PERSON");
		BigInteger count = (BigInteger)query.getSingleResult();
		return count;
	}
}
