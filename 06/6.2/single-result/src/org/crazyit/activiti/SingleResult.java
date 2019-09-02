package org.crazyit.activiti;

import java.util.UUID;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.repository.Deployment;

/**
 * 使用Query的singleResult方法
 * @author yangenxiong
 *
 */
public class SingleResult {

	public static void main(String[] args) {
		//创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到身份服务组件实例
		IdentityService identityService = engine.getIdentityService();
		// 写入5条用户组数据
		createGroup(identityService, UUID.randomUUID().toString(), "GroupA", "typeA");
		createGroup(identityService, UUID.randomUUID().toString(), "GroupB", "typeB");
		createGroup(identityService, UUID.randomUUID().toString(), "GroupC", "typeC");
		createGroup(identityService, UUID.randomUUID().toString(), "GroupD", "typeD");
		createGroup(identityService, UUID.randomUUID().toString(), "GroupE", "typeE");
		//再写入一条名称为GroupA的数据
		createGroup(identityService, UUID.randomUUID().toString(), "GroupA", "typeF");
		//查询名称为GroupB的记录
		Group groupB = identityService.createGroupQuery()
				.groupName("GroupB").singleResult();
		System.out.println("查询到一条GroupB数据：" + groupB.getId() + "---" + groupB.getName());
		//查询名称为GroupF的记录
		Group groupF = identityService.createGroupQuery()
				.groupName("GroupF").singleResult();
		System.out.println("没有groupF的数据：" + groupF);
		//查询名称为GroupA的记录，这里将抛出异常
		Group groupA = identityService.createGroupQuery()
				.groupName("GroupA").singleResult();
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
}
