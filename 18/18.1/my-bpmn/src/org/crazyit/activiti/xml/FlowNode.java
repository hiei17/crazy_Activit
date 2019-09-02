package org.crazyit.activiti.xml;

import org.crazyit.activiti.behavior.BehaviorInterface;

public class FlowNode extends FlowElement {

	// 流程出口
	private SequenceFlow outgoFlow;
	
	// 流程入口
	private SequenceFlow incomeFlow;
	
	// 流程节点的行为
	private BehaviorInterface behavior;

	public SequenceFlow getOutgoFlow() {
		return outgoFlow;
	}

	public void setOutgoFlow(SequenceFlow outgoFlow) {
		this.outgoFlow = outgoFlow;
	}

	public SequenceFlow getIncomeFlow() {
		return incomeFlow;
	}

	public void setIncomeFlow(SequenceFlow incomeFlow) {
		this.incomeFlow = incomeFlow;
	}

	public BehaviorInterface getBehavior() {
		return behavior;
	}

	public void setBehavior(BehaviorInterface behavior) {
		this.behavior = behavior;
	}

	
}
