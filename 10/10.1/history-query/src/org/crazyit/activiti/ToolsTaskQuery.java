package org.crazyit.activiti;

import org.activiti.engine.*;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 查询历史任务
 * @author yangenxiong
 *
 */
public class ToolsTaskQuery {

    final static String businessKey = "toolsClaim";
    final static Map<String,String> taskOwnerMap = new HashMap<>();


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


		//开始流程
		ProcessInstance pi1 = runtimeService.startProcessInstanceById(define.getId(), businessKey);

		//todo 完成所有流程
		Task task = taskService.createTaskQuery().processInstanceId(pi1.getId()).singleResult();
		taskService.complete(task.getId());
		task = taskService.createTaskQuery().processInstanceId(pi1.getId()).singleResult();
		taskService.complete(task.getId());


        List<HistoricTaskInstance> taskOwner = historyService
                .createHistoricTaskInstanceQuery()
                .processInstanceBusinessKey(businessKey).list();
		taskOwner.forEach(t-> {
			String taskDefinitionKey = t.getTaskDefinitionKey();
			String owner = t.getOwner();
			taskOwnerMap.put(businessKey+":"+taskDefinitionKey, owner);
		});
//taskDefinitionKey:examine
		//ower 就是  <userTask activiti:exclusive="true" id="create" name="申请" activiti:owner="1,3,4,5">
        System.out.println();

    }




}
