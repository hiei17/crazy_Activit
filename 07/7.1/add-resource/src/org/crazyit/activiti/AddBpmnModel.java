package org.crazyit.activiti;

import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.*;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;

public class AddBpmnModel {

	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到流程存储服务对象
		RepositoryService repositoryService = engine.getRepositoryService();
		// 创建DeploymentBuilder实例
		DeploymentBuilder builder = repositoryService.createDeployment();

		//mark
		BpmnModel model = createProcessModel();
		byte[] bytes = new BpmnXMLConverter().convertToXML(model);

		String text = new String(bytes);
		System.out.println(text);
		Deployment deployment = repositoryService.createDeployment().name("panda").addString("panda.xml",
				text).deploy();

		/*builder
				.addBpmnModel("MyCodeProcess", model)
				.name("MyCodeDeploy")//mark 名字可不加
				.deploy();*/
	}

	/**
	 * 动态生成 而不是读xml 保存过程中也会生成xml保存到数据库
	 * @return
	 */
	private static BpmnModel createProcessModel() {
		// 创建BPMN模型对象

		BpmnModel model = new BpmnModel();
		org.activiti.bpmn.model.Process process = new org.activiti.bpmn.model.Process();
		model.addProcess(process);
		process.setId("myProcess");
		process.setName("My Process");
		// 开始事件
		StartEvent startEvent = new StartEvent();
		startEvent.setId("startEvent");
		process.addFlowElement(startEvent);
		// 用户任务
		UserTask userTask = new UserTask();
		userTask.setName("User Task");
		userTask.setId("userTask");
		userTask.setOwner("1,3,4,5");
		process.addFlowElement(userTask);
		// 结束事件
		EndEvent endEvent = new EndEvent();
		endEvent.setId("endEvent");
		process.addFlowElement(endEvent);
		// 添加流程顺序
		process.addFlowElement(new SequenceFlow("startEvent", "userTask"));
		process.addFlowElement(new SequenceFlow("userTask", "endEvent"));
		return model;

		/*
		<?xml version="1.0" encoding="UTF-8"?>
<definitions xmlns="http://www.omg.org/spec/BPMN/20100524/MODEL" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:activiti="http://activiti.org/bpmn" xmlns:bpmndi="http://www.omg.org/spec/BPMN/20100524/DI" xmlns:omgdc="http://www.omg.org/spec/DD/20100524/DC" xmlns:omgdi="http://www.omg.org/spec/DD/20100524/DI" typeLanguage="http://www.w3.org/2001/XMLSchema" expressionLanguage="http://www.w3.org/1999/XPath" targetNamespace="http://www.activiti.org/test">
  <process id="myProcess" name="My Process" isExecutable="true">
    <startEvent id="startEvent"></startEvent>
    <userTask id="userTask" name="User Task" activiti:owner="1,3,4,5"></userTask>
    <endEvent id="endEvent"></endEvent>
    <sequenceFlow sourceRef="startEvent" targetRef="userTask"></sequenceFlow>
    <sequenceFlow sourceRef="userTask" targetRef="endEvent"></sequenceFlow>
  </process>
  <bpmndi:BPMNDiagram id="BPMNDiagram_myProcess">
    <bpmndi:BPMNPlane bpmnElement="myProcess" id="BPMNPlane_myProcess"></bpmndi:BPMNPlane>
  </bpmndi:BPMNDiagram>
</definitions>
		* */
	}

}
