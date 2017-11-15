package fr.pizzeria.ihm;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.model.OptionMenu;
import fr.pizzeria.model.Pizza;

/**
 * Classe de l'option pour lister les pizzas.
 * 
 * @author Maubois Mélodie
 * @version 1.0
 *
 */
public class ListerPizzasOptionMenu extends OptionMenu{
	
	private PizzaDao dao;
	private List<Pizza> pizzas;
	
	/**
	 * Constructeur de création de l'option lister les pizzas.
	 * 
	 * @param dao
	 * 			Une instance de classe PizzaDao.
	 * 
	 * @param tabPizzas
	 * 				  Le tableau contenant les pizzas.
	 */
	public ListerPizzasOptionMenu(PizzaDao dao, List<Pizza> pizzas) {
		
		this.dao = dao;
		this.pizzas = pizzas;
	}

	/**
	 * Méthode d'affichage de l'option lister pizzas.
	 * 
	 * @param Scanner
	 *				la réponse de l'utilisateur.
	 *
	 * @return Un boolean, true si tout c'est bien passé.						  			  - le prix est négatif.
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
