package org.crazyit.activiti;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import java.util.HashMap;
import java.util.Map;

/**
 * 任务提醒 
 * @author yangenxiong
 *
 */
public class Complete {

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
				.addClasspathResource("bpmn/vacation2.bpmn").deploy();
		// 查找流程定义
		ProcessDefinition pd = repositoryService.createProcessDefinitionQuery()
				.deploymentId(dep.getId()).singleResult();
		// 启动流程
		ProcessInstance pi = runtimeService
				.startProcessInstanceById(pd.getId());

		//mark 查找任务
		Task task = taskService.createTaskQuery().processInstanceId(pi.getId())
				.singleResult();
		// 调用complete方法完成任务，传入参数
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("days", 2);
		// 设置临时的参数
		Map<String, Object> vars2 = new HashMap<String, Object>();
		vars2.put("temp", "temp var");
		taskService.complete(task.getId(), vars, vars2);//mark

		// mark 再次查找任务
		task = taskService.createTaskQuery().processInstanceId(pi.getId())
				.singleResult();
		// 无法查询临时参数
		String tempVar = (String)taskService.getVariable(task.getId(), "temp");
		System.out.println("查询临时参数：" + tempVar);
		
		//得到参数
		Integer days = (Integer)taskService.getVariable(task.getId(), "days");
		if (days > 5) {
			System.out.println("大于5天，不批");
		} else {
			System.out.println("小于5天，完成任务，流程结束");
			taskService.complete(task.getId());//mark
		}
	}

}
