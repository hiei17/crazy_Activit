package org.crazyit.activiti.impl;


import org.crazyit.activiti.Handler;
import org.crazyit.activiti.Request;

/**
 * 最终请求执行者，需要将其设置到责任链的最后一环
 */
public class ActualHandler extends Handler {

	public void execute(Request request) {
		//直接执行请求
		request.doSomething();
	}
}
