package org.crazyit.activiti;

import java.io.Serializable;

public class UserBean implements Serializable {

	private String name;
	
	private String passwd;

	public UserBean(String name, String passwd) {
		super();
		this.name = name;
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public int countAmount(int amount) {
		return amount + 10;
	}
}
