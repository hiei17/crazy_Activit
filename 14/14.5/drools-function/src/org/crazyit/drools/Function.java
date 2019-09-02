package org.crazyit.drools;

import java.util.Collection;
import java.util.Date;

import org.kie.api.io.ResourceType;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.definition.KnowledgePackage;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.StatefulKnowledgeSession;

public class Function {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 创建一个KnowledgeBuilder
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory
				.newKnowledgeBuilder();
		// 添加规则资源到 KnowledgeBuilder
		kbuilder.add(ResourceFactory.newClassPathResource("rule/Function.drl",
				Function.class), ResourceType.DRL);
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
		// 定义一个事实对象
		Sale sale1 = new Sale(new Date(), 10, 10, "001");
		Sale sale2 = new Sale(new Date(), 10, 20, "002");
		// 插入到Working Memory
		ksession.insert(sale1);
		ksession.insert(sale2);
		// 匹配规则
		ksession.fireAllRules();
		// 关闭当前session的资源
		ksession.dispose();
	}

}
