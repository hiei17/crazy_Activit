package org.crazyit.activiti;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import java.net.Socket;

/**
 * 检查服务器是否开启
 * @author yangenxiong
 *
 */
public class CheckServerDelegate implements JavaDelegate {

	public void execute(DelegateExecution arg0) {
		try {
			System.out.println("开始检查8080端口");
			// 连接本机的8080端口
			Socket socket = new Socket("127.0.0.1", 8080);
			System.out.println("检查8080端口完成");
		} catch (Exception e) {
			System.out.println("检查时出现异常，抛出错误");
			// 连接出现异常，则抛出BpmnError，且error code为“error”
			throw new org.activiti.engine.delegate.BpmnError("error");
		}
	}
}
