package org.crazyit.activiti;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.FormService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

public class ExternalForm {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		RepositoryService repositoryService = engine.getRepositoryService();
		FormService formService = engine.getFormService();
		TaskService taskService = engine.getTaskService();
		// 部署全部文件
		Deployment dep = repositoryService.createDeployment()
				.addClasspathResource("bpmn/ExternalForm.bpmn")
				.addClasspathResource("form/start.jsp")
				.addClasspathResource("form/task.form").deploy();
		// 流程定义
		ProcessDefinition pd = repositoryService.createProcessDefinitionQuery()
				.deploymentId(dep.getId()).singleResult();
		// 启动流程并设置days参数
		Map<String, String> vars = new HashMap<String, String>();
		vars.put("days", "4");
		ProcessInstance pi = formService.submitStartFormData(pd.getId(), vars);
		// 输出开始表单内容
		Object obj = formService.getRenderedStartForm(pd.getId());
		System.out.println(obj);
		// 输出被渲染后的任务表单内容
		Task task = taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();
		Object form = formService.getRenderedTaskForm(task.getId());
		System.out.println(form);
	}

}
