package org.crazyit.activiti;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.activiti.dmn.engine.CustomExpressionFunctionRegistry;
import org.crazyit.activiti.sale.DateUtil;

public class MyFunctionRegistry implements CustomExpressionFunctionRegistry {

	// 用于存放方法的集合，key为自定义的方法名，value为方法实例
	protected static Map<String, Method> customFunctionConfigurations = new HashMap<String, Method>();

	static {
		// 将方法实例添加到集合中
		customFunctionConfigurations.put("fn_testMethod", getMethod(MyUtil.class, "testMethod", String.class,
				Integer.class));
		customFunctionConfigurations.put("fn_getDayOfWeek", getMethod(DateUtil.class, "getDayOfWeek", String.class));
		
	}

	@Override
	public Map<String, Method> getCustomExpressionMethods() {
		return customFunctionConfigurations;
	}

	/**
	 * 根据类和方法等信息，返回方法实例
	 */
	protected static Method getMethod(Class classRef, String methodName,
			Class... methodParm) {
		try {
			return classRef.getMethod(methodName, methodParm);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return null;
	}
}
