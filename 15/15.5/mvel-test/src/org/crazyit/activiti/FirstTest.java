package org.crazyit.activiti;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.mvel2.MVEL;

public class FirstTest {

	public static void main(String[] args) {
		// 进行编译
		Serializable compiledExpression = MVEL
				.compileExpression("personName == 'Angus'");
		// 设置执行参数
		Map<String, String> params = new HashMap<String, String>();
		params.put("personName", "Angus");
		// 执行表达式并返回结果
		Boolean result = MVEL.executeExpression(compiledExpression, params,
				Boolean.class);
		// 控制台输出结果
		System.out.println("表达式第一次执行结果：" + result);
		// 传入其他 参数，结果将为false
		params.put("personName", "Paris");
		// 再次执行表达式
		result = MVEL.executeExpression(compiledExpression, params,
				Boolean.class);
		// 输出结果
		System.out.println("表达式第二次执行结果：" + result);
	}

}
