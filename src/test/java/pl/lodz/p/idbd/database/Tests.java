package pl.lodz.p.idbd.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import pl.lodz.p.idbd.model.Book;
import pl.lodz.p.idbd.service.impl.BookServiceImpl;
import pl.lodz.p.idbd.util.HibernateUtil;

public class Tests {

	@Test
	public void addBooksToDatabase() {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		
		Book book1 = new Book();
		book1.setTitle("Harry Potter and The Chamber Of Secrets");
		book1.setAuthor("J.K.Rowling");
		book1.setAvailable(true);
		
		Book book2 = new Book();
		book2.setTitle("Harry Potter and The Prisoner Of Azkaban");
		book2.setAuthor("J.K.Rowling");
		book2.setAvailable(true);
		
		Session session = sf.openSession();
		session.beginTransaction();
		
		session.save(book1);
		session.save(book2);
		
		session.flush();
		session.getTransaction().commit();
		
	}
	
	@Test
	public void testBookStatus() {
		BookServiceImpl bookServiceImpl = new BookServiceImpl();
		bookServiceImpl.makeBookUnavailable(1L);
	}
	
}
