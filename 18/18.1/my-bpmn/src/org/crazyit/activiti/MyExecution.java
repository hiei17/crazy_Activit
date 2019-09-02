package org.crazyit.activiti;

import org.crazyit.activiti.xml.FlowNode;
import org.crazyit.activiti.xml.MyProcess;

public class MyExecution {

	// 执行流的当前节点
	private FlowNode currentNode;
	
	private MyProcess process;

	public FlowNode getCurrentNode() {
		return currentNode;
	}

	public void setCurrentNode(FlowNode currentNode) {
		this.currentNode = currentNode;
	}

	public MyProcess getProcess() {
		return process;
	}

	public void setProcess(MyProcess process) {
		this.process = process;
	}

}
