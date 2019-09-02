package org.crazyit.activiti;

import java.io.Serializable;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

public class DelegateBean implements TaskListener, Serializable {
	public void notify(DelegateTask delegateTask) {
		System.out.println("使用DelegateBean");
	}
}
