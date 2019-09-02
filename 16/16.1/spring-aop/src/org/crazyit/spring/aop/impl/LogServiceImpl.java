package org.crazyit.spring.aop.impl;

import org.crazyit.spring.aop.LogService;

public class LogServiceImpl implements LogService {

	public void doLog() {
		System.out.println("进行日志记录");
	}
}
