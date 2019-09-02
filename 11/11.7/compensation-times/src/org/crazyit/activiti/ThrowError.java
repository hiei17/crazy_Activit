package org.crazyit.activiti;

import org.activiti.engine.delegate.BpmnError;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class ThrowError implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) {
		System.out.println("抛出错误，触发补偿");
		throw new BpmnError("myError");
	}

}
