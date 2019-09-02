package org.crazyit.activiti.xml;

import java.io.File;
import java.io.FileInputStream;

import com.thoughtworks.xstream.XStream;

public class XStreamUtil {

	private static XStream xstream = new XStream();
	
	static {
		// 配置XStream
		xstream.alias("process", MyProcess.class);
		xstream.alias("flow", SequenceFlow.class);
		xstream.alias("task", Task.class);
		xstream.alias("start", Start.class);
		xstream.alias("end", End.class);
		xstream.useAttributeFor(BaseElement.class, "id");
		xstream.useAttributeFor(SequenceFlow.class, "source");
		xstream.useAttributeFor(SequenceFlow.class, "target");
	}
	
	// 将XML文件转换为Process实例
	public static MyProcess toObject(File file) {
		try {
			FileInputStream fis = new FileInputStream(file);
			MyProcess p = (MyProcess)xstream.fromXML(fis);
			// 初始化行为与各节点的顺序流
			p.initBehavior();
			p.initSequenceFlow();
			fis.close();
			return p;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
