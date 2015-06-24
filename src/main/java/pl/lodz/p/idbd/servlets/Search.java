package pl.lodz.p.idbd.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.lodz.p.idbd.model.Book;
import pl.lodz.p.idbd.service.impl.BookServiceImpl;

public class Search extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private BookServiceImpl bookServiceImpl = new BookServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String parameter = req.getParameter("bookId");
		if(parameter.equals("")){
			req.setAttribute("books", bookServiceImpl.getAll());
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		}
		Long bookId = Long.valueOf(parameter);
		List<Book> books = new ArrayList<>();
		books.add(bookServiceImpl.getBookById(bookId));
		req.setAttribute("books", books);
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}

}
