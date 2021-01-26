package com.au.LibraryDB;

public class Book {
	
	private int id;
	
	private String name;
	
	private int price;
	
	private String authorName;
	
	public Book() {
			
	}
	
	public Book(String name, int price, String authorName) {
		super();
		this.name = name;
		this.price = price;
		this.authorName = authorName;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	
}
