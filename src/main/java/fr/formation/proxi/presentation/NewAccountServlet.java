package fr.formation.proxi.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.proxi.metier.entity.Account;
import fr.formation.proxi.metier.entity.Client;
import fr.formation.proxi.metier.service.AccountService;
import fr.formation.proxi.metier.service.ClientService;

public class NewAccountServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer idClient = Integer.parseInt(req.getParameter("id"));
		Client client = ClientService.getInstance().read(idClient);
		req.setAttribute("client", client);
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/addAccount.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Float balance = Float.parseFloat(req.getParameter("balance"));
		String number = req.getParameter("number");
		String accountType = req.getParameter("accountType");
		Integer accounts_id = Integer.parseInt(req.getParameter("id"));
		
		Account account = null;
		if (accountType.equals("current")) {
			account = new Account(number, balance, false, accounts_id);
			req.setAttribute("account_Type", "courant");
		} else {
			account = new Account(number, balance, true, accounts_id);
			req.setAttribute("account_Type", "épargne");
		}

		Client client = ClientService.getInstance().read(accounts_id);
		client.getAccounts().add(account);
		account = AccountService.getInstance().create(account);
		
		
		req.setAttribute("clientUpdated", client);
		req.setAttribute("accountAdded", account);
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/addAccount.jsp").forward(req, resp);
	}

}
