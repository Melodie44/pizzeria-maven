package dev.fr.pizzeria.exception;

import dev.fr.pizzeria.exception.StockageException;

/**
 * Classe de création des exceptions pour la mise à jour d'une pizza.
 * 
 * @author Maubois Mélodie
 * @version 1.0
 *
 */
public class UpdatePizzaException extends StockageException{

	/**
	 * Constructeur appelant le constructeur parent de StockageException.
	 * Permet de créer un message d'exception pour la mise à jour d'une pizza.
	 * 
	 * @param message
	 * @see UpdatePizzaException de StockageException
	 */
	public UpdatePizzaException(String message) {
		super(message);
		
	}
}
