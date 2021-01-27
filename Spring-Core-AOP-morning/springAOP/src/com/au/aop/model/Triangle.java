package com.au.aop.model;

public class Triangle {
	
	private String name;

	public String getName() {
		//return name;
		throw new RuntimeException("Exception");
	}

	public void setName(String name) {
		this.name = name;
	}

}
