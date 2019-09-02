package org.crazyit.activiti;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

/**
 * 接收取消信息后触发的任务对应的Delegate
 * @author yangenxiong
 *
 */
public class ReceiveCancelDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) {
		System.out.println("处理子流程取消后的业务");
	}

}
