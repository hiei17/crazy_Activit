package org.crazyit.activiti.spring.impl;

import org.crazyit.activiti.spring.MyService;

public class MyServiceImpl implements MyService {

	public void serviceMethod(String name) {
		System.out.println("MyService的实现类处理业务方法：" + name);
	}

}
