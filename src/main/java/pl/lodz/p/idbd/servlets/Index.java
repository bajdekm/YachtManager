package pl.lodz.p.idbd.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.lodz.p.idbd.service.impl.YachtServiceImpl;

public class Index extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private YachtServiceImpl bookServiceImpl = new YachtServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("yachts", bookServiceImpl.getAll());
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}

}
