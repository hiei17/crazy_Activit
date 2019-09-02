package org.crazyit.activiti.behavior;

import org.crazyit.activiti.MyExecution;
import org.crazyit.activiti.xml.FlowNode;
import org.crazyit.activiti.xml.SequenceFlow;

public class StartBehavior implements BehaviorInterface {

	public void execute(MyExecution exe) {
		System.out.println("执行开始节点");
		// 获取当前节点
		FlowNode currentNode = exe.getCurrentNode();
		// 获取顺序流
		SequenceFlow outgoFlow = currentNode.getOutgoFlow();
		// 设置下一节点
		FlowNode nextNode = exe.getProcess().getNode(outgoFlow.getTarget());
		exe.setCurrentNode(nextNode);
	}
}
