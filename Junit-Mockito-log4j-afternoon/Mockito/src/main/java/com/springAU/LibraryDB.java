package com.springAU;

public class LibraryDB {

	private Student student;
	
	public String[] getAvailableBooks() {
		
		String books[] = new String[]{"Maths", "Hindi", "Science", "English", "Computer"};
		return books;
	}
	
	public String showStudentDetails(Student student) {
		this.student = student;
		return student.getIssuedBooks().get(0);
	}
	
	public int getFine(Student student) {
		this.student = student;
		return student.getFine();
	}
}
