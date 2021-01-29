package com.au.library.entities;

import java.util.ArrayList;
import java.util.List;

public class Student {
	
	private int id;
	
	private String name;
	
	private List<Book> reviewList;
	
	private List<Book> checkList;
	
	
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		checkList = new ArrayList<>();
		reviewList = new ArrayList<>();
		
	}

	
	
	public List<Book> getReviewList() {
		return reviewList;
	}



	public void setReviewList(List<Book> reviewList) {
		this.reviewList = reviewList;
	}



	public List<Book> getCheckList() {
		return checkList;
	}



	public void setCheList(List<Book> cheList) {
		this.checkList = cheList;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addToCart(Book book) {
		this.reviewList.add(book);
	}
}
