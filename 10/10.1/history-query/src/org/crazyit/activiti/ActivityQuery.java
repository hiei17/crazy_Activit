package org.crazyit.activiti;

import java.util.List;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

/**
 * 历史行为查询
 * @author yangenxiong
 *
 */
public class ActivityQuery {


	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到流程存储服务实例
		RepositoryService repositoryService = engine.getRepositoryService();
		// 得到运行时服务组件
		RuntimeService runtimeService = engine.getRuntimeService();
		// 得到历史服务组件
		HistoryService historyService = engine.getHistoryService();
		// 任务组件
		TaskService taskService = engine.getTaskService();
		// 部署流程文件
		repositoryService.createDeployment()
				.addClasspathResource("bpmn/ActivityQuery.bpmn").deploy();			
		// 开始两条流程
		ProcessInstance pi1 = runtimeService.startProcessInstanceByKey("testProcess");
		ProcessInstance pi2 = runtimeService.startProcessInstanceByKey("testProcess");
		// 完成第一个流程
		Task task = taskService.createTaskQuery().processInstanceId(pi1.getId()).singleResult();
		taskService.complete(task.getId());		
		runtimeService.signalEventReceived("mySignal");
		// 第二个流程实例完成第一个任务
		task = taskService.createTaskQuery().processInstanceId(pi2.getId()).singleResult();
		taskService.complete(task.getId());	
		//查询数据
		List<HistoricActivityInstance> datas = historyService.createHistoricActivityInstanceQuery()
				.activityId("endevent1").list();
		System.out.println("使用activityId查询：" + datas.size());//结果1
		datas = historyService.createHistoricActivityInstanceQuery()
				.activityInstanceId(datas.get(0).getId()).list();
		System.out.println("使用activityInstanceId查询：" + datas.size());//结果1
		datas = historyService.createHistoricActivityInstanceQuery()
				.activityType("intermediateCatchEvent").list();
		System.out.println("使用activityType查询：" + datas.size());//结果2
		datas = historyService.createHistoricActivityInstanceQuery().finished().list();
		System.out.println("使用finished查询：" + datas.size());//结果6
		datas = historyService.createHistoricActivityInstanceQuery()
				.processInstanceId(pi2.getId()).list();
		System.out.println("使用processInstanceId查询：" + datas.size());//结果3
		datas = historyService.createHistoricActivityInstanceQuery()
				.taskAssignee("crazyit").list();
		System.out.println("使用taskAssignee查询：" + datas.size());//结果2
		datas = historyService.createHistoricActivityInstanceQuery().unfinished().list();
		System.out.println("使用unfinished查询：" + datas.size());//结果1
	}

}
