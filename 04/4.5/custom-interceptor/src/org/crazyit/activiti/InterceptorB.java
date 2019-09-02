package org.crazyit.activiti;

import org.activiti.engine.impl.interceptor.Command;
import org.activiti.engine.impl.interceptor.CommandConfig;
import org.activiti.engine.impl.interceptor.CommandInterceptor;

public class InterceptorB implements CommandInterceptor {
	
	private CommandInterceptor next;

	@Override
	public <T> T execute(CommandConfig config, Command<T> command) {
		// 输出字符串和命令
		System.out.println("this is interceptor B "
				+ command.getClass().getName());
		// 然后让责任链中的下一请求处理者处理命令
		return next.execute(config, command);
	}

	@Override
	public CommandInterceptor getNext() {
		// TODO Auto-generated method stub
		return this.next;
	}

	@Override
	public void setNext(CommandInterceptor next) {
		this.next = next;
	}

}
