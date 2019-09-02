package org.crazyit.activiti;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FormProperty {

	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		RepositoryService repositoryService = engine.getRepositoryService();
		FormService formService = engine.getFormService();
		RuntimeService runtimeService = engine.getRuntimeService();
		// 部署文件
		Deployment dep = repositoryService.createDeployment()
				.addClasspathResource("bpmn/FormProperty.bpmn").deploy();
		// 查找流程定义
		ProcessDefinition pd = repositoryService.createProcessDefinitionQuery()
				.deploymentId(dep.getId()).singleResult();

		List<org.activiti.engine.form.FormProperty> formProperties = formService.getStartFormData(pd.getId()).getFormProperties();
		for (org.activiti.engine.form.FormProperty formProperty : formProperties) {
			String name = formProperty.getName();
			System.out.println("need user input: "+name);//mark  这里可以给前端
		}

		// 使用表单参数开始流程
		Map<String, String> vars = new HashMap<String, String>();
		vars.put("userName", "crazyit");
		ProcessInstance pi = formService.submitStartFormData(pd.getId(), vars);
		// 查询参数
		System.out.println(runtimeService.getVariable(pi.getId(), "userName"));
	}

}
