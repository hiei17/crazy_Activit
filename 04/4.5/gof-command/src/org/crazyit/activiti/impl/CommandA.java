package org.crazyit.activiti.impl;

import org.crazyit.activiti.Command;
import org.crazyit.activiti.CommandReceiver;

/**
 * 命令实现A
 * @author yangenxiong
 *
 */
public class CommandA implements Command {
	public void execute(CommandReceiver receiver) {
		receiver.doSomethingA();
	}
}
