package org.crazyit.activiti;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class CompensationB implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			
		}		
		System.out.println("B补偿类处理任务... ");
	}

}
