package org.crazyit.drools;

import java.math.BigDecimal;
import java.util.Collection;

import org.kie.api.definition.type.FactType;
import org.kie.api.io.ResourceType;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.definition.KnowledgePackage;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.StatefulKnowledgeSession;

public class TypeDeclare {

	public static void main(String[] args) throws Exception {
		// 创建一个KnowledgeBuilder
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory
				.newKnowledgeBuilder();
		// 添加规则资源到 KnowledgeBuilder
		kbuilder.add(ResourceFactory.newClassPathResource("rule/TypeDeclare.drl",
				TypeDeclare.class), ResourceType.DRL);
		// 获取编译错误
		if (kbuilder.hasErrors()) {
			System.out.println(kbuilder.getErrors().toString());
			System.exit(0);
		}
		// 获取知识包集合
		Collection<KnowledgePackage> pkgs = kbuilder.getKnowledgePackages();
		// 创建KnowledgeBase实例
		KnowledgeBase kbase = kbuilder.newKnowledgeBase();
		// 将知识包部署到KnowledgeBase中
		kbase.addKnowledgePackages(pkgs);
		// 使用KnowledgeBase创建StatefulKnowledgeSession
		StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
		// 使用包名和类名获取事实对象类型
		FactType fact = kbase.getFactType("org.crazyit.drools", "Person");
		System.out.println(fact);
		// 创建事实对象实例
		Object obj = fact.newInstance();
		// 设置名称
		fact.set(obj, "name", "crazyit");
		// 设置年龄
		fact.set(obj, "age", 20);
		// 设置体重
		fact.set(obj, "weight", new BigDecimal(70));
		ksession.insert(obj);		
		// 匹配规则
		ksession.fireAllRules();
		// 关闭当前session的资源
		ksession.dispose();
	}

}
