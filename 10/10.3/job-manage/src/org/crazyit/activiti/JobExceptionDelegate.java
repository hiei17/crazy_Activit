package org.crazyit.activiti;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class JobExceptionDelegate implements JavaDelegate {

	public void execute(DelegateExecution execution) {
		System.out.println("this is job exception delegate");
		throw new RuntimeException("JobExceptionDelegate message");
	}
}
