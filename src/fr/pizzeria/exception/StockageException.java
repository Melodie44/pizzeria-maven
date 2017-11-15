package fr.pizzeria.exception;

/**
 * La classe m�re de cr�ation d'un message d'exception pour la gestion des pizzas.
 * 
 * @author Maubois M�lodie
 * @version 1.0
 *
 */
public class StockageException extends Exception{

	String message;
	
	/**
	 * Constructeur pour cr�er une exception avec un message.
	 * 
	 * @param message
	 */
	public StockageException(String message) {
		
		this.message = message;
		
	}

	/**
	 * Permet de r�cup�rer le message de l'exception.
	 * 
	 * @return un String, le message pour l'utilisateur
	 */
	public String getMessage() {
		return message;
	}

}
