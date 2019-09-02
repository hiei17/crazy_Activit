package org.crazyit.activiti;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * 运行javascript
 * @author yangenxiong
 *
 */
public class RunJavaScript {

	public static void main(String[] args) throws Exception {
		//创建脚本引擎管理对象
		ScriptEngineManager manager = new ScriptEngineManager();
		//获取javascript的脚本引擎
		ScriptEngine engine = manager.getEngineByName("javascript");
		//执行一段javascript
		engine.eval("for (var i = 0; i < 5; i++) { print(i); }");		
		System.out.println("==================== 分隔线");
		//获取groovy的脚本引擎
		ScriptEngine groovyEngine = manager.getEngineByName("groovy");
		//执行一段groovy程序
		groovyEngine.eval("for (i = 0; i < 5; i++) { println i;}");
	}

}
