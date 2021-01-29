package com.au.library.LibraryManager;

import java.util.List;
import java.util.concurrent.BlockingQueue;

import com.au.library.entities.Book;


//Producer class for adding books to BlockingQueue
public class Producer implements Runnable{
	
	private BlockingQueue<Book> bbq;
	private List<Book> bookList;
	
	public Producer(BlockingQueue<Book> books, List<Book> bookList) {
		super();
		bbq = books;
		this.bookList = bookList;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(Book i:bookList)
			bbq.add(i);
		
	}

}
