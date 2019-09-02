package org.crazyit.activiti;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.delegate.JavaDelegate;

public class ExpressionInjectionDelegate implements JavaDelegate {

	private Expression user;

	private Expression amountResult;

	public void setAmountResult(Expression amountResult) {
		this.amountResult = amountResult;
	}

	public void setUser(Expression user) {
		this.user = user;
	}

	@Override
	public void execute(DelegateExecution execution) {
		UserBean userBean = (UserBean) user.getValue(execution);
		System.out.println("在JavaDelegate中注入对象：" + userBean.getName() + "  "
				+ userBean.getPasswd());
		System.out.println("使用UserBean的方法计算后结果：："
				+ amountResult.getValue(execution));
	}

}
