package org.crazyit.activiti;

import java.util.UUID;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.User;

/**
 * 添加用户
 * @author yangenxiong
 *
 */
public class AddUser {

	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到身份服务组件实例
		IdentityService identityService = engine.getIdentityService();
		String id = UUID.randomUUID().toString();
		// 使用newUser方法创建User实例
		User user = identityService.newUser(id);
		// 设置用户的各个属性
		user.setFirstName("Angus");
		user.setLastName("Young");
		user.setEmail("yangenxiong@163.com");
		user.setPassword("abc");
		// 使用saveUser方法保存用户
		identityService.saveUser(user);
		// 根据 id 查询
		user = identityService.createUserQuery().userId(id).singleResult();
		System.out.println(user.getEmail());
	}

}
