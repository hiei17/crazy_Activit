package org.crazyit.activiti;

/**
 * 命令执行者
 * @author yangenxiong
 *
 */
public class CommandExecutor {

	public void execute(Command command) {
		//创建命令接者可以使用其他设计模式
		command.execute(new CommandReceiverImpl());
	}
}
