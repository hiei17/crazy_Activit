package org.crazyit.activiti;

import org.activiti.engine.delegate.BpmnError;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class ErrorJavaDelegate implements JavaDelegate {

	public void execute(DelegateExecution execution) {
		System.out.println("执行JavaDelegate类，抛出错误");
		throw new BpmnError("error");
	}
}
