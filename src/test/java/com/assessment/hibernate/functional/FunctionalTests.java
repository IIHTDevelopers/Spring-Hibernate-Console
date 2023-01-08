package com.assessment.hibernate.functional;

import static com.assessment.hibernate.testutils.MasterData.getAllBooks;
import static com.assessment.hibernate.testutils.MasterData.getAllSubjects;
import static com.assessment.hibernate.testutils.MasterData.getBook;
import static com.assessment.hibernate.testutils.MasterData.getSubject;
import static com.assessment.hibernate.testutils.TestUtils.businessTestFile;
import static com.assessment.hibernate.testutils.TestUtils.currentTest;
import static com.assessment.hibernate.testutils.TestUtils.yakshaAssert;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.assessment.hibernate.model.Book;
import com.assessment.hibernate.model.Subject;
import com.assessment.hibernate.repository.EntityDaoImpl;


//@Component
public class FunctionalTests {
	@InjectMocks
	private static EntityDaoImpl entityDao;

	@Mock
	static SessionFactory sessionFactory;
	
	@Mock
	static Session session;
	

	@Mock
	static Transaction transaction;
	

	@Mock
	static Criteria criteria;
	
	@BeforeAll
	public static void setupMock(){
	    MockitoAnnotations.initMocks(new FunctionalTests());
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
				
			boolean status = entityDao.addSubject(getSubject());
			
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
					
				boolean status = entityDao.addBook(getBook());
				
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
					
				boolean status = entityDao.deleteSubject(1L);
				
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
					
				Subject subject = entityDao.searchSubject(1L);
				
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
					
				boolean status = entityDao.deleteBook(1L);
				
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
					
				Book book= entityDao.searchBook(1L);
				
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
									
				List<Subject> subjects= entityDao.showAllSubjects();
				
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
									
				List<Book> Books= entityDao.showAllBooks();
				
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
