package org.crazyit.activiti;

import org.activiti.engine.*;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

public class ExecutionListenerInvocation implements ExecutionListener {

	private Expression message;

	public void setMessage(Expression message) {
		this.message = message;
	}

	public void notify(DelegateExecution execution) {
		System.out.println("流程监听器：" + message.getValue(execution));
	}

	public static void main(String[] args) {

		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到流程存储服务组件
		RepositoryService repositoryService = engine.getRepositoryService();
		// 得到运行时服务组件
		RuntimeService runtimeService = engine.getRuntimeService();
		// 得到任务服务组件
		TaskService taskService = engine.getTaskService();

		// 部署流程文件
		Deployment deployment = repositoryService
				.createDeployment()
				.addClasspathResource("bpmn/ExecutionListenerInvocation.bpmn")
				.deploy();

		// 启动流程
		ProcessInstance pi = runtimeService
				//.startProcessInstanceByKey("process1","businessKey534754");
				.startProcessInstanceByKey("panda","businessKey534754");
		// 查找并完成任务
		Task task = taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();
		taskService.complete(task.getId());

		engine.close();
	}

}
