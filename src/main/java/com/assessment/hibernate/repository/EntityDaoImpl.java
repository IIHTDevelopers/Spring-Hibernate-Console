package com.assessment.hibernate.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.assessment.hibernate.model.Book;
import com.assessment.hibernate.model.Subject;

public class EntityDaoImpl implements EntityDao {
	private SessionFactory sessionFactory;

	public EntityDaoImpl() {
		
	}

	public SessionFactory getSessionFactory() {
		return null;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		
	}

	public boolean addSubject(Subject subject) {
		return false;
	}

	public boolean addBook(Book book) {
		return false;
	}

	public boolean deleteSubject(long subjectId) {
		return false;
	}

	public Subject searchSubject(long subjectId) {
		return null;
	}

	public boolean deleteBook(long bookId) {
		return false;
	}

	public Book searchBook(long bookId) {
		return null;
	}

	public List<Subject> showAllSubjects() {
		return null;
	}

	public List<Book> showAllBooks() {
		return null;
	}

	public void closeSession(Session session) {
		session.close();
	}
}
