package org.crazyit.activiti;

import org.activiti.engine.ProcessEngineConfiguration;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 使用编码方式设置DBCP数据源
 * 
 * @author yangenxiong
 * 
 */
public class C3P0Coding {

	public static void main(String[] args) throws Exception {
		// 创建C3P0数据源
		ComboPooledDataSource ds = new ComboPooledDataSource();
		// 设置JDBC连接的各个属性
		ds.setUser("root");
		ds.setPassword("123456");
		ds.setJdbcUrl("jdbc:mysql://localhost:3306/act");
		ds.setDriverClass("com.mysql.jdbc.Driver");
		// 验证是否连接成功
		ds.getConnection().getMetaData();

		// 读取Activiti配置文件
		ProcessEngineConfiguration config = ProcessEngineConfiguration
				.createProcessEngineConfigurationFromResource("config/c3p0-coding.xml");
		// 为ProcessEngineConfiguration设置dataSource属性
		config.setDataSource(ds);
		System.out.println(config.getDataSource());
	}

}
