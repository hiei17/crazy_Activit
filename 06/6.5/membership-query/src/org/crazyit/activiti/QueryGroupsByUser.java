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
public class QueryGroupsByUser {

	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到身份服务组件实例
		IdentityService identityService = engine.getIdentityService();
		// 创建一个用户
		User user = creatUser(identityService, UUID.randomUUID().toString(),
				"张三", "young", "yangenxiong@163.com", "abc");
		// 创建两个用户组
		Group group1 = createGroup(identityService, UUID.randomUUID()
				.toString(), "经理组", "manager");
		Group group2 = createGroup(identityService, UUID.randomUUID()
				.toString(), "员工组", "manager");
		// 将用户与两个用户组绑定关系
		identityService.createMembership(user.getId(), group1.getId());
		identityService.createMembership(user.getId(), group2.getId());
		// 调用memberOfGroup方法查询用户所在的用户组
		List<Group> groups = identityService.createGroupQuery()
				.groupMember(user.getId()).list();
		System.out.println("张三属于的用户组有：");
		for (Group group : groups) {
			System.out.println(group.getName());
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
