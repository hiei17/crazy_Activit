package org.crazyit.activiti.dao.impl;

import org.crazyit.activiti.dao.PersonDao;
import org.crazyit.activiti.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class PersonDaoImpl implements PersonDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(Person person) {
		// 获取Hibernate的Session
		Session session = sessionFactory.getCurrentSession();
		session.save(person);
	}
	
}
