package org.crazyit.activiti;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.mvel2.MVEL;

public class ObjectTest {

	public static void main(String[] args) {
		// 进行编译
		Serializable compiledExpression = MVEL
				.compileExpression("person.name == 'Angus' && person.age == 30");
		// 设置执行参数
		Map<String, Object> params = new HashMap<String, Object>();
		// 设置名称与年龄均符合条件
		Person p = new Person();
		p.setName("Angus");
		p.setAge(30);
		params.put("person", p);
		// 执行表达式并返回结果，输出为true
		Boolean result = MVEL.executeExpression(compiledExpression, params,
				Boolean.class);
		System.out.println("第一次执行表达式结棍：" + result);
		// 修改参数年龄
		Person p2 = new Person();
		p2.setName("Angus");
		p2.setAge(20);
		params.put("person", p2);
		// 重新执行表达式，结果false
		result = MVEL.executeExpression(compiledExpression, params,
				Boolean.class);
		System.out.println("第二次执行表达式结果：" + result);
	}

}
