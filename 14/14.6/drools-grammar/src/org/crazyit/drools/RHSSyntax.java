package org.crazyit.drools;

import java.util.Collection;

import org.kie.api.io.ResourceType;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.definition.KnowledgePackage;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.StatefulKnowledgeSession;

public class RHSSyntax {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 创建一个KnowledgeBuilder
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory
				.newKnowledgeBuilder();
		// 添加规则资源到 KnowledgeBuilder
		kbuilder.add(ResourceFactory.newClassPathResource("rule/RHSSyntax.drl",
				RHSSyntax.class), ResourceType.DRL);
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
		// 测试insert事实
		RHSPerson p1 = new RHSPerson("person 1", 11);	
		// 测试update事实
		RHSPerson p2 = new RHSPerson("person 2", 20);
		// 插入到Working Memory
		ksession.insert(p1);
		ksession.insert(p2);
		// 匹配规则
		ksession.fireAllRules();
		// 关闭当前session的资源
		ksession.dispose();
	}

}
