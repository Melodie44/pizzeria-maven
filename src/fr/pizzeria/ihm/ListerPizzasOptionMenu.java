package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.model.OptionMenu;
import fr.pizzeria.model.Pizza;

/**
 * Classe de l'option pour lister les pizzas.
 * 
 * @author Maubois M�lodie
 * @version 1.0
 *
 */
public class ListerPizzasOptionMenu extends OptionMenu{
	
	private PizzaDao dao;
	private Pizza[] tabPizzas;
	
	/**
	 * Constructeur de cr�ation de l'option lister les pizzas.
	 * 
	 * @param dao
	 * 			Une instance de classe PizzaDao.
	 * 
	 * @param tabPizzas
	 * 				  Le tableau contenant les pizzas.
	 */
	public ListerPizzasOptionMenu(PizzaDao dao, Pizza[] tabPizzas) {
		
		this.dao = dao;
		this.tabPizzas = tabPizzas;
	}

	/**
	 * M�thode d'affichage de l'option lister pizzas.
	 * 
	 * @param Scanner
	 *				la r�ponse de l'utilisateur.
	 *
	 * @return Un boolean, true si tout c'est bien pass�.						  			  - le prix est n�gatif.
	 */
	@Override
	public boolean execute(Scanner scanner) {
		
		System.out.println("Liste des pizzas");
		
		for(Pizza pizza : dao.findAllPizzas()) {
			
			if(pizza.getCode() != null){
			
				System.out.println(pizza.toString());
			}
		}
		
		return true ;	
	}

}
