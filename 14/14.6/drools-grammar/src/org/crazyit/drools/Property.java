package org.crazyit.drools;

import java.util.Collection;

import org.kie.api.io.ResourceType;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.definition.KnowledgePackage;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.StatefulKnowledgeSession;

public class Property {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// 创建一个KnowledgeBuilder
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory
				.newKnowledgeBuilder();
		// 添加规则资源到 KnowledgeBuilder
		kbuilder.add(ResourceFactory.newClassPathResource("rule/Property.drl",
				Property.class), ResourceType.DRL);
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
		// 测试no-loop
		PropertyPerson p1 = new PropertyPerson("person 1", 17);
		// 测试lock-on-active和agenda-group
		PropertyPerson p2 = new PropertyPerson("person 2", 30);
		// 测试activation-group
		PropertyPerson p3 = new PropertyPerson("person 3", 40);
		// 测试salience
		PropertyPerson p4 = new PropertyPerson("person 5", 50);
		// 插入到Working Memory
		ksession.insert(p1);
		ksession.insert(p2);
		ksession.insert(p3);
		ksession.insert(p4);
		// 匹配规则
		ksession.fireAllRules();
		// 关闭当前session的资源
		ksession.dispose();	
	}

}
