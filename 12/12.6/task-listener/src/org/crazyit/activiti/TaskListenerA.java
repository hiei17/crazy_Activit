package org.crazyit.activiti;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

public class TaskListenerA implements TaskListener {

	public void notify(DelegateTask delegateTask) {
		System.out.println("任务监听器A");
	}

}
