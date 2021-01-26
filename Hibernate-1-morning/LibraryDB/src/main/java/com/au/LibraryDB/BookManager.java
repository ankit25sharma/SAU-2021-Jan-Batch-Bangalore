package com.au.LibraryDB;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BookManager {
	
	private static SessionFactory factory;
	public static void main(String[] args) {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		BookManager bookManager = new BookManager();
		
		//bookManager.addBook("The Alchemist", 500, "Paulo Coelho");
		//bookManager.addBook("Anna Karenina", 400, "Leo Tolstoy");
		//bookManager.addBook("Beloved", 600, "Toni Morrison");
		
		//bookManager.getBooks();
		
		//bookManager.updateBookById(1);
		
		//bookManager.deleteBook(3);
		
		bookManager.bookCount();
		
	}
	
	private void addBook(String name, int price, String authorName) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer bookId = null;
		try {
			tx = session.beginTransaction();
			Book b1 = new Book(name,price,authorName);
			bookId = (Integer)session.save(b1);
			tx.commit();
			System.out.println("New Book Added");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			if(tx!=null)
				tx.rollback();
		} finally {
			session.close();
		}
	}
	
	private void getBooks() {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List<Book> books = session.createQuery("FROM Book").list();
			if(books.size()!=0) {
				System.out.println("\nAvailable Books: ");
				System.out.println();
				for(Book book: books) {
					System.out.println("ID: "+book.getId());
					System.out.println("Name: "+book.getName());
					System.out.println("Price: "+book.getPrice());
					System.out.println("Author: "+book.getAuthorName());
					System.out.println();
					System.out.println("===========================================================================================");
				}
			} else {
				System.out.println("\nSorry! No Books Available");
			}
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			if(tx!=null)
				tx.rollback();
		} finally {
			session.close();
		}
	}
	
	private void updateBookById(int id) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Book res = session.get(Book.class, id);
			System.out.println("\nBefore Update.......");
			System.out.println("\nID: "+res.getId());
			System.out.println("Name: "+res.getName());
			System.out.println("Price: "+res.getPrice());
			System.out.println("Author: "+res.getAuthorName());
			res.setPrice(1000);
			session.update(res);
			System.out.println("\nAfter Update.......");
			Book updateBook = session.get(Book.class, id);
			System.out.println("ID: "+res.getId());
			System.out.println("Name: "+res.getName());
			System.out.println("Price: "+res.getPrice());
			System.out.println("Author: "+res.getAuthorName());
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			if(tx!=null)
				tx.rollback();
		} finally {
			session.close();
		}
	}
	
	private void deleteBook(int id) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Book book = session.get(Book.class,id);
			System.out.println("\nBook to be deleted.......");
			System.out.println("\nID: "+book.getId());
			System.out.println("Name: "+book.getName());
			System.out.println("Price: "+book.getPrice());
			System.out.println("Author: "+book.getAuthorName());
			System.out.println();
			session.delete(book);
			List<Book> books = session.createQuery("FROM Book").list();
			System.out.println("\nAvailable Books: ");
			System.out.println();
			for(Book res: books) {
				System.out.println("ID: "+res.getId());
				System.out.println("Name: "+res.getName());
				System.out.println("Price: "+res.getPrice());
				System.out.println("Author: "+res.getAuthorName());
				System.out.println();
				System.out.println("===========================================================================================");
			}
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null)
				tx.rollback();
		} finally {
			session.close();
		}
	}
	
	private void bookCount() {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List<Book> books = session.createQuery("FROM Book").list();
			System.out.println("\nTotal Books: "+books.size());
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			if(tx!=null)
				tx.rollback();
		} finally {
			session.close();
		}
		
	}
}
