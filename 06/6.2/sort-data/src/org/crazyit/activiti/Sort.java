package org.crazyit.activiti;

import java.util.List;
import java.util.UUID;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.Group;

/**
 * Query的排序
 * @author yangenxiong
 *
 */
public class Sort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到身份服务组件实例
		IdentityService identityService = engine.getIdentityService();
		// 写入5条用户组数据
		createGroup(identityService, UUID.randomUUID().toString(), "1", "typeA");
		createGroup(identityService, UUID.randomUUID().toString(), "2", "typeB");
		createGroup(identityService, UUID.randomUUID().toString(), "3", "typeC");
		createGroup(identityService, UUID.randomUUID().toString(), "4", "typeD");
		createGroup(identityService, UUID.randomUUID().toString(), "5", "typeE");
		//调用orderByGroupId和asc方法，结果为按照ID升序排序
		System.out.println("asc排序结果：");
		List<Group> datas = identityService.createGroupQuery().orderByGroupName().asc().list();
		for (Group data : datas) {
			System.out.println("    " + data.getId() + "---" + data.getName());
		}
		System.out.println("desc排序结果");
		//调用orderByGroupName和desc方法，结果为名称降序排序
		datas = identityService.createGroupQuery().orderByGroupName().desc().list();
		for (Group data : datas) {
			System.out.println("    " + data.getId() + "---" + data.getName());
		}
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
