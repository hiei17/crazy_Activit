package org.crazyit.activiti;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class HandlerA implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) {
		System.out.println("A处理类处理任务... ");
	}

}
