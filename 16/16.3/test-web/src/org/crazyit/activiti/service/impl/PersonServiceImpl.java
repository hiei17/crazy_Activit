package org.crazyit.activiti.service.impl;

import org.activiti.engine.TaskService;
import org.crazyit.activiti.dao.PersonDao;
import org.crazyit.activiti.entity.Person;
import org.crazyit.activiti.service.PersonService;

public class PersonServiceImpl implements PersonService {

	private PersonDao personDao;

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	public void createPerson(String name) {
		// 创建一个Person实例
		Person p = new Person();
		p.setName(name);
		// 调用PersonDao的方法保存
		this.personDao.save(p);
	}

}
