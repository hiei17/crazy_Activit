package org.crazyit.activiti;

import org.activiti.engine.*;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import java.util.List;

/**
 * 设置Local参数
 * @author yangenxiong
 *
 */
public class SetVariableLocal {


	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到流程存储服务实例
		RepositoryService repositoryService = engine.getRepositoryService();
		// 得到运行时服务组件
		RuntimeService runtimeService = engine.getRuntimeService();
		// 得到任务
		TaskService taskService = engine.getTaskService();

		// 部署流程描述文件
		repositoryService
				.createDeployment()
				.addClasspathResource("bpmn/localVariable.bpmn20.xml")
				.deploy();

		//启动流程
		ProcessInstance pi = runtimeService.startProcessInstanceByKey("vacationRequest");

		//查询全部的任务，得到相应的执行流，设置不同的参数
		List<Task> tasks = taskService.createTaskQuery().processInstanceId(pi.getId()).list();

		for (Task task : tasks) {

			String executionId = task.getExecutionId();
			Execution exe = runtimeService
					.createExecutionQuery()
					.executionId(executionId)
					.singleResult();

			String exeId = exe.getId();

			if ("Manager Audit".equals(task.getName())) {
				//mark 经理审核节点，设置Local参数
				runtimeService.setVariableLocal(exeId, "managerVar", "manager var");
			} else {
				//HR审核节点，设置全局参数
				runtimeService.setVariable(exeId, "hrVar", "hr var");
			}
		}

		//两个执行流时输出参数
		for (Task task : tasks) {

			Execution exe = runtimeService.createExecutionQuery()
					.executionId(task.getExecutionId()).singleResult();

			String exeId = exe.getId();

			if ("Manager Audit".equals(task.getName())) {
				System.out.println("使用getVariableLocal方法获取经理参数：" + 
						runtimeService.getVariableLocal(exeId, "managerVar"));

				System.out.println("使用getVariable方法获取经理参数：" + 
						runtimeService.getVariableLocal(exeId, "managerVar"));
			} else {

				System.out.println("使用getVariableLocal方法获取HR参数：" + 
						runtimeService.getVariableLocal(exeId, "hrVar"));

				System.out.println("使用getVariable方法获取HR参数：" + 
						runtimeService.getVariable(exeId, "hrVar"));
			}
		}

		//完成任务
		for (Task task : tasks) {
			taskService.complete(task.getId());
		}
		System.out.println("========  完成流程分支后     ========");

		//重新查找流程任务
		tasks = taskService.createTaskQuery().processInstanceId(pi.getId()).list();
		for (Task task : tasks) {
			System.out.println("当前流程节点：" + task.getName());
			Execution exe = runtimeService
					.createExecutionQuery()
					.executionId(task.getExecutionId())
					.singleResult();
			System.out.println("经理参数：" + runtimeService.getVariable(exe.getId(), "managerVar"));
			System.out.println("HR参数：" + runtimeService.getVariable(exe.getId(), "hrVar"));
		}

	}

}
