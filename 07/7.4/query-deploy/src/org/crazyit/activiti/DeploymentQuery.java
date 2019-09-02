package org.crazyit.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;

import java.util.List;

/**
 * 使用DeploymentQuery的deploymentId方法
 * @author yangenxiong
 *
 */
public class DeploymentQuery {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到流程存储服务实例
		RepositoryService repositoryService = engine.getRepositoryService();

		// 写入5条Deployment数据
		Deployment depA = repositoryService.createDeployment().addString("a1", "a1")
				.addString("a2", "a2").addString("a3", "a3").name("a").deploy();
		Deployment depB = repositoryService.createDeployment().addString("b1", "b1")
				.addString("b2", "b2").addString("b3", "b3").name("b").deploy();
		Deployment depC = repositoryService.createDeployment().addString("c1", "c1")
				.addString("c2", "c2").addString("c3", "c3").name("c").deploy();
		Deployment depD = repositoryService.createDeployment().addString("d1", "d1")
				.addString("d2", "d2").addString("d3", "d3").name("da").deploy();
		Deployment depE = repositoryService.createDeployment().addString("e1", "e1")
				.addString("e2", "e2").addString("e3", "e3").name("eb").deploy();


		//deploymentId方法
		Deployment depAQuery = repositoryService.createDeploymentQuery()
				.deploymentId(depA.getId()).singleResult();
		System.out.println("根据id查询：" + depAQuery.getName());

		//deploymentName方法
		Deployment depBQuery = repositoryService
				.createDeploymentQuery()
				.deploymentName("b").singleResult();
		System.out.println("查询名称为b：" + depBQuery.getName());

		//deploymentNameLike, 模糊查询，结果集为2
		List<Deployment> depCQuery = repositoryService
				.createDeploymentQuery()
				.deploymentNameLike("%b%")
				.list();
		System.out.println("模糊查询b，结果数量：" + depCQuery.size());
	}

}
