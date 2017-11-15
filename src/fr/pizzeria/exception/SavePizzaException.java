package fr.pizzeria.exception;

/**
 * Classe de cr�ation des exceptions pour la cr�ation d'une pizza.
 * 
 * @author Maubois M�lodie
 * @version 1.0
 *
 */
public class SavePizzaException extends StockageException{

	/**
	 * Constructeur appelant le constructeur parent de StockageException.
	 * Permet de cr�er un message d'exception pour la cr�ation d'une pizza.
	 * 
	 * @param message
	 * @see SavePizzaException de StockageException
	 */
	public SavePizzaException(String message) {
		super(message);
		
	}
}
