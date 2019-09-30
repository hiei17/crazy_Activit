package org.crazyit.activiti;

import org.activiti.engine.*;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 查询历史任务
 * @author yangenxiong
 *
 */
public class TaskQuery {


	public static void main(String[] args) throws Exception {

		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到流程存储服务实例
		RepositoryService repositoryService = engine.getRepositoryService();
		// 得到运行时服务组件
		RuntimeService runtimeService = engine.getRuntimeService();
		// 得到历史服务组件
		HistoryService historyService = engine.getHistoryService();
		// 得到任务组件
		TaskService taskService = engine.getTaskService();
		// 部署流程文件
		Deployment deploy = repositoryService.createDeployment()
				.addClasspathResource("bpmn/工器具领用.bpmn").deploy();
		ProcessDefinition define = repositoryService.createProcessDefinitionQuery()
				.deploymentId(deploy.getId()).singleResult();

		// 初始化参数
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Map<String, Object> vars = new HashMap<>();
		vars.put("varDate1", sdf.parseObject("2020-10-10 06:00:00"));
		vars.put("varDate2", sdf.parseObject("2021-10-10 06:00:00"));
		//开始流程
		ProcessInstance pi1 = runtimeService.startProcessInstanceByKey("testProcess", 
				"businessKey1", vars);
		ProcessInstance pi2 = runtimeService.startProcessInstanceByKey("testProcess", 
				"businessKey2", vars);

		//完成流程1
		List<Task> list = taskService.createTaskQuery().processInstanceId(pi1.getId()).active().list();
		Task task = taskService.createTaskQuery().processInstanceId(pi1.getId()).singleResult();
		taskService.complete(task.getId());
		task = taskService.createTaskQuery().processInstanceId(pi1.getId()).singleResult();
		taskService.complete(task.getId());

		// 流程2完成一个任务
		task = taskService.createTaskQuery().processInstanceId(pi2.getId()).singleResult();
		taskService.complete(task.getId());

		// mark 历史数据查询
		List<HistoricTaskInstance> datas = historyService
				.createHistoricTaskInstanceQuery()
				.finished()
				.list();
		System.out.println("使用finished方法查询：" + datas.size());//结果3

		datas = historyService.createHistoricTaskInstanceQuery()
				.processDefinitionId(define.getId()).list();
		System.out.println("使用processDefinitionId方法查询：" + datas.size());//结果4

		datas = historyService.createHistoricTaskInstanceQuery()
				.processDefinitionKey("testProcess").list();
		System.out.println("使用processDefinitionKey方法查询：" + datas.size());//结果4

		datas = historyService.createHistoricTaskInstanceQuery()
				.processDefinitionName("testProcess2").list();
		System.out.println("使用processDefinitionName方法查询：" + datas.size());//结果4

		datas = historyService.createHistoricTaskInstanceQuery()
				.processFinished().list();
		System.out.println("使用processFinished方法查询：" + datas.size());//结果2

		datas = historyService.createHistoricTaskInstanceQuery()
				.processInstanceId(pi2.getId()).list();
		System.out.println("使用processInstanceId方法查询：" + datas.size());//结果2

		datas = historyService.createHistoricTaskInstanceQuery()
				.processUnfinished().list();
		System.out.println("使用processUnfinished方法查询：" + datas.size());//结果2

		datas = historyService.createHistoricTaskInstanceQuery()
				.taskAssignee("crazyit").list();
		System.out.println("使用taskAssignee方法查询：" + datas.size());//结果2

		datas = historyService.createHistoricTaskInstanceQuery()
				.taskAssigneeLike("%zy%").list();
		System.out.println("使用taskAssigneeLike方法查询：" + datas.size());//结果2

		datas = historyService.createHistoricTaskInstanceQuery()
				.taskDefinitionKey("usertask1").list();
		System.out.println("使用taskDefinitionKey方法查询：" + datas.size());//结果2

		datas = historyService.createHistoricTaskInstanceQuery()
				.taskDueAfter(sdf.parse("2020-10-11 06:00:00")).list();
		System.out.println("使用taskDueAfter方法查询：" + datas.size());//结果2

		datas = historyService.createHistoricTaskInstanceQuery()
				.taskDueBefore(sdf.parse("2022-10-11 06:00:00")).list();
		System.out.println("使用taskDueBefore方法查询：" + datas.size());//结果4

		datas = historyService.createHistoricTaskInstanceQuery()
				.taskDueDate(sdf.parse("2020-10-11 06:00:00")).list();
		System.out.println("使用taskDueDate方法查询：" + datas.size());//结果0

		datas = historyService.createHistoricTaskInstanceQuery()
				.unfinished().list();
		System.out.println("使用unfinished方法查询：" + datas.size());//结果1




    }

}
