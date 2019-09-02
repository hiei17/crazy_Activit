package org.crazyit.activiti;

import java.util.List;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.Group;

/**
 * Query的多字段排序
 * @author yangenxiong
 *
 */
public class SortMix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到身份服务组件实例
		IdentityService identityService = engine.getIdentityService();
		// 写入5条用户组数据
		createGroup(identityService, "1", "GroupE", "typeB");
		createGroup(identityService, "2", "GroupD", "typeC");
		createGroup(identityService, "3", "GroupC", "typeD");
		createGroup(identityService, "4", "GroupB", "typeE");
		createGroup(identityService, "5", "GroupA", "typeA");
		//优先按照id降序、名称升序排序
		System.out.println("ID降序排序：");
		List<Group> datas = identityService.createGroupQuery()
				.orderByGroupId().desc()
				.orderByGroupName().asc().list();
		for (Group data : datas) {
			System.out.println("    " + data.getId() + "---" + data.getName() + " ");
		}
		System.out.println("名称降序排序：");
		//下面结果将按名称排序
		datas = identityService.createGroupQuery().orderByGroupId()
				.orderByGroupName().desc().list();
		for (Group data : datas) {
			System.out.println("    " + data.getId() + "---" + data.getName() + " ");
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
