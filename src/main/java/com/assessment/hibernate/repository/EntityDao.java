package com.assessment.hibernate.repository;

import java.util.List;

import com.assessment.hibernate.model.Book;
import com.assessment.hibernate.model.Subject;

public interface EntityDao {
	public boolean addSubject(Subject subject);
	public boolean addBook(Book book);
	public boolean deleteSubject(long subjectId);
	public Subject searchSubject(long subjectId);
	public boolean deleteBook(long bookId);
	public Book searchBook(long bookId);
	public List<Subject> showAllSubjects();
	public List<Book> showAllBooks();
}
