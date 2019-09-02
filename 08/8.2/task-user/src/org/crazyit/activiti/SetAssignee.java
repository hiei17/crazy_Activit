package org.crazyit.activiti;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.identity.User;
import org.activiti.engine.task.Task;

/**
 * 设置任务受理人
 * 
 * @author yangenxiong
 * 
 */
public class SetAssignee {

	public static void main(String[] args) {
		// 获取流程引擎实例
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 获取身份服务组件
		IdentityService identityService = engine.getIdentityService();
		// 新建用户
		User user = creatUser(identityService, "user1", "张三", "last",
				"abc@163.com", "123");
		// 获取任务服务组件
		TaskService taskService = engine.getTaskService();
		// 保存一个Task
		Task task1 = taskService.newTask("task1");
		task1.setName("申请任务");
		taskService.saveTask(task1);
		// 设置任务持有人
		taskService.setAssignee(task1.getId(), user.getId());
		System.out.println("用户张三受理的任务数量："
				+ taskService.createTaskQuery().taskAssignee(user.getId())
						.count());
	}

	// 创建用户方法
	static User creatUser(IdentityService identityService, String id,
			String first, String last, String email, String passwd) {
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
