package org.crazyit.activiti;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.activiti.engine.task.IdentityLink;
import org.activiti.engine.task.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * 权限数据查询
 * @author yangenxiong
 *
 */
public class Query {

	public static void main(String[] args) {

		//获取流程引擎实例
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 获取身份服务组件
		IdentityService identityService = engine.getIdentityService();

		// 新建用户
		User user = creatUser(identityService, "user1", "张三", "last", "abc@163.com", "123");
		// 新建用户组
		Group groupA = createGroup(identityService, "group1", "经理组", "manager");
		Group groupB = createGroup(identityService, "group2", "员工组", "employee");

		// 获取任务服务组件
		TaskService taskService = engine.getTaskService();
		//保存第一个Task
		Task task1 = taskService.newTask("task1");
		task1.setName("申请假期");
		taskService.saveTask(task1);
		//保存第二个Task
		Task task2 = taskService.newTask("task2");
		task2.setName("审批假期");
		taskService.saveTask(task2);

		//mark 绑定权限
		taskService.addCandidateGroup("task1", groupA.getId());
		taskService.addCandidateGroup("task2", groupB.getId());
		taskService.addCandidateUser("task2", user.getId());

		//mark 根据用户组查询任务
		List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup(groupA.getId()).list();
		System.out.println("经理组的候选任务有：");
		for (Task task : tasks) {
			System.out.println("   " + task.getName());
		}		
		//根据用户查询任务
		tasks = taskService.createTaskQuery().taskCandidateUser(user.getId()).list();
		System.out.println("张三的候选任务有");
		for (Task task : tasks) {
			System.out.println("   " + task.getName());
		}
		//调用taskCandidateGroupIn
		List<String> groupIds = new ArrayList<String>();
		groupIds.add(groupA.getId());
		groupIds.add(groupB.getId());
		tasks = taskService.createTaskQuery().taskCandidateGroupIn(groupIds).list();
		System.out.println("经理组与员工组的任务有：");
		for (Task task : tasks) {
			System.out.println("   " + task.getName());
		}
		//查询权限数据
		List<IdentityLink> links = taskService.getIdentityLinksForTask(tasks.get(0).getId());
		System.out.println("关系数据量: " + links.size());
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
