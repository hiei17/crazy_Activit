package org.crazyit.activiti;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

public class PropertyConfigListener implements TaskListener {

	public void notify(DelegateTask delegateTask) {
		System.out.println("执行任务监听器");
	}
}
