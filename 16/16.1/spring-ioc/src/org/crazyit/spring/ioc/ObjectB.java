package org.crazyit.spring.ioc;

public class ObjectB {

	private ObjectA objectA;
	
	public void setObjectA(ObjectA objectA) {
		this.objectA = objectA;
	}
	
	public ObjectA getObjectA() {
		return this.objectA;
	}
}
