package org.crazyit.activiti;

import java.util.List;
import java.util.UUID;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.Group;

/**
 * 使用Query的count方法
 * 
 * @author yangenxiong
 * 
 */
public class Count {

	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到身份服务组件实例
		IdentityService identityService = engine.getIdentityService();
		// 写入5条用户组数据
		createGroup(identityService, UUID.randomUUID().toString(), "GroupA", "typeA");
		createGroup(identityService, UUID.randomUUID().toString(), "GroupB", "typeB");
		createGroup(identityService, UUID.randomUUID().toString(), "GroupC", "typeC");
		createGroup(identityService, UUID.randomUUID().toString(), "GroupD", "typeD");
		createGroup(identityService, UUID.randomUUID().toString(), "GroupE", "typeE");
		// 使用list方法查询全部的部署数据
		long size = identityService.createGroupQuery().count();
		System.out.println("Group 数量：" + size);
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
