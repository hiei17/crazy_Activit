package org.crazyit.activiti;

import java.util.List;

import org.activiti.dmn.api.DmnDeployment;
import org.activiti.dmn.api.DmnRepositoryService;
import org.activiti.dmn.api.DmnRuleService;
import org.activiti.dmn.engine.DmnEngine;
import org.activiti.dmn.engine.DmnEngineConfiguration;

public class DmnQuery {

	public static void main(String[] args) {
		// 根据默认配置创建引擎的配置实例
		DmnEngineConfiguration config = DmnEngineConfiguration
				.createDmnEngineConfigurationFromResourceDefault();
		// 创建规则引擎
		DmnEngine engine = config.buildDmnEngine();
		// 获取规则的存储服务组件
		DmnRepositoryService rService = engine.getDmnRepositoryService();
		// 根据key查询决策表数量
		long dtCount = rService.createDecisionTableQuery()
				.decisionTableKey("decision1").count();
		System.out.println("根据key查询决策表数量：" + dtCount);
		// 查询全部的部署数据
		List<DmnDeployment> deps = rService.createDeploymentQuery().list();
		System.out.println("查询全部的部署数据：" + deps.size());
		// 进行原生SQL查询
		deps = rService.createNativeDeploymentQuery()
				.sql("select * from ACT_DMN_DEPLOYMENT").list();
		System.out.println("使用原生SQL查询全部数据：" + deps.size());
	}
}
