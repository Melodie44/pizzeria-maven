package dev.fr.pizzeria.exception;

import dev.fr.pizzeria.exception.StockageException;

/**
 * Classe de création des exceptions pour la création d'une pizza.
 * 
 * @author Maubois Mélodie
 * @version 1.0
 *
 */
public class SavePizzaException extends StockageException{

	/**
	 * Constructeur appelant le constructeur parent de StockageException.
	 * Permet de créer un message d'exception pour la création d'une pizza.
	 * 
	 * @param message
	 * @see SavePizzaException de StockageException
	 */
	public SavePizzaException(String message) {
		super(message);
		
	}
}
