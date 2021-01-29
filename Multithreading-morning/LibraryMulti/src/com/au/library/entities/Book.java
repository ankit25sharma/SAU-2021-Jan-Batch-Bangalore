package com.au.library.entities;

public class Book {
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", iSBN=" + iSBN + ", isInReview=" + isInReview + ", isIssued="
				+ isIssued + "]";
	}

	private int id;
	
	private String name;
	
	private String iSBN;
	
	private boolean isInReview;
	
	private boolean isIssued;

	public Book(int id, String name, String iSBN, boolean isInReview, boolean isIssued) {
		super();
		this.id = id;
		this.name = name;
		this.iSBN = iSBN;
		this.isInReview = isInReview;
		this.isIssued = isIssued;
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

	public String getISBN() {
		return iSBN;
	}

	public void setISBN(String iSBN) {
		this.iSBN = iSBN;
	}

	public boolean isInReview() {
		return isInReview;
	}

	public void setInReview(boolean isInReview) {
		this.isInReview = isInReview;
	}

	public boolean isIssued() {
		return isIssued;
	}

	public void setIssued(boolean isIssued) {
		this.isIssued = isIssued;
	}
}
