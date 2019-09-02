package org.crazyit.activiti.impl;

import org.crazyit.activiti.Handler;
import org.crazyit.activiti.Request;

/**
 * 请求处理者A实现
 * @author yangenxiong
 *
 */
public class HandlerA extends Handler {

	public void execute(Request request) {
		//处理自己的事，然后交由下一任处理者继续执行请求
		System.out.println("请求处理者A处理请求");
		next.execute(request);
	}
}
