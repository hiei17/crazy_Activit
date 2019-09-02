package org.crazyit.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

/**
 * 参数类型
 * 
 * @author yangenxiong
 * 
 */
public class LocalVariable {

	public static void main(String[] args) {
		// 获取流程引擎实例
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 获取任务服务组件
		TaskService taskService = engine.getTaskService();
		// 获取运行服务组件
		RuntimeService runtimeService = engine.getRuntimeService();
		// 流程存储服务组件
		RepositoryService repositoryService = engine.getRepositoryService();
		// 部署流程描述文件
		Deployment dep = repositoryService.createDeployment()
				.addClasspathResource("bpmn/vacation.bpmn").deploy();
		// 查找流程定义
		ProcessDefinition pd = repositoryService.createProcessDefinitionQuery()
				.deploymentId(dep.getId()).singleResult();
		// 启动流程
		ProcessInstance pi = runtimeService
				.startProcessInstanceById(pd.getId());
		// 分别调用setVariable和setVariableLocal方法
		Task task = taskService.createTaskQuery().processInstanceId(pi.getId())
				.singleResult();
		taskService.setVariable(task.getId(), "days", 10);
		taskService.setVariableLocal(task.getId(), "target", "欧洲");

		// 获取参数
		Object data1 = taskService.getVariable(task.getId(), "days");
		System.out.println("获取休假天数：" + data1);
		Object data2 = taskService.getVariable(task.getId(), "target");
		System.out.println("获取目的地： " + data2);
		// 获取参数
		Object data3 = taskService.getVariableLocal(task.getId(), "days");
		System.out.println("使用getVariableLocal方法获取天数：" + data3);
	}

}
