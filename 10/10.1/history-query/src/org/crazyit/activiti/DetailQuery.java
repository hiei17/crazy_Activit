package org.crazyit.activiti;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricDetail;
import org.activiti.engine.history.HistoricVariableInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

/**
 * 历史数据明细查询
 * 
 * @author yangenxiong
 *
 */
public class DetailQuery {

	public static void main(String[] args) {
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
		repositoryService.createDeployment()
				.addClasspathResource("bpmn/DetailQuery.bpmn").deploy();
		// 初始化参数
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("days", 1);
		// 启动流程
		ProcessInstance pi = runtimeService.startProcessInstanceByKey(
				"testProcess", vars);
		// 完成第一个任务
		Task task = taskService.createTaskQuery().processInstanceId(pi.getId())
				.singleResult();
		vars.put("days", 2); // 设置参数为2
		taskService.complete(task.getId(), vars);
		// 完成第二个任务
		task = taskService.createTaskQuery().processInstanceId(pi.getId())
				.singleResult();
		vars.put("days", 3); // 设置参数为3
		taskService.complete(task.getId(), vars);

		// 查询明细总数
		List<HistoricDetail> datas = historyService.createHistoricDetailQuery()
				.processInstanceId(pi.getId()).list();
		System.out.println("设置三次参数后，历史明细表数据：" + datas.size());

		// 查询参数表
		List<HistoricVariableInstance> hisVars = historyService
				.createHistoricVariableInstanceQuery()
				.processInstanceId(pi.getId()).list();
		System.out.println("参数表数据量：" + hisVars.size());
		System.out.println("参数最后的值为：" + hisVars.get(0).getValue());
	}

}
