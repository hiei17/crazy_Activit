package org.crazyit.activiti;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.task.Task;

/**
 * 使用addCandidateGroup方法
 * @author yangenxiong
 *
 */
public class AddCandidateGroup {

	public static void main(String[] args) {
		//获取流程引擎实例
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 获取身份服务组件
		IdentityService identityService = engine.getIdentityService();
		// 新建用户组
		Group groupA = createGroup(identityService, "group1", "经理组", "manager");
		// 获取任务服务组件
		TaskService taskService = engine.getTaskService();
		//保存第一个Task
		Task task1 = taskService.newTask("task1");
		taskService.saveTask(task1);
		//保存第二个Task
		Task task2 = taskService.newTask("task2");
		taskService.saveTask(task2);
		//绑定用户组和任务关系
		taskService.addCandidateGroup("task1", groupA.getId());
		taskService.addCandidateGroup("task2", groupA.getId());
	}
	
	// 将用户组数据保存到数据库中
	static Group createGroup(IdentityService identityService, String id,
			String name, String type) {
		// 调用newGroup方法创建Group实例
		Group group = identityService.newGroup(id);
		group.setName(name);
		group.setType(type);
		identityService.saveGroup(group);
		return identityService.createGroupQuery().groupId(id).singleResult();
	}

}
