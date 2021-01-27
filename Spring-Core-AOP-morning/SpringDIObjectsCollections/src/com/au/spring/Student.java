package com.au.spring;

import java.util.Map;
import java.util.Set;

public class Student {
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", phones=" + phones + ", courses=" + courses + "]";
	}

	private String name;
	
	private Set<String> phones;
	
	private Map<String, Integer> courses;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getPhones() {
		return phones;
	}

	public void setPhones(Set<String> phones) {
		this.phones = phones;
	}

	public Map<String, Integer> getCourses() {
		return courses;
	}

	public void setCourses(Map<String, Integer> courses) {
		this.courses = courses;
	}
	
	
}
