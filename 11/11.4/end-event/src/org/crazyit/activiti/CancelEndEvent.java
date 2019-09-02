package org.crazyit.activiti;

import org.activiti.engine.*;
import org.activiti.engine.task.Task;

import java.util.HashMap;
import java.util.Map;

/**
 * 取消结束事件
 * 
 * @author yangenxiong
 * 
 */
public class CancelEndEvent {

	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到流程存储服务组件
		RepositoryService repositoryService = engine.getRepositoryService();
		// 得到运行时服务组件
		RuntimeService runtimeService = engine.getRuntimeService();
		// 获取流程任务组件
		TaskService taskService = engine.getTaskService();
		// 部署流程文件
		repositoryService.createDeployment()
				.addClasspathResource("bpmn/CancelEndEvent.bpmn").deploy();
		// 启动流程
		runtimeService.startProcessInstanceByKey("cancelProcess");

		// 初始化流程参数
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("confirm", false);
		// 设置参数，完成用户确认的Task
		Task task = taskService.createTaskQuery().singleResult();
		taskService.complete(task.getId(), vars);

		//RemitDelegate 处理汇款业务
		//RollbackRemitDelegate 处理回滚汇款业务
		//ReceiveCancelDelegate 处理子流程取消后的业务
	}

}
