package org.crazyit.activiti;

import org.crazyit.activiti.impl.CommandA;
import org.crazyit.activiti.impl.CommandB;

public class Client {

	public static void main(String[] args) {		
		//创建命令执行者
		CommandExecutor executor = new CommandExecutor();		
		//创建命令A，交由命令执行者执行
		Command commandA = new CommandA();
		executor.execute(commandA);		
		//创建命令B，交由命令执行者执行
		Command commandB = new CommandB();
		executor.execute(commandB);
	}
}
