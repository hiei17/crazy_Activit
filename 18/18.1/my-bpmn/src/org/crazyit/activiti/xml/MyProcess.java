package org.crazyit.activiti.xml;

import java.util.List;

import org.crazyit.activiti.behavior.StartBehavior;
import org.crazyit.activiti.behavior.TaskBehavior;

public class MyProcess extends BaseElement {
	
	// 开始节点
	private Start start;
	
	// 结束节点
	private End end;
	
	// 多个顺序流节点
	private List<SequenceFlow> flows;
	
	// 多个节点
	private List<FlowNode> nodes;
	
	/**
	 * 根据节点id查找node
	 */
	public FlowNode getNode(String nodeId) {
		if(start.getId().equals(nodeId)) {
			return start;
		}
		if(end.getId().equals(nodeId)) {
			return end;
		}
		for(FlowNode node: nodes) {
			if(nodeId.equals(node.getId())) {
				return node;
			}
		}
		return null;
	}
	
	/**
	 * 为各节点设置出入的顺序注
	 */
	public void initSequenceFlow() {
		// 开始事件的顺序流（设置出口）
		this.start.setOutgoFlow(getSequenceFlowBySource(this.start.getId()));
		// 结束事件顺序流（设置入口）
		this.end.setIncomeFlow(getSequenceFlowByTarget(this.end.getId()));
		// 设置其余节点的顺序流
		for(FlowNode node : nodes) {
			for(SequenceFlow flow : flows) {
				if(flow.getSource().equals(node.getId())) {
					node.setOutgoFlow(flow);
				}
				if(flow.getTarget().equals(node.getId())) {
					node.setIncomeFlow(flow);
				}
			}
		}
	}
	
	/**
	 * 初始化节点行为
	 */
	public void initBehavior() {
		// 开始与结束节点
		this.start.setBehavior(new StartBehavior());		
		for(FlowNode node : nodes) {
			if(node instanceof Task) {
				node.setBehavior(new TaskBehavior());
			}
		}
	}
	
	/**
	 * 根据源节点的id，返回对应的顺序流对象
	 */
	private SequenceFlow getSequenceFlowBySource(String sourceId) {
		for(SequenceFlow flow : flows) {
			if(flow.getSource().equals(sourceId)) {
				return flow;
			}
		}
		return null;
	}
	
	private SequenceFlow getSequenceFlowByTarget(String targetId) {
		for(SequenceFlow flow : flows) {
			if(flow.getTarget().equals(targetId)) {
				return flow;
			}
		}
		return null;
	}
	

	
	public List<SequenceFlow> getFlows() {
		return flows;
	}

	public void setFlows(List<SequenceFlow> flows) {
		this.flows = flows;
	}

	public List<FlowNode> getNodes() {
		return nodes;
	}

	public void setNodes(List<FlowNode> nodes) {
		this.nodes = nodes;
	}

	public Start getStart() {
		return start;
	}

	public void setStart(Start start) {
		this.start = start;
	}

	public End getEnd() {
		return end;
	}

	public void setEnd(End end) {
		this.end = end;
	}

}
