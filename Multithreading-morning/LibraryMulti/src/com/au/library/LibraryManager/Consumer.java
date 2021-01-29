package com.au.library.LibraryManager;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.au.library.entities.Book;
import com.au.library.entities.Student;

//Consumer class for issuing and reviewing books if available
public class Consumer implements Runnable {

	BlockingQueue<Book> bbq;
	Student Student;
	Book booksToReview[];
	static Lock l = new ReentrantLock();

	public Consumer(BlockingQueue<Book> bbq, Student student, Book booksToReview[]) {
		super();
		this.bbq = bbq;
		Student = student;
		this.booksToReview = booksToReview;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		l.lock();
		
		GeneratorService gService = new GeneratorService();
		gService.showBooks(bbq);
		
		review();
		
		checkOut();
		
		l.unlock();
		
		//add the books back to blocking queue if it is not issued after checkout and printing multiple books from the cart.
		Student.getReviewList().forEach(e -> {
			if(!e.isIssued()) {
				bbq.add(e);
				System.out.println("\tRemoving multiple books: "+ e.getISBN()+ " from Student " + Student.getName());
			}
			
		});
		
		//Clearing the review cart after checkout
		Student.getReviewList().clear();
		System.out.println("Student "+Student.getName()+ " issued: "+Student.getCheckList());

	}
	
	public void review() {
		
		if(bbq.size()>0) {
			
			int i=0;
			Iterator<Book> iterator = bbq.iterator();
			//traversing the queue and checking if the book is currently present or not.
			while(iterator.hasNext() && i < booksToReview.length) {
				
				Book bookToSearch = iterator.next();
				String reviewBookISBN = booksToReview[i].getISBN();
				
				String bbqIsbn = bookToSearch.getISBN();
				//matching through ISBN number
				if(reviewBookISBN.equals(bbqIsbn)) {
					bookToSearch.setInReview(true);
					bbq.remove(bookToSearch);
					Student.addToCart(bookToSearch);
					i++;
				}
				
			}
			//printing review list
			System.out.println(Student.getName()+" has "+Student.getReviewList()+ " in review list");
		}
	}
	
	public void checkOut() {
		System.out.println("in checkout");
		List<Book> reviewList = Student.getReviewList();
		List<Book> checkList = Student.getCheckList();
		//List<String> isbn = new ArrayList<>();
		Set<String> set = new HashSet<>();
		
		if(reviewList.size()>0) {
			//filtering multiple books using Set and adding to the checklist from reviewlist
			for(Book book: reviewList) {
				if(set.size()!=0 && !set.contains(book.getISBN())) {
					checkList.add(book);
					book.setIssued(true);
				} 
				if(set.size()==0) {
					set.add(book.getISBN());
					checkList.add(book);
					book.setIssued(true);
				}
			}
		}
		
	}
	
}
