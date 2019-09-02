package org.crazyit.activiti.sale;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.activiti.dmn.api.DmnDecisionTable;
import org.activiti.dmn.api.DmnDeployment;
import org.activiti.dmn.api.DmnRepositoryService;
import org.activiti.dmn.api.DmnRuleService;
import org.activiti.dmn.api.RuleEngineExecutionResult;
import org.activiti.dmn.engine.DmnEngine;
import org.activiti.dmn.engine.DmnEngineConfiguration;

public class SaleTest {

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
				.addClasspathResource("dmn/SaleTest.dmn").deploy();
		// 根据部署对象查询决策表
		DmnDecisionTable dt = rService.createDecisionTableQuery()
				.deploymentId(dep.getId()).singleResult();
		// 设置参数
		Map<String, Object> vars = new HashMap<String, Object>();
		/*
		 * 符合周五打9折的规则
		 */
		Sale sale = new Sale();
		sale.setMoney(new BigDecimal(100));
		sale.setSaleDate("2017-07-07");
		vars.put("sale", sale);
		// 运行决策表
		RuleEngineExecutionResult result = ruleService.executeDecisionByKey(
				dt.getKey(), vars);
		// 获取打折后金额
		Double resultMoney = (Double) result.getResultVariables().get(
				"resultMoney");
		System.out.println("将触发周五打9折的规则，折后价：" + resultMoney);
		/*
		 * 符合周六打8折的规则
		 */
		sale = new Sale();
		sale.setMoney(new BigDecimal(100));
		sale.setSaleDate("2017-07-08");
		vars.put("sale", sale);
		// 运行决策表
		result = ruleService.executeDecisionByKey(dt.getKey(), vars);
		// 获取打折后金额
		resultMoney = (Double) result.getResultVariables().get("resultMoney");
		System.out.println("将触发周六打8折的规则，折后价：" + resultMoney);
		/*
		 * 符合周日打7折的规则
		 */
		sale = new Sale();
		sale.setMoney(new BigDecimal(100));
		sale.setSaleDate("2017-07-09");
		vars.put("sale", sale);
		// 运行决策表
		result = ruleService.executeDecisionByKey(dt.getKey(), vars);
		// 获取打折后金额
		resultMoney = (Double) result.getResultVariables().get("resultMoney");
		System.out.println("将触发周日打7折的规则，折后价：" + resultMoney);
	}
}
