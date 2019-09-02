package org.crazyit.activiti;

/**
 * 请求处理者接口
 * @author yangenxiong
 *
 */
public abstract class Handler {

	//下一任处理者
	protected  Handler next;

	public void setNext(Handler next) {
		this.next = next;
	}
	
	//处理请求的方法，交由子类实现
	public abstract void execute(Request request);
}
