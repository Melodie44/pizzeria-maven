package fr.pizzeria.exception;

/**
 * Classe de cr�ation des exceptions pour la mise � jour d'une pizza.
 * 
 * @author Maubois M�lodie
 * @version 1.0
 *
 */
public class UpdatePizzaException extends StockageException{

	/**
	 * Constructeur appelant le constructeur parent de StockageException.
	 * Permet de cr�er un message d'exception pour la mise � jour d'une pizza.
	 * 
	 * @param message
	 * @see UpdatePizzaException de StockageException
	 */
	public UpdatePizzaException(String message) {
		super(message);
		
	}
}
