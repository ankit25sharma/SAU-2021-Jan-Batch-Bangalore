package com.au.library;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.au.library.LibraryManager.Consumer;
import com.au.library.LibraryManager.GeneratorService;
import com.au.library.LibraryManager.Producer;
import com.au.library.entities.Book;
import com.au.library.entities.Student;

public class LibraryDB {
	
	private static BlockingQueue<Book> books;
	
	private static ArrayList<Student> students;
	
	private static ArrayList<Book> booklist;

	public static void main(String[] args) {
		
		//Making students and book objects
		GeneratorService gs = new GeneratorService();
		students = (ArrayList<Student>) gs.generateStudents();
		booklist = (ArrayList<Book>) gs.generateBooks();
		//gs.showBooks(booklist);
		books = new LinkedBlockingQueue<>(booklist);
		
		//Producer
		Thread producerThread = new Thread(new Producer(books, booklist));
		producerThread.run();
		
//		Consumer 1
//		takes multiple book "A01" And "A01" So while checkout it will only have one copy. 
		Book[] booksToReview = booksInReview(0,1);
		Thread c1 = new Thread(new Consumer(books, students.get(1), booksToReview));
		c1.run();
		
//		Consumer 2
//		takes multiple book "A01" And "A02" So it will get "A01" after consumer 1 releases book "A01".
//		until that it wait.
		Book[] booksToReview1 = booksInReview(1,2);
		Thread c2 = new Thread(new Consumer(books, students.get(2), booksToReview1));
		c2.run();
		
//		Consumer3
		Book[] booksToReview2 = booksInReview(3,4,5);
		Thread c3 = new Thread(new Consumer(books, students.get(3), booksToReview2));
		c3.run();
		
	}
	
	//method to generate the book list to be put in cart. student can have multiple books.
	public static Book[] booksInReview(int ...booksToReview) {
		Book res[] = new Book[booksToReview.length];

		for (int i = 0; i < booksToReview.length; i++) {
			res[i] = booklist.get(booksToReview[i]);
		}
		return res;
	}
	
}

