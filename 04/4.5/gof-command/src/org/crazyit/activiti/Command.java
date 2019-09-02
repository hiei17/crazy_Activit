package org.crazyit.activiti;

/**
 *  命令接口
 * @author yangenxiong
 *
 */
public interface Command {

	/**
	 * 执行命令，参数为命令接收人
	 * @param receiver
	 */
	void execute(CommandReceiver receiver);
}
