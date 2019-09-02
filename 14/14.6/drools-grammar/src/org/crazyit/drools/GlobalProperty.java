package org.crazyit.drools;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.crazyit.drools.object.Person;
import org.kie.api.io.ResourceType;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.definition.KnowledgePackage;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.StatefulKnowledgeSession;

public class GlobalProperty {

	public static void main(String[] args) {
		// 创建一个KnowledgeBuilder
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory
				.newKnowledgeBuilder();
		// 添加规则资源到 KnowledgeBuilder
		kbuilder.add(ResourceFactory.newClassPathResource("rule/GlobalProperty.drl",
				GlobalProperty.class), ResourceType.DRL);
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
		// 初始化全局变量
		ksession.setGlobal("maxThan30", new ArrayList<Person>());
		// 定义一个事实对象
		Person p1 = new Person("person 1", 33, new BigDecimal(0));
		Person p2 = new Person("person 2", 32, new BigDecimal(0));
		Person p3 = new Person("person 3", 25, new BigDecimal(0));
		// 插入到Working Memory
		ksession.insert(p1);
		ksession.insert(p2);
		ksession.insert(p3);
		// 匹配规则
		ksession.fireAllRules();
		// 输出全局变量值
		List<Person> persons = (List<Person>)ksession.getGlobal("maxThan30");
		System.out.println("执行规则后的结果数量：" + persons.size());		
		// 关闭当前session的资源
		ksession.dispose();
	}
}
