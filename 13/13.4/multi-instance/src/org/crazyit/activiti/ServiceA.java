package org.crazyit.activiti;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class ServiceA implements JavaDelegate {

	public void execute(DelegateExecution execution) {
		System.out.println("第一个任务，当前执行流id：" + execution.getId() + "， 父执行流id: "
				+ execution.getParentId());
		System.out.println("获取循环参数：" + execution.getVariable("data"));
	}
}
