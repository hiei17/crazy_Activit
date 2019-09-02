package org.crazyit.activiti;

import java.util.Date;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

/**
 * 参数类型
 * @author yangenxiong
 *
 */
public class BasicVariableType {

	public static void main(String[] args) {
		//获取流程引擎实例
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 获取任务服务组件
		TaskService taskService = engine.getTaskService();
		//保存第一个Task
		Task task1 = taskService.newTask("task1");
		taskService.saveTask(task1);	
		Date d = new Date();
		short s = 3;
		//设置各种基本类型参数
		taskService.setVariable(task1.getId(), "arg0", false);
		taskService.setVariable(task1.getId(), "arg1", d);
		taskService.setVariable(task1.getId(), "arg2", 1.5D);
		taskService.setVariable(task1.getId(), "arg3", 2);
		taskService.setVariable(task1.getId(), "arg4", 10L);
		taskService.setVariable(task1.getId(), "arg5", null);
		taskService.setVariable(task1.getId(), "arg6", s);
		taskService.setVariable(task1.getId(), "arg7", "test");
	}

}
