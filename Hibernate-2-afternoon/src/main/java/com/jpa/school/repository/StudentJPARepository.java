package com.jpa.school.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jpa.school.entities.Student;

public interface StudentJPARepository extends CrudRepository<Student, Integer>{

	//finding by name
	List<Student> findByName(String string);
	
	Student findById(int id);
	
	//finding by prefix
	Student findByNameStartingWith(String s);

}
