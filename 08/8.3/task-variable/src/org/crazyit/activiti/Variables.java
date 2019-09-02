package org.crazyit.activiti;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

/**
 * 设置多个任务参数
 * @author yangenxiong
 *
 */
public class Variables {

	public static void main(String[] args) {
		//获取流程引擎实例
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 获取任务服务组件
		TaskService taskService = engine.getTaskService();
		//保存第一个Task
		Task task1 = taskService.newTask(UUID.randomUUID().toString());
		task1.setName("请假流程");
		taskService.saveTask(task1);
		//初始化参数
		Map<String,Object> vars = new HashMap<String, Object>();
		vars.put("days", 10);
		vars.put("target", "欧洲");
		taskService.setVariables(task1.getId(), vars);
	}

}
