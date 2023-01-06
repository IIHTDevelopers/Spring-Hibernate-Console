package com.assessment.hibernate.functional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.stereotype.Component;

import static com.assessment.hibernate.testutils.TestUtils.businessTestFile;
import static com.assessment.hibernate.testutils.TestUtils.currentTest;
import static com.assessment.hibernate.testutils.TestUtils.yakshaAssert;
import static com.assessment.hibernate.testutils.MasterData.*;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import com.assessment.hibernate.model.Book;
import com.assessment.hibernate.model.Subject;
import com.assessment.hibernate.repository.EntityDaoImpl;


@Component
public class FunctionalTests {
	@InjectMocks
	private EntityDaoImpl entityDao;

	@Mock
	SessionFactory sessionFactory;
	
	@Mock
	Session session;
	

	@Mock
	Transaction transaction;
	

	@Mock
	Criteria criteria;
	
	@Before
	public void setupMock(){
	    MockitoAnnotations.initMocks(this);
	    sessionFactory = mock(SessionFactory.class);
	    session = mock(Session.class);
	    criteria = mock(Criteria.class);
	    entityDao.setSessionFactory(sessionFactory);
	}

	@Test
	@Transactional
	public void testAddSubject() throws Exception {
		try {
			Integer id = 1;
			when(sessionFactory.openSession()).thenReturn(session);
			when(session.save(getSubject())).thenReturn(id);
			when(session.getTransaction()).thenReturn(transaction);
				
			boolean status = this.entityDao.addSubject(getSubject());
			
			yakshaAssert(currentTest(),
					(status==true?"true":"false"),
					businessTestFile);
		}catch(Exception ex) {
			yakshaAssert(currentTest(),
					"false",
					businessTestFile);
		}
	}
	
	  @Test
	  @Transactional
	  public void testAddBook() throws Exception
	  {
		  try {
				Integer id = 1;
				when(sessionFactory.openSession()).thenReturn(session);
				when(session.save(getBook())).thenReturn(id);
				when(session.getTransaction()).thenReturn(transaction);
					
				boolean status = this.entityDao.addBook(getBook());
				
				yakshaAssert(currentTest(),
						(status==true?"true":"false"),
						businessTestFile);
			}catch(Exception ex) {
				yakshaAssert(currentTest(),
						"false",
						businessTestFile);
			}
	  }
	  
	  @Test
	  @Transactional
	  public void testDeleteSubject() throws Exception
	  {
		  try {
				when(sessionFactory.openSession()).thenReturn(session);
				when(session.getTransaction()).thenReturn(transaction);
					
				boolean status = this.entityDao.deleteSubject(1L);
				
				yakshaAssert(currentTest(),
						(status==true?"true":"false"),
						businessTestFile);
			}catch(Exception ex) {
				yakshaAssert(currentTest(),
						"false",
						businessTestFile);
			}
	  }
	  
	  @Test
	  @Transactional
	  public void testSearchSubject() throws Exception
	  {
		  try {
				when(sessionFactory.openSession()).thenReturn(session);
				when(session.load(Subject.class, 1L)).thenReturn(getSubject());
				when(session.get(Subject.class, 1L)).thenReturn(getSubject());
					
				Subject subject = this.entityDao.searchSubject(1L);
				
				yakshaAssert(currentTest(),
						(subject != null?"true":"false"),
						businessTestFile);
			}catch(Exception ex) {
				yakshaAssert(currentTest(),
						"false",
						businessTestFile);
			}
	  }
	  
	  @Test
	  @Transactional
	  public void testDeleteBook() throws Exception
	  {
		  try {
				when(sessionFactory.openSession()).thenReturn(session);
				when(session.getTransaction()).thenReturn(transaction);
					
				boolean status = this.entityDao.deleteBook(1L);
				
				yakshaAssert(currentTest(),
						(status==true?"true":"false"),
						businessTestFile);
			}catch(Exception ex) {
				yakshaAssert(currentTest(),
						"false",
						businessTestFile);
			}
	  }
	  
	  @Test
	  @Transactional
	  public void testSearchBook() throws Exception
	  {
		  try {
				when(sessionFactory.openSession()).thenReturn(session);
				when(session.load(Book.class, 1L)).thenReturn(getBook());
				when(session.get(Book.class, 1L)).thenReturn(getBook());
					
				Book book= this.entityDao.searchBook(1L);
				
				yakshaAssert(currentTest(),
						(book != null?"true":"false"),
						businessTestFile);
			}catch(Exception ex) {
				yakshaAssert(currentTest(),
						"false",
						businessTestFile);
			}
	  }
	  
	  @Test
	  @Transactional
	  public void testShowAllSubjects() throws Exception
	  {
		  try {
				when(sessionFactory.openSession()).thenReturn(session);
				when(session.createCriteria(Subject.class)).thenReturn(criteria);
				when(criteria.list()).thenReturn(getAllSubjects());
									
				List<Subject> subjects= this.entityDao.showAllSubjects();
				
				yakshaAssert(currentTest(),
						(subjects != null?"true":"false"),
						businessTestFile);
			}catch(Exception ex) {
				yakshaAssert(currentTest(),
						"false",
						businessTestFile);
			}
	  }
	  
	  @Test
	  @Transactional
	  public void testShowAllBooks() throws Exception
	  {
		  try {
				when(sessionFactory.openSession()).thenReturn(session);
				when(session.createCriteria(Book.class)).thenReturn(criteria);
				when(criteria.list()).thenReturn(getAllBooks());
									
				List<Book> Books= this.entityDao.showAllBooks();
				
				yakshaAssert(currentTest(),
						(Books != null?"true":"false"),
						businessTestFile);
			}catch(Exception ex) {
				yakshaAssert(currentTest(),
						"false",
						businessTestFile);
			}
	  }
	  
	  
	
}
