package dev.fr.pizzeria.ihm;

import java.util.Scanner;

import dev.fr.pizzeria.dao.jdbc.PizzaDaoBase;
import dev.fr.pizzeria.exception.DeletePizzaException;
import dev.fr.pizzeria.model.OptionMenu;

/**
 * Classe de l'option pour supprimer une pizza.
 * 
 * @author Maubois Mélodie
 * @version 1.0
 *
 */
public class SupprimerPizzaOptionMenu extends OptionMenu{

	private PizzaDaoBase dao;
	
	/**
	 * Constructeur de création de l'option supprimer une pizza.
	 * 
	 * @param dao
	 * 			Une instance de classe PizzaDao.
	 * 
	 * @param tabPizzas
	 * 				  Le tableau contenant les pizzas.
	 */
	public SupprimerPizzaOptionMenu(PizzaDaoBase dao) {
		
		this.dao = dao;
	}

	/**
	 * Méthode d'affichage de l'option supprimer pizza.
	 * 
	 * @param Scanner
	 *				la réponse de l'utilisateur.
	 *
	 * @return Un boolean, true si tout c'est bien passé.
	 * 
	 * @throws DeletePizzaException, si jamais : - le code n'existe pas.
	 * 							  			  
	 */
	@Override
	public boolean execute(Scanner scanner) throws DeletePizzaException{
		
		System.out.println("Veuillez saisir le code");
		String code  = scanner.nextLine();
		
		if(dao.deletePizza(code) == false) {
			
			throw new DeletePizzaException("Erreur, la pizza � supprimer n'existe pas");
			
		};
		
		return true;
	}
}
