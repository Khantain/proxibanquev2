package fr.formation.proxi.persistance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe permettant de se lier a� la base de donnees MySQL. 
 * Cette classe est un singleton.
 * @author Adminl
 *
 */
public class MySqlConnection {

	public static final MySqlConnection INSTANCE = new MySqlConnection();

	public static MySqlConnection getInstance() {
		return MySqlConnection.INSTANCE;
	}

	private EntityManagerFactory emf;
	

	/**
	 * Methode qui permet de recuperer la connection etablie par la classe.
	 * Ne prend pas de parametres.
	 * @return La connection à la BDD MySQL.
	 */
	public EntityManager getEntityManager() {
		return this.emf.createEntityManager();
	}

	/**
	 * Constructeur de classe qui permet la connexion a� la base de donnees. 
	 */
	public MySqlConnection() {
		this.emf = Persistence.createEntityManagerFactory("proxibanquev2");

	}

}
