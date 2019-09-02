package org.crazyit.activiti;

import org.activiti.engine.ProcessEngineConfiguration;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 * 使用编码方式设置DBCP数据源
 * 
 * @author yangenxiong
 * 
 */
public class DBCPCoding {

	public static void main(String[] args) throws Exception {
		// 创建DBCP数据源
		BasicDataSource ds = new BasicDataSource();
		// 设置JDBC连接的各个属性
		ds.setUsername("root");
		ds.setPassword("123456");
		ds.setUrl("jdbc:mysql://localhost:3306/act");
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		// 验证是否连接成功
		ds.getConnection().getMetaData();
		// 读取Activiti配置文件
		ProcessEngineConfiguration config = ProcessEngineConfiguration
				.createProcessEngineConfigurationFromResource("dbcp-coding.xml");
		// 为ProcessEngineConfiguration设置dataSource属性
		config.setDataSource(ds);
		System.out.println(config.getDataSource());
	}

}
