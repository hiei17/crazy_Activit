package org.crazyit.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIoC {

	public static void main(String[] args) {
		// 创建Spring上下文
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] { "ioc/TestIoc.xml" });
		// 获取bean
		ObjectA objA = (ObjectA) ctx.getBean("objectA");
		ObjectB objB = (ObjectB) ctx.getBean("objectB");
		// 输出实例
		System.out.println(objA);
		System.out.println(objB);
		System.out.println(objB.getObjectA());
	}

}
