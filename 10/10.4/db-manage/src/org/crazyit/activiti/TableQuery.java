package org.crazyit.activiti;

import java.util.List;
import java.util.Map;

import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.management.TablePage;

/**
 * 数据表查询
 * 
 * @author yangenxiong
 * 
 */
public class TableQuery {

	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到管理服务组件
		ManagementService managementService = engine.getManagementService();
		// 查询ACT_GE_PROPERTY表的数据
		TablePage page = managementService.createTablePageQuery()
				.tableName("ACT_GE_PROPERTY").listPage(0, 2);
		List<Map<String, Object>> datas = page.getRows();
		for (Map<String, Object> data : datas) {
			System.out.println("============");
			for (String key : data.keySet()) {
				System.out.println(key + "---" + data.get(key));
			}
		}
	}

}
