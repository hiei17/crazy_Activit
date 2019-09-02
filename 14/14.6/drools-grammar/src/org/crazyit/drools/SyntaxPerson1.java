package org.crazyit.drools;

import java.util.ArrayList;
import java.util.List;

public class SyntaxPerson1 {

	private String name;
	
	private int age;
	
	private List<String> children;

	public SyntaxPerson1(String name, int age, String firstChildName) {
		super();
		this.name = name;
		this.age = age;
		this.children = new ArrayList<String>();
		this.children.add(firstChildName);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public int myMethod() {
		return this.age + 1;
	}

	public List<String> getChildren() { 
		return children;
	}

	public void setChildren(List<String> children) {
		this.children = children;
	}
	
	public int childrenSize() {
		return this.children.size();
	}

	
	
}
