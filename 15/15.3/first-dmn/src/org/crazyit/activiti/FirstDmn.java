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

public class FirstDmn {

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
				.addClasspathResource("dmn/first.dmn").deploy();
		// 进行数据查询
		DmnDecisionTable dt = rService.createDecisionTableQuery()
				.deploymentId(dep.getId()).singleResult();
		// 初始化参数
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("personAge", 19);
		// 传入参数执行决策，并返回结果
		RuleEngineExecutionResult result = ruleService.executeDecisionByKey(
				dt.getKey(), params);
		// 控制台输出结果
		System.out.println(result.getResultVariables().get("myResult"));
		// 重新设置参数
		params.put("personAge", 5);
		// 重新执行决策
		result = ruleService.executeDecisionByKey(dt.getKey(), params);
		// 控制台重新输出结果
		System.out.println(result.getResultVariables().get("myResult"));
	}
}
