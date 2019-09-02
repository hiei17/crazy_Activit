package org.crazyit.activiti;

import java.util.List;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.Group;

/**
 * Query的的排序问题
 * @author yangenxiong
 *
 */
public class SortProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到身份服务组件实例
		IdentityService identityService = engine.getIdentityService();
		// 写入5条用户组数据
		createGroup(identityService, "1", "GroupA", "typeA");
		createGroup(identityService, "12", "GroupB", "typeB");
		createGroup(identityService, "13", "GroupC", "typeC");
		createGroup(identityService, "2", "GroupD", "typeD");
		createGroup(identityService, "3", "GroupE", "typeE");
		//根据ID升序排序
		System.out.println("asc排序结果");
		List<Group> datas = identityService.createGroupQuery().orderByGroupId().asc().list();
		for (Group data : datas) {
			System.out.print(data.getId() + " ");
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
