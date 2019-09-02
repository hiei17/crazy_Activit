package org.crazyit.activiti;

import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.GraphicInfo;
import org.activiti.bpmn.model.Process;
import org.activiti.bpmn.model.UserTask;

public class Exchange {

	public static void main(String[] args) {
		// 创建一个BPMN模型实例
	    BpmnModel bpmnModel = new BpmnModel();
	    // 创建流程
	    Process process = new Process();
	    process.setId("myProcess");
	    bpmnModel.getProcesses().add(process);
	    // 创建任务
	    UserTask task = new UserTask();
	    task.setId("myTask");
	    process.addFlowElement(task);
	    // 设置任务的图形信息
	    GraphicInfo g1 = new GraphicInfo();
	    g1.setHeight(100);
	    g1.setWidth(200);
	    g1.setX(110);
	    g1.setY(120);
	    bpmnModel.addGraphicInfo("myTask", g1);
	    // XML转换器，将BPMN模型转换为XML文档 
	    BpmnXMLConverter converter = new BpmnXMLConverter();
	    System.out.println(new String(converter.convertToXML(bpmnModel)));
	}
}
