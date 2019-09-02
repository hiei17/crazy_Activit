package org.crazyit.activiti;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class ServiceA implements JavaDelegate {

	public void execute(DelegateExecution execution) {
		execution.setVariableLocal("user1", "angus");
		System.out.println("处理类A执行...");
	}

}
