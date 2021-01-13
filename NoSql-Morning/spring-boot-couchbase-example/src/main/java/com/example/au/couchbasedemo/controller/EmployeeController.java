package com.example.au.couchbasedemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.au.couchbasedemo.model.Employee;
import com.example.au.couchbasedemo.repository.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeRepository empRepository;
	
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee newEmployee)
	{
		return empRepository.save(newEmployee);
	}
	
	@GetMapping("/employee/location/{location}/pincode/{pincode}")
	public Employee getbylocAndPin(@PathVariable String location, @PathVariable String pincode)
	{
		return empRepository.findByLocationAndPincode(location, pincode);
	}
	
}
