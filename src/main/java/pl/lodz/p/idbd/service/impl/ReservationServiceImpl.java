package pl.lodz.p.idbd.service.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import pl.lodz.p.idbd.model.Yacht;
import pl.lodz.p.idbd.model.Reservation;
import pl.lodz.p.idbd.util.HibernateUtil;

public class ReservationServiceImpl {

	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	public void makeReservation(Yacht book, Long clientId) {
		Reservation reservation = new Reservation();
		reservation.setBook(book.getId());
		reservation.setClientId(clientId);
		reservation.setCanceled(false);
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(reservation);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	public void makeReservationCanceled(Yacht book) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Reservation.class).add(Restrictions.eq("bookId", book.getId()));
		Reservation reservation = null;
		try {
			reservation = (Reservation) criteria.list().get(0);
		} catch (IndexOutOfBoundsException ex) {
			session.getTransaction().commit();
			session.close();
			return;
		}
		reservation.setCanceled(true);
		session.update(reservation);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
}
