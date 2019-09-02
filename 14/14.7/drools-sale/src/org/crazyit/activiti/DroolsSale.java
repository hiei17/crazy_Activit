package org.crazyit.activiti;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import org.kie.api.io.ResourceType;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.definition.KnowledgePackage;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.StatefulKnowledgeSession;

public class DroolsSale {

	public static void main(String[] args) {
		// 创建一个KnowledgeBuilder
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory
				.newKnowledgeBuilder();
		// 添加规则资源到 KnowledgeBuilder
		kbuilder.add(ResourceFactory.newClassPathResource("rule/Sale.drl",
				DroolsSale.class), ResourceType.DRL);
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
		// 创建销售事实，符合周六打九折
		Sale s1 = new Sale("001", createDate("2017-07-01"));
		SaleItem s1Item1 = new SaleItem("矿泉水", new BigDecimal(5),
				new BigDecimal(4));
		s1.addItem(s1Item1);
		// 满100打八折
		Sale s2 = new Sale("002", createDate("2017-07-03"));
		SaleItem s2Item1 = new SaleItem("爆米花", new BigDecimal(20),
				new BigDecimal(5));
		s2.addItem(s2Item1);
		// 满200打七折
		Sale s3 = new Sale("003", createDate("2017-07-03"));
		SaleItem s3Item1 = new SaleItem("可乐一箱", new BigDecimal(70),
				new BigDecimal(3));
		s3.addItem(s3Item1);
		// 星期天满200
		Sale s4 = new Sale("004", createDate("2013-07-02"));
		SaleItem s4Item1 = new SaleItem("爆米花一箱", new BigDecimal(80),
				new BigDecimal(3));
		s4.addItem(s4Item1);
		// 插入到Working Memory
		ksession.insert(s1);
		ksession.insert(s2);
		ksession.insert(s3);
		ksession.insert(s4);
		// 匹配规则
		ksession.fireAllRules();
		// 查询结果
		Collection<Object> sales = (Collection<Object>) ksession.getObjects();
		for (Object obj : sales) {
			Sale sale = (Sale) obj;
			System.out.println("销售单：" + sale.getSaleCode() + " 原金额： "
					+ sale.getTotal() + " 处理后总金额：" + sale.getDiscountTotal()
					+ " 折扣：" + sale.getDiscount());
		}
		// 关闭当前session的资源
		ksession.dispose();
	}

	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	// 根据字符串创建日期对象
	static Date createDate(String date) {
		try {
			return sdf.parse(date);
		} catch (Exception e) {
			throw new RuntimeException("parse date error: " + e.getMessage());
		}
	}

}
