package fr.formation.proxi.persistance;

import java.util.ArrayList;
import java.util.List;

import fr.formation.proxi.metier.entity.Client;

/**
 * Classe regroupant les traitements � effectuer sur les clients. Respecte le
 * design pattern singleton.
 * 
 * @author Adminl
 *
 */
public class ClientDao extends AbstractDao<Client> {

	private static final ClientDao INSTANCE = new ClientDao();

	public static ClientDao getInstance() {
		return ClientDao.INSTANCE;
	}
	@Override
	public Client read(Integer id) {
		Client client;
		client = this.read(id, new Client());
		return client;
	}

	@Override
	public List<Client> readAll() {
		List<Client> clients = new ArrayList<>();
		clients.addAll(this.em.createQuery(JpqlQueries.SELECT_ALL_CLIENTS, Client.class).getResultList());
		return clients;
	}

	

}
