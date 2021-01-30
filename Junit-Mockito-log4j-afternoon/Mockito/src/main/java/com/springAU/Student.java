package com.springAU;

import java.util.ArrayList;

public class Student {

	LibraryDB db;
	private int fine = 100;
	public String getName() {
		return "Ankit Sharma";
	}
	
	public ArrayList<String> getIssuedBooks() {
		ArrayList<String> booksIssued = new ArrayList<>();
		booksIssued.add("Maths");
		booksIssued.add("English");
		booksIssued.add("Science");
		return booksIssued;
	}
	
	public String chooseBooks(LibraryDB db) {
		this.db = db;
		String books[] = db.getAvailableBooks();
		return books[4];
	}
	
	public int getFine() {
		return fine;
	}
}
