package org.crazyit.activiti;

import java.util.List;
import java.util.UUID;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.User;

/**
 * 查询用户数据
 * 
 * @author yangenxiong
 *
 */
public class UserQuery {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到身份服务组件实例
		IdentityService identityService = engine.getIdentityService();
		String id1 = UUID.randomUUID().toString();
		String id2 = UUID.randomUUID().toString();
		// 创建两个用户
		creatUser(identityService, id1, "angus", "young",
				"yangenxiong@163.com", "abc");
		creatUser(identityService, id2, "angus2", "young2", "abc@163.com",
				"123");
		// 调用UserQuery的各个查询方法
		// userId
		User user = identityService.createUserQuery().userId(id1)
				.singleResult();
		System.out.println("userId:" + user.getFirstName());
		// userFirstName
		user = identityService.createUserQuery().userFirstName("angus")
				.singleResult();
		System.out.println("userFirstName:" + user.getFirstName());
		// userFirstNameLike
		List<User> datas = identityService.createUserQuery()
				.userFirstNameLike("angus%").list();
		System.out.println("createUserQuery:" + datas.size());
		// userLastName
		user = identityService.createUserQuery().userLastName("young")
				.singleResult();
		System.out.println("userLastName:" + user.getFirstName());
		// userLastNameLike
		datas = identityService.createUserQuery().userLastNameLike("young%")
				.list();
		System.out.println("userLastNameLike:" + datas.size());
		// userEmail
		user = identityService.createUserQuery().userEmail("abc@163.com")
				.singleResult();
		System.out.println("userEmail:" + user.getFirstName());
		// userEmailLike
		datas = identityService.createUserQuery().userEmailLike("%163.com")
				.list();
		System.out.println("userEmailLike:" + datas.size());
		// 使用NativeQuery
		datas = identityService.createNativeUserQuery()
				.sql("select * from ACT_ID_USER where EMAIL_ = #{email}")
				.parameter("email", "yangenxiong@163.com").list();
		System.out.println("native query:" + datas.get(0).getEmail());
	}

	// 创建用户方法
	static void creatUser(IdentityService identityService, String id,
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
	}

}
