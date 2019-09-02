package org.crazyit.drools;

import org.kie.api.io.ResourceType;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;

public class TestError {

	public static void main(String[] args) {
		// 创建一个KnowledgeBuilder
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory
				.newKnowledgeBuilder();
		// 添加规则资源到 KnowledgeBuilder
		kbuilder.add(ResourceFactory.newClassPathResource("grammar.drl",
				TestError.class), ResourceType.DRL);
		// 输出错误信息
		if (kbuilder.hasErrors()) {
			System.out.println(kbuilder.getErrors().toString());
			System.exit(0);
		}
	}

}
