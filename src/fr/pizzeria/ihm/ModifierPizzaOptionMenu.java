package fr.pizzeria.ihm;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.OptionMenu;
import fr.pizzeria.model.Pizza;

/**
 * Classe de l'option pour modifier une pizza.
 * 
 * @author Maubois M�lodie
 * @version 1.0
 *
 */
public class ModifierPizzaOptionMenu extends OptionMenu{

	private PizzaDao dao;
	private List<Pizza> pizzas;
	
	/**
	 * Constructeur de cr�ation de l'option modifier une pizza.
	 * 
	 * @param dao
	 * 			Une instance de classe PizzaDao.
	 * 
	 * @param tabPizzas
	 * 				  Le tableau contenant les pizzas.
	 */
	public ModifierPizzaOptionMenu(PizzaDao dao, List<Pizza> pizzas) {
		
		this.dao = dao;
		this.pizzas = pizzas;
	}

	/**
	 * M�thode d'affichage de l'option modifier pizza.
	 * 
	 * @param Scanner
	 *				la r�ponse de l'utilisateur.
	 *
	 * @return Un boolean, true si tout c'est bien pass�.
	 * 
	 * @throws UpdatePizzaException, si jamais : - le code n'existe pas.
	 * 							  			 
	 */
	@Override
	public boolean execute(Scanner scanner) throws UpdatePizzaException{
		
		System.out.println("Mise � jour d'une pizza");
		
		ListerPizzasOptionMenu liste = new ListerPizzasOptionMenu(dao, pizzas);
		liste.execute(scanner);
		
		System.out.println("Veuillez choisir la pizza � modifier (99 pour abandonner)");
		
		String action  = scanner.nextLine();
		
		if(action.equals("99")) {
			
			ExitApplication exit = new ExitApplication();
			exit.execute(scanner);
			
		}else {
			
			System.out.println("Veuillez saisir le code");
			String code  = scanner.nextLine();
			
			System.out.println("Veuillez saisir le nom (sans espace)");
			String nom  = scanner.nextLine();
			
			System.out.println("Veuillez saisir le prix");
			String prix  = scanner.nextLine();
			
			Pizza pizza = new Pizza(code, nom, Double.parseDouble(prix));

			if(dao.updatePizza(action, pizza) == false) {
				
				throw new UpdatePizzaException("Erreur, la pizza � mettre � jour n'existe pas");
			}
		}
		
		return true;
	}
}
