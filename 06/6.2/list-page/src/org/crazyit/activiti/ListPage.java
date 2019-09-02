package org.crazyit.activiti;

import java.util.List;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.Group;

/**
 * 使用Query的listPage方法
 * @author yangenxiong
 *
 */
public class ListPage {

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
		createGroup(identityService, "2", "GroupB", "typeB");
		createGroup(identityService, "3", "GroupC", "typeC");
		createGroup(identityService, "4", "GroupD", "typeD");
		createGroup(identityService, "5", "GroupE", "typeE");
		//调用listPage方法，从索引为2的记录开始，查询3条记录
		List<Group> datas = identityService.createGroupQuery().listPage(2, 3);
		for (Group data : datas) {
			System.out.println(data.getId() + "---" + data.getName() + " ");
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
