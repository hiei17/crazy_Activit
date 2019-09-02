package org.crazyit.activiti.web;

import org.crazyit.activiti.service.PersonService;

import com.opensymphony.xwork2.Action;

public class PersonAction implements Action {

	private PersonService personService;
	
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	public String execute() throws Exception {
		// 调用PersonService的方法
		personService.createPerson("crazyit");
		return null;
	}

}
