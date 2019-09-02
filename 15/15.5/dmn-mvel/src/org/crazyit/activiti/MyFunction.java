package org.crazyit.activiti;

import java.util.HashMap;
import java.util.Map;

import org.activiti.dmn.api.DmnDecisionTable;
import org.activiti.dmn.api.DmnDeployment;
import org.activiti.dmn.api.DmnRepositoryService;
import org.activiti.dmn.api.DmnRuleService;
import org.activiti.dmn.api.RuleEngineExecutionResult;
import org.activiti.dmn.engine.DmnEngine;
import org.activiti.dmn.engine.DmnEngineConfiguration;

public class MyFunction {

	public static void main(String[] args) {
		// 根据默认配置创建引擎的配置实例
		DmnEngineConfiguration config = DmnEngineConfiguration
				.createDmnEngineConfigurationFromResourceDefault();
		// 创建规则引擎
		DmnEngine engine = config.buildDmnEngine();
		// 获取规则的存储服务组件
		DmnRepositoryService rService = engine.getDmnRepositoryService();
		// 获取规则服务组件
		DmnRuleService ruleService = engine.getDmnRuleService();
		// 进行规则 部署
		DmnDeployment dep = rService.createDeployment()
				.addClasspathResource("dmn/MyFunction.dmn").deploy();
		// 根据部署对象查询决策表
		DmnDecisionTable dt = rService.createDecisionTableQuery()
				.deploymentId(dep.getId()).singleResult();
		// 设置参数
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("personName", "Angus");
		vars.put("age", 33);
		// 运行决策表
		RuleEngineExecutionResult result = ruleService.executeDecisionByKey(dt.getKey(), vars);
		System.out.println(result.getResultVariables().get("outputResult"));
	}
}
