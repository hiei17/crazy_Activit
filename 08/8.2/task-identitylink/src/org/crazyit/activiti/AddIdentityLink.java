package org.crazyit.activiti;

import java.util.List;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.activiti.engine.task.IdentityLink;
import org.activiti.engine.task.IdentityLinkType;
import org.activiti.engine.task.Task;

/**
 * 添加任务权限数据
 * @author yangenxiong
 *
 */
public class AddIdentityLink {

	public static void main(String[] args) {
		//获取流程引擎实例
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 获取身份服务组件
		IdentityService identityService = engine.getIdentityService();
		// 新建用户组
		Group groupA = createGroup(identityService, "group1", "经理组", "manager");
		// 新建用户
		User user = creatUser(identityService, "user1", "张三", "last", "abc@163.com", "123");
		// 获取任务服务组件
		TaskService taskService = engine.getTaskService();
		//保存第一个Task
		Task task1 = taskService.newTask("task1");
		task1.setName("申请任务");
		taskService.saveTask(task1);
		//调用addGroupIdentityLink方法
		taskService.addGroupIdentityLink(task1.getId(), groupA.getId(), IdentityLinkType.CANDIDATE);
		taskService.addGroupIdentityLink(task1.getId(), groupA.getId(), IdentityLinkType.OWNER);
		taskService.addGroupIdentityLink(task1.getId(), groupA.getId(), IdentityLinkType.ASSIGNEE);
		//调用addUserIdentityLink方法
		Task task2 = taskService.newTask("task2");
		task2.setName("申请任务2");
		taskService.saveTask(task2);
		taskService.addUserIdentityLink(task2.getId(), user.getId(), IdentityLinkType.CANDIDATE);
		taskService.addUserIdentityLink(task2.getId(), user.getId(), IdentityLinkType.OWNER);
		taskService.addUserIdentityLink(task2.getId(), user.getId(), IdentityLinkType.ASSIGNEE);
	}

	//创建用户方法
	static User creatUser(IdentityService identityService, String id, String first, 
			String last, String email, String passwd) {
		// 使用newUser方法创建User实例
		User user = identityService.newUser(id);
		// 设置用户的各个属性
		user.setFirstName(first);
		user.setLastName(last);
		user.setEmail(email);
		user.setPassword(passwd);
		// 使用saveUser方法保存用户
		identityService.saveUser(user);
		return identityService.createUserQuery().userId(id).singleResult();
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
