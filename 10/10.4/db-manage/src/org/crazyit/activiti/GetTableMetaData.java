package org.crazyit.activiti;

import java.util.List;
import java.util.Map;

import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.management.TableMetaData;

/**
 * 查询表信息
 * @author yangenxiong
 *
 */
public class GetTableMetaData {

	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到管理服务组件
		ManagementService managementService = engine.getManagementService();
		// 查询表信息
		TableMetaData data = managementService.getTableMetaData("ACT_GE_PROPERTY");
		System.out.println("输出 ACT_GE_PROPERTY 的列：");
		List<String> columns = data.getColumnNames();
		for (String column : columns) {
			System.out.println(column);
		}
		System.out.println("输出 ACT_GE_PROPERTY 的列类型：");
		List<String> types = data.getColumnTypes();
		for (String type : types) {
			System.out.println(type);
		}
		// 查询数据量
		Map<String, Long> count = managementService.getTableCount();
		System.out.println("ACT_GE_PROPERTY 表数据量：" + count.get("ACT_GE_PROPERTY"));
	}

}
