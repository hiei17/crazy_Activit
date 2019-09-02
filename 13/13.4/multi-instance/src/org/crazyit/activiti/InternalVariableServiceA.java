package org.crazyit.activiti;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class InternalVariableServiceA implements JavaDelegate {

	public void execute(DelegateExecution execution) {
		System.out.println("按顺序执行的多实例活动，执行流id：" + execution.getId());
		System.out.println("实例总数： " + execution.getVariable("nrOfInstances")
				+ ", 当前执行的任务数: " + execution.getVariable("nrOfActiveInstances")
				+ ", 已完成的任务数: "
				+ execution.getVariable("nrOfCompletedInstances") + ", 当前索引: "
				+ execution.getVariable("loopCounter"));
	}
}
