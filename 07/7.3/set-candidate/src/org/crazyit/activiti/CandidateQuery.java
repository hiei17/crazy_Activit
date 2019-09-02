package org.crazyit.activiti;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.IdentityLink;

import java.util.List;

/**
 * 查询流程定义的权限数据
 * 
 * @author yangenxiong
 *
 */
public class CandidateQuery {

	public static void main(String[] args) {

		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到流程存储服务实例
		RepositoryService repositoryService = engine.getRepositoryService();
		// 得到身份服务组件
		IdentityService identityService = engine.getIdentityService();
		// 部署流程描述文件
		Deployment dep = repositoryService.createDeployment()
				.addClasspathResource("bpmn/candidateQuery.bpmn").deploy();

		// 添加2个用户
		creatUser(identityService, "user1", "张三", "张三", "mail1", "123");
		creatUser(identityService, "user2", "李四", "李四", "mail2", "123");
		// 添加2个用户组
		createGroup(identityService, "group1", "经理组", "manager");
		createGroup(identityService, "group2", "员工组", "employee");
		// 查询流程定义
		ProcessDefinition def = repositoryService
				.createProcessDefinitionQuery().deploymentId(dep.getId())
				.singleResult();
		// 设置权限数据
		repositoryService.addCandidateStarterGroup(def.getId(), "group1");
		repositoryService.addCandidateStarterGroup(def.getId(), "group2");
		repositoryService.addCandidateStarterUser(def.getId(), "user1");
		repositoryService.addCandidateStarterUser(def.getId(), "user2");

		// mark 根据	用户查询	用权限的	流程定义 repositoryService
		List<ProcessDefinition> defs = repositoryService
				.createProcessDefinitionQuery()
				.startableByUser("user1")
				.list();
		System.out.println("用户张三有权限的流程定义为：");// 结果为1
		for (ProcessDefinition dft : defs) {
			System.out.println("   " + dft.getName());
		}

		// mark 根据	流程定义	查询	用户组identityService
		List<Group> groups = identityService
				.createGroupQuery()
				.potentialStarter(def.getId())
				.list();
		System.out.println("以下用户组对流程定义有权限：");
		for (Group group : groups) {
			System.out.println("   " + group.getName());
		}

		//mark  根据流 程定义 查询 用户数据
		List<User> users = identityService
				.createUserQuery()
				.potentialStarter(def.getId())
				.list();
		System.out.println("以下用户对流程定义有权限：");// 结果为2
		for (User user : users) {
			System.out.println("   " + user.getFirstName());
		}

		//mark  根据 流程定义 查询全部的 IdentityLink（ACT_RU_IDENTITYLINK表） 数据 repositoryService
		List<IdentityLink> links = repositoryService
				.getIdentityLinksForProcessDefinition(def.getId());
		System.out.println("与流程定义相关的数据量： " + links.size());// 结果为4
	}

	// 将用户组数据保存到数据库中
	static void createGroup(IdentityService identityService, String id,
			String name, String type) {
		// 调用newGroup方法创建Group实例
		Group group = identityService.newGroup(id);
		group.setName(name);
		group.setType(type);
		identityService.saveGroup(group);
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
