package org.crazyit.activiti;

import java.io.File;
import java.net.URI;

import org.crazyit.activiti.service.MyRuntimeService;
import org.crazyit.activiti.xml.MyProcess;
import org.crazyit.activiti.xml.XStreamUtil;


public class TestMain {

	public static void main(String[] args) throws Exception {
		String path = TestMain.class.getResource("/").toString();
		File xmlFile = new File(new URI(path + "/myBpmn.xml"));
		// 解析流程文件
		MyProcess process = XStreamUtil.toObject(xmlFile);
		// 启动流程
		MyRuntimeService runtimeService = new MyRuntimeService();
		MyExecution exe = runtimeService.startProcess(process);
		// 查询流程当前节点
		System.out.println("当前流程节点：" + exe.getCurrentNode().getId());
		// 完成任务
		runtimeService.completeTask(exe);
		System.out.println("当前流程节点：" + exe.getCurrentNode().getId());
	}

}
