package com.jpa.school.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Course {
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + ", price=" + price + ", professor=" + professor
				+ ", student=" + student + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String courseName;
	
	@Column
	private int price;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	Professor professor;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Set<Student> student;

	public Set<Student> getStudent() {
		return student;
	}

	public void setStudent(Set<Student> student) {
		this.student = student;
	}
	
	
}
