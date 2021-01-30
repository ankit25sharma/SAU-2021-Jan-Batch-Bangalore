package com.springAU;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MockitoTest {

	Student student;
	LibraryDB libraryDB;
	
	@BeforeEach
	void init() {
		student = new Student();
		libraryDB = new LibraryDB();
	}
	
	@Test
	public void testChooseBook() {
		LibraryDB mockDb = mock(LibraryDB.class);
		String[] books = {"Maths", "Hindi", "Science", "English", "Computer"};
		when(mockDb.getAvailableBooks()).thenReturn(books);
		String choosenBook = student.chooseBooks(mockDb);
		assertEquals("Computer", choosenBook);
	}
	
	@Test
	public void testGetFine() {
		Student studentMock = mock(Student.class);
		int tempFine = 10;
		when(studentMock.getFine()).thenReturn(tempFine);
		int fine = libraryDB.getFine(studentMock);
		assertEquals(10, fine);
	}

	@Test
	public void testShowStudentDetails() {
		Student studentMock = mock(Student.class);
		ArrayList<String> al = new ArrayList<>();
		al.add("Maths");
		al.add("English");
		al.add("Science");
		when(studentMock.getIssuedBooks()).thenReturn(al);
		String singleBook = libraryDB.showStudentDetails(studentMock);
		assertEquals("Maths", singleBook);
	}
}
