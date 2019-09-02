package org.crazyit.activiti;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class CompensationA implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) {
		System.out.println("A补偿类处理任务...");
	}

}
