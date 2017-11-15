package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.OptionMenu;
import fr.pizzeria.model.Pizza;

/**
 * Classe de l'option pour supprimer une pizza.
 * 
 * @author Maubois M�lodie
 * @version 1.0
 *
 */
public class SupprimerPizzaOptionMenu extends OptionMenu{

	private PizzaDao dao;
	private Pizza[] tabPizzas;
	
	/**
	 * Constructeur de cr�ation de l'option supprimer une pizza.
	 * 
	 * @param dao
	 * 			Une instance de classe PizzaDao.
	 * 
	 * @param tabPizzas
	 * 				  Le tableau contenant les pizzas.
	 */
	public SupprimerPizzaOptionMenu(PizzaDao dao, Pizza[] tabPizzas) {
		
		this.dao = dao;
		this.tabPizzas = tabPizzas;
	}

	/**
	 * M�thode d'affichage de l'option supprimer pizza.
	 * 
	 * @param Scanner
	 *				la r�ponse de l'utilisateur.
	 *
	 * @return Un boolean, true si tout c'est bien pass�.
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
