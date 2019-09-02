package org.crazyit.activiti;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.task.IdentityLinkType;
import org.activiti.engine.task.Task;

/**
 * 删除用户组权限数据
 * 
 * @author yangenxiong
 * 
 */
public class DeleteGroupIdentity {

	public static void main(String[] args) {
		// 获取流程引擎实例
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 获取身份服务组件
		IdentityService identityService = engine.getIdentityService();
		// 新建用户组
		Group groupA = createGroup(identityService, "group1", "经理组", "manager");
		// 获取任务服务组件
		TaskService taskService = engine.getTaskService();
		// 保存第一个Task
		Task task1 = taskService.newTask("task1");
		task1.setName("审批任务");
		taskService.saveTask(task1);
		// 调用addGroupIdentityLink方法
		taskService.addGroupIdentityLink(task1.getId(), groupA.getId(),
				IdentityLinkType.CANDIDATE);
		taskService.addGroupIdentityLink(task1.getId(), groupA.getId(),
				IdentityLinkType.OWNER);
		taskService.addGroupIdentityLink(task1.getId(), groupA.getId(),
				IdentityLinkType.ASSIGNEE);
		// 调用delete方法
		taskService.deleteCandidateGroup(task1.getId(), groupA.getId());

		// 以下两个s方法将抛出异常
		taskService.deleteGroupIdentityLink(task1.getId(), groupA.getId(),
				IdentityLinkType.OWNER);
		taskService.deleteGroupIdentityLink(task1.getId(), groupA.getId(),
				IdentityLinkType.ASSIGNEE);
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
