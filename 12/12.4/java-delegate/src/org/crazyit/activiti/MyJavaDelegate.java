package org.crazyit.activiti;

import java.io.Serializable;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class MyJavaDelegate implements JavaDelegate, Serializable {

	public void execute(DelegateExecution execution) {
		System.out.println(" 实现  JavaDelegate 的  JavaSeviceTask: " + this);
	}
}
