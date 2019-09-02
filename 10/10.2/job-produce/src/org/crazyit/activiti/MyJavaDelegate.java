package org.crazyit.activiti;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class MyJavaDelegate implements JavaDelegate {

	public void execute(DelegateExecution execution) {
		System.out.println("This is java delegate");
	}

}
