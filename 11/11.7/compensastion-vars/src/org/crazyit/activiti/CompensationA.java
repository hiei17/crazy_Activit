package org.crazyit.activiti;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
public class CompensationA implements JavaDelegate {
	public void execute(DelegateExecution execution) {
		System.out.println("补偿A获取参数 " + execution.getVariable("user1"));
		System.out.println("补偿A处理...");
	}
}
