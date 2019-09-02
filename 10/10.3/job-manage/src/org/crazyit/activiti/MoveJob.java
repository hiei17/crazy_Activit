package org.crazyit.activiti;

import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.Job;

public class MoveJob {

	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到流程存储服务实例
		RepositoryService repositoryService = engine.getRepositoryService();
		// 得到运行时服务组件
		RuntimeService runtimeService = engine.getRuntimeService();
		// 管理服务组件
		ManagementService mService = engine.getManagementService();
		// 部署流程文件
		repositoryService.createDeployment()
				.addClasspathResource("bpmn/moveJob_1.bpmn").deploy();
		repositoryService.createDeployment()
				.addClasspathResource("bpmn/moveJob_2.bpmn").deploy();
		// 启动流程
		runtimeService.startProcessInstanceByKey("moveJob1");
		System.out.println("移动前一般工作数量：" + mService.createJobQuery().count()
				+ ", deadletter数量："
				+ mService.createDeadLetterJobQuery().count());
		// 将一般工作移动到deadletter表
		mService.moveJobToDeadLetterJob(mService.createJobQuery()
				.singleResult().getId());
		System.out.println("调用 moveJobToDeadLetterJob 后一般工作表数量："
				+ mService.createJobQuery().count() + ", deadletter数量："
				+ mService.createDeadLetterJobQuery().count());
		// 将deadletter移动到一般工作表
		mService.moveDeadLetterJobToExecutableJob(mService
				.createDeadLetterJobQuery().singleResult().getId(), 2);
		System.out.println("调用 moveDeadLetterJobToExecutableJob 后一般工作表数量："
				+ mService.createJobQuery().count() + ", deadletter数量："
				+ mService.createDeadLetterJobQuery().count());
		// 删除工作
		mService.deleteJob(mService.createJobQuery().singleResult().getId());

		// 启动第二条流程
		runtimeService.startProcessInstanceByKey("moveJob2");
		System.out.println("移动前工作数量：" + mService.createJobQuery().count()
				+ ", 定时器工作数量：" + mService.createTimerJobQuery().count());
		// 将定时器工作移动到一般工作表
		mService.moveTimerToExecutableJob(mService.createTimerJobQuery().singleResult().getId());		
		System.out.println("调用 moveTimerToExecutableJob 后一般工作表数量："
				+ mService.createJobQuery().count() + ", 定时器工作数量："
				+ mService.createTimerJobQuery().count());
	}
}
