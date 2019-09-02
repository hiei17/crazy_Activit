package org.crazyit.activiti;

import java.io.Serializable;

import org.activiti.engine.runtime.Execution;

public class MyBean implements Serializable {

	public void print(Execution exe) {
		System.out.println("执行Java Bean的方法，流程ID为：" + exe.getId());
	}
}
