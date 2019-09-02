package org.crazyit.activiti;

import javax.sql.DataSource;

import org.activiti.engine.ProcessEngineConfiguration;

/**
 * 使用配置方法设置DBCP数据源
 * 
 * @author yangenxiong
 * 
 */
public class DBCPConfig {

	public static void main(String[] args) throws Exception {
		// 读取 dbcp-config.xml配置
		ProcessEngineConfiguration config = ProcessEngineConfiguration
				.createProcessEngineConfigurationFromResource("dbcp-config.xml");
		// 能正常输出，即完成配置
		DataSource ds = config.getDataSource();
		// 查询数据库元信息，如果能查询则表示连接成功
		ds.getConnection().getMetaData();
		// 结果为 org.apache.commons.dbcp.BasicDataSource
		System.out.println(ds.getClass().getName());
	}

}
