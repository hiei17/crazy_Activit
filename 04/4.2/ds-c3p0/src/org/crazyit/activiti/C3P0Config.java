package org.crazyit.activiti;

import javax.sql.DataSource;

import org.activiti.engine.ProcessEngineConfiguration;

/**
 * 使用配置方法设置DBCP数据源
 * 
 * @author yangenxiong
 * 
 */
public class C3P0Config {

	public static void main(String[] args) throws Exception {
		// 读取c3p0-config.xml配置
		ProcessEngineConfiguration config = ProcessEngineConfiguration
				.createProcessEngineConfigurationFromResource("config/c3p0-config.xml");
		// 能正常输出，即完成配置
		DataSource ds = config.getDataSource();
		// 查询数据库元信息，如果能查询则表示连接成功
		ds.getConnection().getMetaData();
		// 结果为 com.mchange.v2.c3p0.ComboPooledDataSource
		System.out.println(config.getDataSource().getClass().getName());
	}

}
