package org.crazyit.activiti;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;

/**
 * 使用createProcessEngineConfigurationFromInputStream方法创建ProcessEngineConfiguration
 * 
 * @author yangenxiong
 * 
 */
public class CreateInputStream {

	public static void main(String[] args) throws Exception {
		File file = new File("resource/input-stream.xml");
		// 得到文件输入流
		InputStream fis = new FileInputStream(file);
		// 使用createProcessEngineConfigurationFromInputStream方法创建ProcessEngineConfiguration
		ProcessEngineConfiguration config = ProcessEngineConfiguration
				.createProcessEngineConfigurationFromInputStream(fis);
	}

}
