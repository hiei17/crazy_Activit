package org.crazyit.activiti;

import java.io.Serializable;

import org.activiti.engine.runtime.Execution;

public class MyJavaBean implements Serializable {

	private String name = "crazyit";
	
	public String getName() {
		return this.name;
	}
	
	public void print(Execution exe) {
		System.out.println("使用Java Bean的print方法：" + exe.getId());
	}
}
