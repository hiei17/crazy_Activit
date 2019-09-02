package org.crazyit.drools;

import java.util.Collection;

import org.kie.api.io.ResourceType;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.definition.KnowledgePackage;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.StatefulKnowledgeSession;

public class LHSSyntax {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 创建一个KnowledgeBuilder
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory
				.newKnowledgeBuilder();
		// 添加规则资源到 KnowledgeBuilder
		kbuilder.add(ResourceFactory.newClassPathResource("rule/LHSSyntax.drl",
				LHSSyntax.class), ResourceType.DRL);
		if (kbuilder.hasErrors()) {
			System.out.println(kbuilder.getErrors().toString());
			System.exit(0);
		}
		// 获取知识包集合
		Collection<KnowledgePackage> pkgs = kbuilder
				.getKnowledgePackages();
		// 创建KnowledgeBase实例
		KnowledgeBase kbase = kbuilder.newKnowledgeBase();
		// 将知识包部署到KnowledgeBase中
		kbase.addKnowledgePackages(pkgs);
		// 使用KnowledgeBase创建StatefulKnowledgeSession
		StatefulKnowledgeSession ksession = kbase
				.newStatefulKnowledgeSession();
		// 条件中调用事实方法
		SyntaxPerson1 p2 = new SyntaxPerson1("person 2", 30, "b");
		// Java表达式
		SyntaxPerson1 p3 = new SyntaxPerson1("person 3", 40, "c");
		// 使用逗号隔开多个与条件
		SyntaxPerson1 p4 = new SyntaxPerson1("person 4", 50, "d");
		// 测试多实例条件
		SyntaxPerson1 p5 = new SyntaxPerson1("person 5", 11, "e");
		SyntaxPerson2 p6 = new SyntaxPerson2("person 6", 11);
		SyntaxPerson2 p7 = new SyntaxPerson2("person 7", 11);
		// 测试属性命名
		SyntaxPerson1 p8 = new SyntaxPerson1("person 8", 20, "f");
		// 字符串包含
		SyntaxPerson1 p9 = new SyntaxPerson1("person 9", 60, "g");
		// 判定集合元素值
		SyntaxPerson1 p10 = new SyntaxPerson1("person 10", 25, "Paris");		
		// 插入到Working Memory
		ksession.insert(p2);
		ksession.insert(p3);
		ksession.insert(p4);
		ksession.insert(p5);
		ksession.insert(p6);
		ksession.insert(p7);
		ksession.insert(p8);
		ksession.insert(p9);
		ksession.insert(p10);
		// 匹配规则
		ksession.fireAllRules();
		// 关闭当前session的资源
		ksession.dispose();
	}

}
