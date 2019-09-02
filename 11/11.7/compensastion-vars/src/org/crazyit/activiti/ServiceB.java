package org.crazyit.activiti;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class ServiceB implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) {
		execution.setVariableLocal("user1", "angus");
		System.out.println("处理类B执行...");
	}

}
