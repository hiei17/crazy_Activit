package org.crazyit.activiti;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class LockSeatDelegate implements JavaDelegate {

	public void execute(DelegateExecution execution) {
		System.out.println("执行锁定座位");
	}
}
