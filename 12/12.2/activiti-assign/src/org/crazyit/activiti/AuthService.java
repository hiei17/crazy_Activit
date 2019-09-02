package org.crazyit.activiti;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.task.Task;

public class AuthService implements Serializable {
	
	private String lastUser = "angus";
	
	public String getLastUser() {
		return this.lastUser;
	}
	
	public AuthService() {
		System.out.println("create AuthService");
	}

	//使用方法为任务指定代理人
	public String getUserAssignee() {
		return "crazyit";
	}
	
	//使用方法为任务指定候选人
	public List<String> getCandidateUsers() {
		List<String> result = new ArrayList<String>();
		result.add("user1");
		result.add("user2");
		return result;
	}
	
	//使用方法为任务指定候选用户组
	public List<String> getCandidateGroups() {
		List<String> result = new ArrayList<String>();
		result.add("group1");
		result.add("group2");
		return result;
	}
}
