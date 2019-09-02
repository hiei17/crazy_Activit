package org.crazyit.activiti;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.identity.User;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;

/**
 * 开始流程用户权限
 * 
 * @author yangenxiong
 *
 */
public class UserCandidate {

	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到流程存储服务实例
		RepositoryService repositoryService = engine.getRepositoryService();
		// 得到身份服务组件
		IdentityService identityService = engine.getIdentityService();

		// 部署流程描述文件
		Deployment dep = repositoryService.createDeployment()
				.addClasspathResource("bpmn/candidateUser.bpmn").deploy();


		// 查询流程定义实体
		ProcessDefinition def = repositoryService
				.createProcessDefinitionQuery()
				.deploymentId(dep.getId())
				.singleResult();

		// 写入用户数据
		creatUser(identityService, "user1", "angus", "young", "abc@163.com",
				"123");
		creatUser(identityService, "user2", "angus2", "young2", "abc@163.com",
				"123");
		creatUser(identityService, "user3", "angus3", "young3", "abc@163.com",
				"123");

		// mark 设置用户组与流程定义的关系（设置权限）
		//存到了 repository_identityLink 表
		repositoryService.addCandidateStarterUser(def.getId(), "user1");
		repositoryService.addCandidateStarterUser(def.getId(), "user2");
	}

	// 创建用户方法
	private static void creatUser(IdentityService identityService, String id,
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
