package org.crazyit.activiti;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

/**
 * 处理回滚汇款的JavaDelegate
 * @author yangenxiong
 *
 */
public class RollbackRemitDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) {
		System.out.println("处理回滚汇款业务");
	}

}
