package fr.pizzeria.exception;

/**
 * Classe de création des exceptions pour la suppression d'une pizza.
 * 
 * @author Maubois Mélodie
 * @version 1.0
 *
 */
public class DeletePizzaException extends StockageException{

	/**
	 * Constructeur appelant le constructeur parent de StockageException.
	 * Permet de créer un message d'exception pour la suppression d'une pizza.
	 * 
	 * @param message
	 * @see DeletePizzaException de StockageException
	 */
	public DeletePizzaException(String message) {
		super(message);
		
	}
}
