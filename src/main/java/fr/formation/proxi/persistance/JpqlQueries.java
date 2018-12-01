package fr.formation.proxi.persistance;


/**
 * Classe contenant sous forme de constantes l'ensemble des requetes necessaires aux manipulations de la base de donnees.
 * 
 * @author Adminl
 *
 */
public class JpqlQueries {
	
	public static final String SELECT_ALL_CLIENTS = "SELECT c FROM Client c";
	public static final String SELECT_ALL_ACCOUNTS = "SELECT a FROM Account a";
	public static final String SELECT_ALL_ACCOUNTS_FOR_ONE_CLIENT = "SELECT a FROM Account a WHERE accounts_id = %s";

}
