package org.crazyit.activiti;

import java.io.Serializable;

/**
 * 序列化对象
 * @author yangenxiong
 *
 */
public class TestVO implements Serializable {

	private String name;
		
	public TestVO(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
