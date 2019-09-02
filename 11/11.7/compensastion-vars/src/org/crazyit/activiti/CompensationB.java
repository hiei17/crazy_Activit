package org.crazyit.activiti;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class CompensationB implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) {
		System.out.println("补偿B获取参数：" + execution.getVariable("user1"));
		System.out.println("补偿B处理...");
	}

}
