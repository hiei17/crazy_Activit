package org.crazyit.activiti;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 * 任务监听器
 * @author yangenxiong
 *
 */
public class UserTaskListener implements TaskListener {

	public void notify(DelegateTask delegateTask) {
		System.out.println("使用任务监听器设置任务权限");
		delegateTask.setAssignee("user1");
		delegateTask.addCandidateGroup("group1");
		delegateTask.addCandidateUser("user1");		
	}
}
