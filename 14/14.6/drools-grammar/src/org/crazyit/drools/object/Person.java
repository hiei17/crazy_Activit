package org.crazyit.drools.object;

import java.io.Serializable;
import java.math.BigDecimal;

public class Person implements Serializable {

	private String name;
	
	private int age;
	
	private BigDecimal weight;

	public Person() {
		super();
	}

	public Person(String name, int age, BigDecimal weight) {
		super();
		this.name = name;
		this.age = age;
		this.weight = weight;
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

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}
}
