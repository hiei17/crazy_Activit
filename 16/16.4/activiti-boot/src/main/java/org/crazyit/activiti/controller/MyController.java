package org.crazyit.activiti.controller;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MyController {

	@Autowired
	private RepositoryService repositoryService;

	@Autowired
	RuntimeService runtimeService;
	@Autowired
	private TaskService taskService;

	Map<String,Map<String,List<Long>>> aMap=new HashMap<>();
	@RequestMapping("/welcome")
	@ResponseBody
	public void startAll() {

		List<ProcessDefinition> definitionList = repositoryService.createProcessDefinitionQuery().list();

		String pstr = "toolsClaim";
		definitionList.forEach(d->runtimeService.startProcessInstanceById(d.getId(), pstr));

		List<Task> tasks = taskService.createTaskQuery().processInstanceBusinessKey(pstr).list();
		Task task = tasks.get(0);
		String tStr = task.getTaskDefinitionKey();

	}

	@RequestMapping("/allInstance")
	@ResponseBody
	public void ins() {

		List<ProcessInstance> list = runtimeService.createProcessInstanceQuery().list();
		list.forEach(s-> System.out.print(s));
		ProcessInstance processInstance = list.get(0);


	//	Task task = tasks.get(0);
	//	task.getName();


	}
}
