package org.crazyit.activiti;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.User;
import org.activiti.engine.impl.identity.Authentication;

public class AuthenticatedUserId {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到身份服务组件实例
		final IdentityService identityService = engine.getIdentityService();
		// 设置当前线程的userId为1
		identityService.setAuthenticatedUserId("3");
		System.out.println("当前线程usreId：" + Authentication.getAuthenticatedUserId());
		// 启动两条线程
		new Thread() {
			public void run() {
				try {
					identityService.setAuthenticatedUserId("1");
					Thread.sleep(5000);
					System.out.println("线程1的userId：" + Authentication.getAuthenticatedUserId());
				} catch (Exception e) {
					
				}
			}
		}.start();
		
		new Thread() {
			public void run() {
				identityService.setAuthenticatedUserId("2");
				System.out.println("线程2的usrId：" + Authentication.getAuthenticatedUserId());
			}
		}.start();
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
