package pl.lodz.p.idbd.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.lodz.p.idbd.service.impl.BookServiceImpl;
import pl.lodz.p.idbd.service.impl.ReservationServiceImpl;

public class Returning extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private BookServiceImpl bookServiceImpl = new BookServiceImpl();
	private ReservationServiceImpl reservationServiceImpl = new ReservationServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long bookId = Long.valueOf(req.getParameter("bookId"));
		reservationServiceImpl.makeReservationCanceled(bookServiceImpl.getBookById(bookId));
		bookServiceImpl.makeBookAvailable(bookId);
		req.setAttribute("books", bookServiceImpl.getAll());
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}

}
