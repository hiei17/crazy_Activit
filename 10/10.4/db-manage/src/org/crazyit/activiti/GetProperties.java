package org.crazyit.activiti;

import java.util.Map;

import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;

public class GetProperties {

	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到管理服务组件
		ManagementService managementService = engine.getManagementService();
		Map<String, String> props = managementService.getProperties();
		//输出属性
		for (String key : props.keySet()) {
			System.out.println("属性：" + key + " 值为：" + props.get(key));
		}		
	}

}
