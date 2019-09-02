package org.crazyit.activiti;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.identity.User;
import org.activiti.engine.task.IdentityLinkType;
import org.activiti.engine.task.Task;

/**
 * 删除用户组权限数据
 * @author yangenxiong
 *
 */
public class DeleteUserIdentity {

	public static void main(String[] args) {

		//获取流程引擎实例
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 获取身份服务组件
		IdentityService identityService = engine.getIdentityService();

		// 新建用户
		User user = creatUser(identityService, "user1", "first", "last", "abc@163.com", "123");

		// 获取任务服务组件
		TaskService taskService = engine.getTaskService();
		//保存第一个Task
		Task task1 = taskService.newTask("task1");
		taskService.saveTask(task1);

		//添加用户权限
		taskService.addCandidateUser(task1.getId(), user.getId());
		long count = taskService.createTaskQuery().taskCandidateUser(user.getId()).count();
		System.out.println("调用addCandidateUser方法后，用户的候选任务数量：" + count);

		//删除用户权限
		taskService.deleteCandidateUser(task1.getId(), user.getId());
		count = taskService.createTaskQuery().taskCandidateUser(user.getId()).count();
		System.out.println("调用deleteCandidateUser方法后，用户的候选任务数量：" + count);

		//添加用户权限
		taskService.addUserIdentityLink(task1.getId(), user.getId(), IdentityLinkType.OWNER);
		count = taskService.createTaskQuery().taskOwner(user.getId()).count();
		System.out.println("调用addUserIdentityLink方法后，用户的候选任务数量：" + count);
		//删除用户权限
		taskService.deleteUserIdentityLink(task1.getId(), user.getId(), IdentityLinkType.OWNER);
		count = taskService.createTaskQuery().taskOwner(user.getId()).count();
		System.out.println("调用deleteUserIdentityLink方法后，用户的候选任务数量：" + count);

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
}
