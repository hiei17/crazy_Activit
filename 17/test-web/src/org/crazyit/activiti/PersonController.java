package org.crazyit.activiti;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

	@RequestMapping(value = "/person/{personId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonResponse findPerson(@PathVariable("personId") Integer personId) {
		PersonResponse pr = new PersonResponse();
		pr.setId(1);
		pr.setName("Angus");
		pr.setAge(30);
		return pr;
	}
}
