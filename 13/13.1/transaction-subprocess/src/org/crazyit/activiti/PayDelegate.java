package org.crazyit.activiti;

import org.activiti.engine.delegate.BpmnError;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class PayDelegate implements JavaDelegate {

	public void execute(DelegateExecution execution) {
		System.out.println("支付失败，抛出错误");
		throw new BpmnError("payError");
	}
}
