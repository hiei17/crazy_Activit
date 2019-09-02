package org.crazyit.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

/**
 * 参数类型
 * @author yangenxiong
 *
 */
public class GetVariable {

	public static void main(String[] args) {
		//获取流程引擎实例
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 获取任务服务组件
		TaskService taskService = engine.getTaskService();
		//保存第一个Task
		Task task1 = taskService.newTask("task1");
		task1.setName("请差申请");
		taskService.saveTask(task1);
		//设置各种基本类型参数
		taskService.setVariable(task1.getId(), "days", 5);
		taskService.setVariable(task1.getId(), "target", new TestVO("北京"));
		//获取天数
		Integer days = (Integer)taskService.getVariable(task1.getId(), "days");
		System.out.println("出差天数：" + days);
		//获取目的地
		TestVO target = (TestVO)taskService.getVariable(task1.getId(), "target");
		System.out.println("出差目的地：" + target.getName());
	}

}
