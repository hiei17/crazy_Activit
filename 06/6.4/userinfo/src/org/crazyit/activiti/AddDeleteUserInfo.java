package org.crazyit.activiti;

import java.util.UUID;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.User;

/**
 * 添加删除用户信息
 * @author yangenxiong
 *
 */
public class AddDeleteUserInfo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到身份服务组件实例
		IdentityService identityService = engine.getIdentityService();
		String id = UUID.randomUUID().toString();
		// 创建用户
		creatUser(identityService, id, "angus", "young", "yangenxiong@163.com", "abc");
		// 创建一个用户信息
		identityService.setUserInfo(id, "age", "30");
		// 创建第二个用户信息
		identityService.setUserInfo(id, "weight", "60KG");
		// 删除用户年龄信息
		identityService.deleteUserInfo(id, "age");
	}

	//创建用户方法
	static void creatUser(IdentityService identityService, String id, String first, String last, String email, String passwd) {
		// 使用newUser方法创建User实例
		User user = identityService.newUser(id);
		// 设置用户的各个属性
		user.setFirstName(first);
		user.setLastName(last);
		user.setEmail(email);
		user.setPassword(passwd);
		// 使用saveUser方法保存用户
		identityService.saveUser(user);
	}
}
