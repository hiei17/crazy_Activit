package org.crazyit.activiti;

import org.activiti.engine.*;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompeteParallel {

	public static void main(String[] args) {

		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        try {
		// 得到流程存储服务组件
		RepositoryService repositoryService = engine.getRepositoryService();
		// 得到运行时服务组件
		RuntimeService runtimeService = engine.getRuntimeService();
		// 得到任务服务组件
		TaskService taskService = engine.getTaskService();
		// 部署流程文件
		repositoryService.createDeployment()
				.addClasspathResource("bpmn/Parallel.bpmn").deploy();
		// 启动流程
		ProcessInstance pi = runtimeService
				.startProcessInstanceByKey("process1");


            tttt(taskService, pi);
        } finally {

            engine.close();
        }


	}

    private static void tttt(TaskService taskService, ProcessInstance pi) {
        // 完成填写申请任务并设置参数
        Map<String, Object> vars = new HashMap<String, Object>();
        vars.put("buttonKey", "pass");


        // 完成任务0
        Task task = taskService.createTaskQuery().processInstanceId(pi.getId())
                .active().singleResult();
        taskService.complete(task.getId(), vars);
        System.out.println("完成任务0" );

        List<Task> parallelTasks = taskService.createTaskQuery().processInstanceId(pi.getId()).list();
        System.out.println("开始分叉任务");

        task = taskService.createTaskQuery().processInstanceId(pi.getId())
                .taskDefinitionKey("task2").singleResult();
        taskService.complete(task.getId(), vars);
        String taskId = task.getId();
        System.out.println("完成一个平行任务:"+task.getName() );

        parallelTasks
                .stream()
                .filter(t-> !t.getId().equals(taskId))
                .forEach(
                        t->{
                            try {
                                taskService.complete(t.getId(),vars);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                );

        List<Task> list = taskService.createTaskQuery().processInstanceId(pi.getId()).list();
        list.forEach(e ->{
            String name = e.getName();
            System.out.println("剩下的任务:"+name);
            taskService.complete(e.getId(), vars);
            System.out.println("完成" );
        });




    }

}
