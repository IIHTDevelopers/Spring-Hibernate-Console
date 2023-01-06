package com.assessment.hibernate.testutils;

import java.util.ArrayList;
import java.util.List;

import com.assessment.hibernate.model.Book;
import com.assessment.hibernate.model.Subject;

public class MasterData {
	public static Subject getSubject() {	
		Subject subject = new Subject();
		subject.setSubjectId(2);
		subject.setSubTitle("core java");
		subject.setDurationInHours(4);
		return subject;
	}
	
	public static Book getBook() {	
		Book book = new Book();		
		book.setBookId(101);
		book.setTitle("Microservice");
		book.setPrice(500);
		book.setVolume(1);
		book.setPublishDate("2022-01-01");
		return book;
	}
	
	public static List<Subject> getAllSubjects() {	
		List<Subject> subjects = new ArrayList<Subject>();
		for(int i=0;i<5;i++) {
			Subject subject = getSubject();
			subject.setSubjectId(i+1);
			subjects.add(subject);
		}
		return subjects;
	}
	
	public static List<Book> getAllBooks() {	
		List<Book> books = new ArrayList<Book>();
		for(int i=0;i<5;i++) {
			Book book = getBook();
			book.setBookId(i+1);
			books.add(book);
		}
		return books;
	}
	
}
