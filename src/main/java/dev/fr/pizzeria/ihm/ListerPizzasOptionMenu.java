package dev.fr.pizzeria.ihm;

import java.util.List;
import java.util.Scanner;

import dev.fr.pizzeria.dao.PizzaDao;
import dev.fr.pizzeria.dao.jdbc.PizzaDaoBase;
import dev.fr.pizzeria.model.OptionMenu;
import dev.fr.pizzeria.model.Pizza;

/**
 * Classe de l'option pour lister les pizzas.
 * 
 * @author Maubois Mélodie
 * @version 1.0
 *
 */
public class ListerPizzasOptionMenu extends OptionMenu{
	
	private PizzaDaoBase dao;
	
	/**
	 * Constructeur de création de l'option lister les pizzas.
	 * 
	 * @param dao
	 * 			Une instance de classe PizzaDao.
	 * 
	 * @param tabPizzas
	 * 				  Le tableau contenant les pizzas.
	 */
	public ListerPizzasOptionMenu(PizzaDaoBase dao) {
		
		this.dao = dao;
	}

	/**
	 * Méthode d'affichage de l'option lister pizzas.
	 * 
	 * @param Scanner
	 *				la réponse de l'utilisateur.
	 *
	 * @return Un boolean, true si tout c'est bien passé.						  			  - le prix est n�gatif.
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
