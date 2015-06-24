package pl.lodz.p.idbd.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import pl.lodz.p.idbd.model.Book;
import pl.lodz.p.idbd.util.HibernateUtil;

public class BookServiceImpl {

	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	@SuppressWarnings("unchecked")
	public List<Book> getAll() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Book.class);
		List<Book> books = (List<Book>) criteria.list();
		System.out.println("Total books: " + books.size());
		return books;
	}
	
	public Book getBookById(Long id) {
		Session session = sessionFactory.openSession();
		Book book = (Book) session.get(Book.class, id);
		session.close();
		return book;
	}
	
	public void makeBookAvailable(Long id) {
		setBookStatus(id, true);
	}
	
	public void makeBookUnavailable(Long id) {
		setBookStatus(id, false);
	}
	
	private void setBookStatus(Long id, boolean value) {
		Session session = sessionFactory.openSession();
		Book book = getBookById(id);
		book.setAvailable(value);
		session.beginTransaction();
		session.update(book);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
}
