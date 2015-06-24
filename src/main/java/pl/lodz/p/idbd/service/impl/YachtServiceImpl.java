package pl.lodz.p.idbd.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import pl.lodz.p.idbd.model.Yacht;
import pl.lodz.p.idbd.util.HibernateUtil;

public class YachtServiceImpl {

	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	@SuppressWarnings("unchecked")
	public List<Yacht> getAll() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Yacht.class);
		List<Yacht> yachts = (List<Yacht>) criteria.list();
		System.out.println("Total books: " + yachts.size());
		return yachts;
	}
	
	public Yacht getYachtById(Long id) {
		Session session = sessionFactory.openSession();
		Yacht yacht = (Yacht) session.get(Yacht.class, id);
		session.close();
		return yacht;
	}
	
	public void makeYachtAvailable(Long id) {
		setYachtStatus(id, true);
	}
	
	public void makeBookUnavailable(Long id) {
		setYachtStatus(id, false);
	}
	
	private void setYachtStatus(Long id, boolean value) {
		Session session = sessionFactory.openSession();
		Yacht yacht = getYachtById(id);
		yacht.setAvailable(value);
		session.beginTransaction();
		session.update(yacht);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
}
