package com.jpa.school;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpa.school.entities.Course;
import com.jpa.school.entities.Professor;
import com.jpa.school.entities.Student;
import com.jpa.school.repository.StudentJPARepository;

@SpringBootApplication
@Transactional
public class SchoolApplication implements CommandLineRunner {
	
	@Autowired
	StudentJPARepository studentJPARepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SchoolApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
		
		
		//Creation of entities
		Student student = new Student();
		
		Course course = new Course();
		
		Professor professor = new Professor();
		
		course.setCourseName("Java");
		course.setPrice(5000);
		
		Course course1 = new Course();
		course1.setCourseName("Python");
		course1.setPrice(4000);
		
		Course course2 = new Course();
		course2.setCourseName("Javascript");
		course2.setPrice(8000);
		
		professor.setName("Ankit");
		professor.setCourse(course1);
		
		Professor professor2 = new Professor();
		professor2.setName("Vikash");
		professor2.setCourse(course2);
		
		Set<Course> courselist = new HashSet<>();
		courselist.add(course);
		courselist.add(course1);
		courselist.add(course2);
		
		student.setName("Sourav");
		student.setCourse(courselist);
		student.setAge(22);
		
		Student student2 = new Student();
		student2.setName("Saket");
		student2.setCourse(courselist);
		student2.setAge(22);
		
		//Insertion
		studentJPARepository.save(student);
		studentJPARepository.save(student2);
		
		//Read operation
		Student res = studentJPARepository.findById(1);
		System.out.println(res);
		
		//finding student by their name
		List<Student> res1 = studentJPARepository.findByName("Sourav");
		
		res1.forEach(e -> System.out.println(e));
		
		//Updating a record
		Student temp = studentJPARepository.findById(2);
		temp.setAge(30);
		studentJPARepository.save(temp);
		
		Iterable<Student> allStudents = studentJPARepository.findAll();
		allStudents.forEach(e -> System.out.println(e));
		
		
		//Delete operation
//		studentJPARepository.deleteById(1);
//		
//		Iterable<Student> updatedList = studentJPARepository.findAll();
//		updatedList.forEach(e -> System.out.println(e));
		
		//Searching record which starts with "Sou"
		Student searchbyprefix = studentJPARepository.findByNameStartingWith("Sou");
		System.out.println(searchbyprefix);
	}

}
