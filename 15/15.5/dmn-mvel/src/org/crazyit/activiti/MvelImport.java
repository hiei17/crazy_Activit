package org.crazyit.activiti;

import java.io.Serializable;
import java.lang.reflect.Method;

import org.mvel2.MVEL;
import org.mvel2.ParserContext;

public class MvelImport {

	public static void main(String[] args) {
		// 获取本类中的testMethod方法的实例
		Method m = getMethod(MvelImport.class, "testMethod", String.class, Integer.class);
		// 创建解析上下文对象
		ParserContext parserContext = new ParserContext();
		// 添加方法导入
		parserContext.addImport("fn_testMethod", m);
		// 表达式语句，调用注册的方法并传入参数	
		String mvel = "fn_testMethod('Angus', 33)";
		// 编译语句时传下解析上下文对象
		Serializable compiledExpression = MVEL.compileExpression(mvel, parserContext);
		// 获取结果
		String result = MVEL.executeExpression(compiledExpression, null, String.class);
		System.out.println("执行结果：" + result);
	}
	
	/**
	 * 被调用的工具方法
	 */
	public static String testMethod(String name, Integer age) {
		return "名称：" + name + ", 年龄：" + age;
	}
	
	/**
	 * 根据类和方法等信息，返回方法实例
	 */
	public static Method getMethod(Class classRef, String methodName,
			Class... methodParm) {
		try {
			return classRef.getMethod(methodName, methodParm);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return null;
	}

}
