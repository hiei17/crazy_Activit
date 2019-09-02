package org.crazyit.activiti;

import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.impl.ProcessEngineImpl;
import org.activiti.engine.runtime.Job;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * 工作执行异常
 * 
 * @author yangenxiong
 * 
 */
public class JobException {

	public static void main(String[] args) throws Exception {
		// 创建流程引擎
		ProcessEngineImpl engine = (ProcessEngineImpl) ProcessEngines
				.getDefaultProcessEngine();
		// 得到流程存储服务实例
		RepositoryService repositoryService = engine.getRepositoryService();
		repositoryService.createDeployment()
				.addClasspathResource("bpmn/jobException.bpmn").deploy();
		// 得到运行时服务组件
		RuntimeService runtimeService = engine.getRuntimeService();
		// 管理服务组件
		ManagementService mService = engine.getManagementService();
		// 启动流程
		runtimeService.startProcessInstanceByKey("testMsg");
		// 执行工作
		try {
			mService.executeJob(mService.createJobQuery().singleResult()
					.getId());
		} catch (Exception e) {
		}
		// 查询异常信息
		String msg = mService.getTimerJobExceptionStacktrace(mService
				.createTimerJobQuery().singleResult().getId());
		System.out.println("============ 分隔线  ==============");
		System.out.println(msg);
	}

}
