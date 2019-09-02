package org.crazyit.activiti;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Attachment;
import org.activiti.engine.task.Task;

/**
 * 创建任务附件
 * @author yangenxiong
 *
 */
public class DeleteAttachment {

	public static void main(String[] args) throws Exception {
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
		// 查找任务
		Task task = taskService.createTaskQuery().processInstanceId(pi.getId())
				.singleResult();
		// 设置任务附件
		Attachment att1 = taskService.createAttachment("web url", task.getId(), pi.getId(), "Attachement1", 
				"163 web page", "http://www.163.com");
		// 创建图片输入流
		InputStream is = new FileInputStream(new File("resource/artifact/result.png"));
		// 设置输入流为任务附件
		Attachment att2 = taskService.createAttachment("web url", task.getId(), pi.getId(), "Attachement2", 
				"Image InputStream", is);
		System.out.println("删除前数量：" + taskService.getTaskAttachments(task.getId()).size());
		taskService.deleteAttachment(att2.getId());
		System.out.println("删除后数量：" + taskService.getTaskAttachments(task.getId()).size());
	}

}
