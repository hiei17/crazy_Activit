package org.crazyit.activiti;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;

/**
 * 开始流程用户组权限
 * @author yangenxiong 
 *
 */
public class GroupCandidate {

	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到流程存储服务实例
		RepositoryService repositoryService = engine.getRepositoryService();
		// 得到身份服务组件
		IdentityService identityService = engine.getIdentityService();
		//部署流程描述文件
		Deployment dep = repositoryService.createDeployment()
				.addClasspathResource("bpmn/candidateGroup.bpmn").deploy();
		//查询流程定义实体
		ProcessDefinition def = repositoryService.createProcessDefinitionQuery()
				.deploymentId(dep.getId()).singleResult();
		// 写入用户组数据
		createGroup(identityService, "group1", "Group A", "type A");
		createGroup(identityService, "group2", "Group B", "type B");
		// 设置流程开始用户组权限
		repositoryService.addCandidateStarterGroup(def.getId(), "group1");
		
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
