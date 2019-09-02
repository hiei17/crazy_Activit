package org.crazyit.activiti;

import java.util.UUID;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.Group;

/**
 * 添加用户组
 * @author yangenxiong
 *
 */
public class AddGroup {

	public static void main(String[] args) {
		// 创建默认的流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到身份服务组件实例
		IdentityService identityService = engine.getIdentityService();
		// 生成UUID
		String genId = UUID.randomUUID().toString();
		//调用newGroup方法创建Group实例
		Group group = identityService.newGroup(genId);
		group.setName("经理组");
		group.setType("manager");
		//保存Group到数据库
		identityService.saveGroup(group);
		// 查询用户组
		Group data = identityService.createGroupQuery().groupId(genId).singleResult();
		// 保存后查询Group
		System.out.println("Group ID：" + data.getId() + ", Name：" + data.getName());
//		// 设置名称 
//		data.setName("经理2组");
//		identityService.saveGroup(data);
//		// 再次查询
//		data = identityService.createGroupQuery().groupId(genId).singleResult();
//		System.out.println("Group ID：" + data.getId() + ", Name：" + data.getName());
	}
}

