package org.crazyit.activiti.impl;

import org.crazyit.activiti.Command;
import org.crazyit.activiti.CommandReceiver;

/**
 * 命令实现B
 * @author yangenxiong
 *
 */
public class CommandB implements Command {

	@Override
	public void execute(CommandReceiver receiver) {
		receiver.doSomethingB();
	}

}
