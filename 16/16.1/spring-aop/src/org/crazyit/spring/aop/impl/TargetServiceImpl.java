package org.crazyit.spring.aop.impl;

import org.crazyit.spring.aop.TargetService;

public class TargetServiceImpl implements TargetService {

	public void serviceMethod(String name) {
		System.out.println("处理实际业务，参数：" + name);
	}
}
