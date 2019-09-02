package org.crazyit.activiti.service;

import org.crazyit.activiti.MyExecution;
import org.crazyit.activiti.xml.End;
import org.crazyit.activiti.xml.FlowNode;
import org.crazyit.activiti.xml.MyProcess;
import org.crazyit.activiti.xml.SequenceFlow;
import org.crazyit.activiti.xml.Start;

public class MyRuntimeService {
	
	/**
	 * 启动流程的方法
	 */
	public MyExecution startProcess(MyProcess process) {
		// 创建执行流
		MyExecution exe = new MyExecution();
		exe.setProcess(process);
		Start startNode = process.getStart();
		// 设置流程当前节点
		exe.setCurrentNode(startNode);
		// 让流程往前进行
		startNode.getBehavior().execute(exe);		
		return exe;
	}
	
	/**
	 * 完成任务
	 */
	public void completeTask(MyExecution exe) {
		// 获取当前的流程节点
		FlowNode current = exe.getCurrentNode();
		// 执行节点的行为
		current.getBehavior().execute(exe);		
	}
}
