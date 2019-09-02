package org.crazyit.activiti;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.DataObject;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import java.util.Map;

/**
 * 参数类型
 * 
 * @author yangenxiong
 * 
 */
public class TestDataObject {

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
				.addClasspathResource("bpmn/dataObject.bpmn").deploy();
		// 查找流程定义
		ProcessDefinition pd = repositoryService.createProcessDefinitionQuery()
				.deploymentId(dep.getId()).singleResult();


		// 启动流程
		ProcessInstance pi = runtimeService
				.startProcessInstanceById(pd.getId());

		// 查询流程任务
		Task task = taskService.createTaskQuery().processInstanceId(pi.getId())
				.singleResult();

		// mark  获取全部参数
		Map<String, DataObject> objs = taskService.getDataObjects(task.getId());
		// 输出参数
		for(String key : objs.keySet()) {
			System.out.println(key + "---" + objs.get(key).getValue());
		}
		objs=runtimeService.getDataObjects(pi.getId());
		// 输出参数
		for(String key : objs.keySet()) {
			System.out.println(key + "---" + objs.get(key).getValue());
		}
	}

}
