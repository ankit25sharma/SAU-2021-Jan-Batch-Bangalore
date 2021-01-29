package com.au.library.LibraryManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

import com.au.library.entities.Book;
import com.au.library.entities.Student;

public class GeneratorService {
	
	private List<Book> books;
	
	private List<Student> students;
	
	public List<Book> generateBooks() {
		
		books = new ArrayList<>();
		int ids[] = new int[] {1,2,3,4,5,6,7,8,9,10};
		String names[] = new String[] {"B1","B1","B2","B3","B3","B3","B4","B5","B6","B7"};
		String iSBNs[] = new String[] {"A01","A01","A02","A03","A03","A03","A04","A05","A06","A07"};
		boolean isOwned[] = new boolean[10];
		boolean isInReview[] = new boolean[10];
		
		for(int i=0;i<10;i++) {
			books.add(new Book(ids[i], names[i], iSBNs[i], isInReview[i], isOwned[i]));
		}
		return books;
	}
	
	public List<Student> generateStudents() {
		
		students = new ArrayList<>();
		String[] name = {"A","B","C","D","E"};
		int[] id = 		{ 1,2,3,4,5 };
		System.out.println("\nTotal Available Students: ");
		for(int i=0;i<5;i++) {
			students.add(new Student(id[i], name[i]));
		}
		students.forEach(e -> System.out.println(e.getName()));
		return students;
	}
	
	public void showBooks(BlockingQueue<Book> b) {
		System.out.println("\nAvailable Books: ");
		b.forEach(e -> System.out.println("Book Name: "+e.getName()+ "\tISBN: "+e.getISBN() + "\tID: "+e.getId()));

	}
}
