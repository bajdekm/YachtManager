package pl.lodz.p.idbd.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.lodz.p.idbd.model.Yacht;
import pl.lodz.p.idbd.service.impl.YachtServiceImpl;

public class Search extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private YachtServiceImpl yachtServiceImpl = new YachtServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String parameter = req.getParameter("yachtId");
		if(parameter.equals("")){
			req.setAttribute("yachts", yachtServiceImpl.getAll());
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		}
		Long yachtId = Long.valueOf(parameter);
		List<Yacht> yachts = new ArrayList<>();
		yachts.add(yachtServiceImpl.getYachtById(yachtId));
		req.setAttribute("yachts", yachts);
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}

}
