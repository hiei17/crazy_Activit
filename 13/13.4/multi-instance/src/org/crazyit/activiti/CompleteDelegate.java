package org.crazyit.activiti;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class CompleteDelegate implements JavaDelegate {

	public void execute(DelegateExecution execution) {
		System.out.println(execution.getVariable("loopCounter")
				+ "执行JavaDelegate类, 数据项为：" + execution.getVariable("data"));
	}
}
