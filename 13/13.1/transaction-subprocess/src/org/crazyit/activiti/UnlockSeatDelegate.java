package org.crazyit.activiti;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class UnlockSeatDelegate implements JavaDelegate {

	public void execute(DelegateExecution execution) {
		System.out.println("取消锁定座位");
	}
}
