package org.crazyit.activiti;

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
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Event;
import org.activiti.engine.task.Task;

/**
 * 事件记录
 * @author yangenxiong
 *
 */
public class EventRecord {

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
		// 查找任务
		Task task = taskService.createTaskQuery().processInstanceId(pi.getId())
				.singleResult();
		// 调用各个记录事件的方法 
		taskService.addComment(task.getId(), pi.getId(), "this is comment message");		
		taskService.addUserIdentityLink(task.getId(), "1", "user");
		taskService.deleteUserIdentityLink(task.getId(), "1", "user");
		taskService.addGroupIdentityLink(task.getId(), "1", "group");
		taskService.deleteGroupIdentityLink(task.getId(), "1", "group");
		Attachment atta = taskService.createAttachment("test", task.getId(), pi.getId(), "test", "test", "");
		taskService.deleteAttachment(atta.getId());
		// 查询Comment和Event
		List<Comment> comments = taskService.getTaskComments(task.getId());
		System.out.println("总共的评论数量：" + comments.size());
		List<Event> events = taskService.getTaskEvents(task.getId());
		System.out.println("总共的事件数量：" + events.size());
	}
}
