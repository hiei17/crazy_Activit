package org.crazyit.activiti;

import java.sql.Connection;
import java.sql.DriverManager;

import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;

/**
 * 执行数据库更新
 * 
 * @author yangenxiong
 * 
 */
public class SchemaUpgrade {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到管理服务组件
		ManagementService managementService = engine.getManagementService();
		// 创建数据库连接
		String url = "jdbc:mysql://localhost:3306/act";
		String userName = "root";
		String passwd = "123456";
		Connection conn = DriverManager.getConnection(url, userName, passwd);
		// 创建schema
		conn.createStatement().execute("create database 10_TEST");
		managementService.databaseSchemaUpgrade(conn, "", "");
		// 删除schema
		conn = DriverManager.getConnection(url, userName, passwd);
		conn.createStatement().execute("drop database 10_TEST");
		managementService.databaseSchemaUpgrade(conn, "", "");
		// 为10数据库创建TABLE_1表
		conn = DriverManager.getConnection(url, userName, passwd);
		conn.createStatement()
				.execute(
				"create TABLE TABLE_1(`ID` int(11) NOT NULL auto_increment, PRIMARY KEY  (`ID`))");
		managementService.databaseSchemaUpgrade(conn, "", "");
		// 删除10的TABLE_1表
		conn = DriverManager.getConnection(url, userName, passwd);
		conn.createStatement().execute("drop table TABLE_1");
		managementService.databaseSchemaUpgrade(conn, "", "");
	}

}
