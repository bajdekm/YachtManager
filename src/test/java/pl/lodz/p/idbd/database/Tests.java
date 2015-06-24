package pl.lodz.p.idbd.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import pl.lodz.p.idbd.model.Yacht;
import pl.lodz.p.idbd.service.impl.YachtServiceImpl;
import pl.lodz.p.idbd.util.HibernateUtil;

public class Tests {

	@Test
	public void addBooksToDatabase() {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		
		Yacht book1 = new Yacht();
		book1.setTitle("Harry Potter and The Chamber Of Secrets");
		book1.setAuthor("J.K.Rowling");
		book1.setAvailable(true);
		
		Yacht book2 = new Yacht();
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
		YachtServiceImpl bookServiceImpl = new YachtServiceImpl();
		bookServiceImpl.makeBookUnavailable(1L);
	}
	
}
