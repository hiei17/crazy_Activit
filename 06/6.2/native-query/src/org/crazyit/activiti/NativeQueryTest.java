package org.crazyit.activiti;

import java.util.List;
import java.util.UUID;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.Group;

/**
 * 使用NativeQuery
 * 
 * @author yangenxiong
 * 
 */
public class NativeQueryTest {

	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到身份服务组件实例
		IdentityService identityService = engine.getIdentityService();
		// 写入5条用户组数据
		createGroup(identityService, UUID.randomUUID().toString(), "GroupA",
				"typeA");
		createGroup(identityService, UUID.randomUUID().toString(), "GroupB",
				"typeB");
		createGroup(identityService, UUID.randomUUID().toString(), "GroupC",
				"typeC");
		createGroup(identityService, UUID.randomUUID().toString(), "GroupD",
				"typeD");
		createGroup(identityService, UUID.randomUUID().toString(), "GroupE",
				"typeE");
		// 使用原生SQL查询全部数据
		List<Group> groups = identityService.createNativeGroupQuery()
				.sql("select * from ACT_ID_GROUP").list();
		System.out.println("查询全部数据：" + groups.size());
		// 使用原生SQL按条件查询，并设入参数，只查到一条数据
		groups = identityService.createNativeGroupQuery()
				.sql("select * from ACT_ID_GROUP where NAME_ = 'GroupC'")
				.list();
		System.out.println("按条件查询：" + groups.get(0).getName());
		// 使用parameter方法设置查询参数
		groups = identityService.createNativeGroupQuery()
				.sql("select * from ACT_ID_GROUP where NAME_ = #{name}")
				.parameter("name", "GroupD").list();
		System.out.println("使用parameter方法按条件查询：" + groups.get(0).getName());
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
