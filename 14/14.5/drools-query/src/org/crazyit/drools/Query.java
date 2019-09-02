package org.crazyit.drools;

import java.math.BigDecimal;
import java.util.Collection;

import org.crazyit.drools.object.Person;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.definition.KnowledgePackage;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.StatefulKnowledgeSession;

public class Query {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 创建一个KnowledgeBuilder
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory
				.newKnowledgeBuilder();
		// 添加规则资源到 KnowledgeBuilder
		kbuilder.add(ResourceFactory.newClassPathResource("rule/Query.drl",
				Query.class), ResourceType.DRL);
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
		// 定义事实对象
		Person p1 = new Person("p1", 24, new BigDecimal(50));
		Person p2 = new Person("p2", 25, new BigDecimal(50));
		Person p3 = new Person("p3", 26, new BigDecimal(50));
		Person p4 = new Person("p4", 27, new BigDecimal(50));
		Person p5 = new Person("p5", 28, new BigDecimal(50));
		Person p6 = new Person("p6", 31, new BigDecimal(50));
		Person p7 = new Person("p7", 32, new BigDecimal(50));		
		// 插入到Working Memory
		ksession.insert(p1);
		ksession.insert(p2);
		ksession.insert(p3);
		ksession.insert(p4);
		ksession.insert(p5);
		ksession.insert(p6);
		ksession.insert(p7);		
		// 执行查询
		QueryResults results = ksession.getQueryResults( "Age between", new Object[]{25, 30} );
		System.out.println("查询结果：" + results.size());
		// 输出结果数据
		for (QueryResultsRow row : results) {
			Person p = (Person)row.get("p");
			System.out.println("名称：" + p.getName() + ", 年龄：" + p.getAge());
		}		
		// 关闭当前session的资源
		ksession.dispose();
	}

}
