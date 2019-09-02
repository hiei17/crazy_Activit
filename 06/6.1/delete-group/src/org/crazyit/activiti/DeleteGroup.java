package org.crazyit.activiti;

import java.util.UUID;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.Group;

/**
 * 添加用户组
 * 
 * @author yangenxiong
 * 
 */
public class DeleteGroup {

	public static void main(String[] args) {
		// 创建默认的流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到身份服务组件实例
		IdentityService identityService = engine.getIdentityService();
		String genId = UUID.randomUUID().toString();
		// 调用newGroup方法创建Group实例
		Group group = identityService.newGroup(genId);
		group.setName("经理组");
		group.setType("manager");
		// 保存Group到数据库
		identityService.saveGroup(group);
		// 查询用户组
		System.out.println("保存后用户组数量："
				+ identityService.createGroupQuery().count());
		// 根据ID删除用户组
		identityService.deleteGroup(genId);
		System.out.println("删除后用户组数量："
				+ identityService.createGroupQuery().count());
	}
}
