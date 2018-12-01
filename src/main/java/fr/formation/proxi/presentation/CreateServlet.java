package fr.formation.proxi.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.proxi.metier.entity.Client;
import fr.formation.proxi.metier.service.ClientService;

public class CreateServlet extends HttpServlet {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/create.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Client clientAdded = ClientService.getInstance().create(new Client(req.getParameter("firstname"),req.getParameter("lastname"),req.getParameter("email"),req.getParameter("address")));
		req.setAttribute("clientAdded", clientAdded);
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/create.jsp").forward(req, resp);
	}
}
