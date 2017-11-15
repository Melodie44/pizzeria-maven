package fr.pizzeria.exception;

/**
 * Classe de cr�ation des exceptions pour la suppression d'une pizza.
 * 
 * @author Maubois M�lodie
 * @version 1.0
 *
 */
public class DeletePizzaException extends StockageException{

	/**
	 * Constructeur appelant le constructeur parent de StockageException.
	 * Permet de cr�er un message d'exception pour la suppression d'une pizza.
	 * 
	 * @param message
	 * @see DeletePizzaException de StockageException
	 */
	public DeletePizzaException(String message) {
		super(message);
		
	}
}
