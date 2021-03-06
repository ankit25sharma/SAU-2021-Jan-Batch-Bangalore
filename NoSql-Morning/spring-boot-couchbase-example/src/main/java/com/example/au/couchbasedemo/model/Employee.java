package com.example.au.couchbasedemo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

import com.sun.istack.NotNull;

@Document
public class Employee {
	
	@Id
	private String empId;
	private String empName;
	private String address;
	@NotNull
	private String location;
	@NotNull
	private String pincode;
	
	public Employee(String empId, String empName, String address, String location, String pincode) {
		this.empId = empId;
		this.empName = empName;
		this.address = address;
		this.location = location;
		this.pincode = pincode;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	

}
