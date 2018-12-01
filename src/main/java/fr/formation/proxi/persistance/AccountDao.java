package fr.formation.proxi.persistance;

import java.util.ArrayList;
import java.util.List;

import fr.formation.proxi.metier.entity.Account;

/**
 * Classe permettant les op�rations du C.R.U.D pour les comptes des clients.
 * Respecte le design pattern singleton.
 * 
 * @author Adminl
 *
 */
public class AccountDao extends AbstractDao<Account> {

	private static final AccountDao INSTANCE = new AccountDao();

	
	public static AccountDao getInstance() {
		return AccountDao.INSTANCE;
	}

	@Override
	public Account read(Integer id) {
		Account acc = null;
		acc = this.read(id, new Account());
		return acc;
	}

	@Override
	public List<Account> readAll() {
		List<Account> accounts = new ArrayList<>();
		accounts.addAll(this.em.createQuery(JpqlQueries.SELECT_ALL_ACCOUNTS, Account.class).getResultList());
		return accounts;
	}
	
	
	public List<Account> readAllAccountsForOneClient(Integer accounts_id){
		List<Account> accounts = new ArrayList<>();
		accounts.addAll(this.em.createQuery(String.format(JpqlQueries.SELECT_ALL_ACCOUNTS_FOR_ONE_CLIENT,accounts_id), Account.class).getResultList());
		return accounts;
	}
	


}
