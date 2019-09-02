package org.crazyit.activiti.behavior;

import org.crazyit.activiti.MyExecution;
import org.crazyit.activiti.xml.FlowNode;
import org.crazyit.activiti.xml.SequenceFlow;

public class TaskBehavior implements BehaviorInterface {

	public void execute(MyExecution exe) {
		System.out.println("执行任务节点");
		// 获取当前节点
		FlowNode currentNode = exe.getCurrentNode();
		// 获取顺序流
		SequenceFlow outgoFlow = currentNode.getOutgoFlow();
		// 获取下一个节点
		FlowNode targetNode = exe.getProcess().getNode(outgoFlow.getTarget());
		// 设置当前节点
		exe.setCurrentNode(targetNode);
	}
}
