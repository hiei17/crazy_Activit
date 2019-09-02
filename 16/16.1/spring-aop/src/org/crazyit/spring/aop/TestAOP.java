package org.crazyit.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAOP {

	public static void main(String[] args) {
		// 创建Spring上下文
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] { "aop/TestAOP.xml" });
		
		TargetService ts = (TargetService)ctx.getBean("targetService");
		// 调用业务方法
		ts.serviceMethod("crazyit");
		// 输出TargetService的类名
		System.out.println(ts.getClass().getName());
		// 输出LogService的类名
		LogService ls = (LogService)ctx.getBean("logService");
		System.out.println(ls.getClass().getName());
	}

}
