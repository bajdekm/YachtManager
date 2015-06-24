package pl.lodz.p.idbd.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.lodz.p.idbd.service.impl.YachtServiceImpl;
import pl.lodz.p.idbd.service.impl.ReservationServiceImpl;

public class Returning extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private YachtServiceImpl yachtServiceImpl = new YachtServiceImpl();
	private ReservationServiceImpl reservationServiceImpl = new ReservationServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long yachtId = Long.valueOf(req.getParameter("yachtId"));
		reservationServiceImpl.makeReservationCanceled(yachtServiceImpl.getYachtById(yachtId));
		yachtServiceImpl.makeYachtAvailable(yachtId);
		req.setAttribute("yachts", yachtServiceImpl.getAll());
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}

}
