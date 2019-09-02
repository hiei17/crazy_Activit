package org.crazyit.activiti;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.delegate.JavaDelegate;

public class StringInjectionDelegate implements JavaDelegate {

	// 用户名属性
	private Expression userName;

	// 密码属性
	private Expression passwd;

	public void setUserName(Expression userName) {
		this.userName = userName;
	}

	public void setPasswd(Expression passwd) {
		this.passwd = passwd;
	}

	public void execute(DelegateExecution execution) {
		// 输出属性
		System.out.println("在JavaDelegate中注入字符串，userName值："
				+ userName.getValue(null) + ", passwd值："
				+ passwd.getValue(null));
	}

}
