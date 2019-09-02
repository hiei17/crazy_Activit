package org.crazyit.activiti;

import java.io.Serializable;

import org.activiti.engine.delegate.DelegateTask;

public class ExpressionBean implements Serializable {

	public void testBean(DelegateTask task) {
		System.out.println("执行ExpressionBean的 testBean方法: " + task.getId());
	}
}
