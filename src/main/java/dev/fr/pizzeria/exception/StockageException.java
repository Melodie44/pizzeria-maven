package dev.fr.pizzeria.exception;

/**
 * La classe mère de création d'un message d'exception pour la gestion des pizzas.
 * 
 * @author Maubois Mélodie
 * @version 1.0
 *
 */
public class StockageException extends Exception{

	String message;
	
	/**
	 * Constructeur pour créer une exception avec un message.
	 * 
	 * @param message
	 */
	public StockageException(String message) {
		
		this.message = message;
		
	}

	/**
	 * Permet de récupérer le message de l'exception.
	 * 
	 * @return un String, le message pour l'utilisateur
	 */
	@Override
	public String getMessage() {
		return message;
	}

}
