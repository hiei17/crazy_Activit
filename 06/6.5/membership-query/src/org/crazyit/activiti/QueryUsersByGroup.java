package org.crazyit.activiti;

import java.util.List;
import java.util.UUID;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;

/**
 * 绑定用户组与用户的关系
 * 
 * @author yangenxiong
 *
 */
public class QueryUsersByGroup {

	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到身份服务组件实例
		IdentityService identityService = engine.getIdentityService();
		// 保存两个用户
		User user1 = creatUser(identityService, UUID.randomUUID().toString(),
				"张经理", "young", "yangenxiong@163.com", "abc");
		User user2 = creatUser(identityService, UUID.randomUUID().toString(),
				"李经理", "young2", "yangenxiong@163.com", "abc");
		// 保存一个用户组
		Group group = createGroup(identityService,
				UUID.randomUUID().toString(), "经理组", "manager");
		// 将两个用户分配到用户组下
		identityService.createMembership(user1.getId(), group.getId());
		identityService.createMembership(user2.getId(), group.getId());
		List<User> users = identityService.createUserQuery()
				.memberOfGroup(group.getId()).list();
		System.out.println("经理组有如下人员：");
		for (User user : users) {
			System.out.println(user.getFirstName());
		}
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
