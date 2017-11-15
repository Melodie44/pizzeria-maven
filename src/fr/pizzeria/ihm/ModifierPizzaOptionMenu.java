package fr.pizzeria.ihm;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.OptionMenu;
import fr.pizzeria.model.Pizza;

/**
 * Classe de l'option pour modifier une pizza.
 * 
 * @author Maubois Mélodie
 * @version 1.0
 *
 */
public class ModifierPizzaOptionMenu extends OptionMenu{

	private PizzaDao dao;
	private List<Pizza> pizzas;
	
	/**
	 * Constructeur de création de l'option modifier une pizza.
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
	 * Méthode d'affichage de l'option modifier pizza.
	 * 
	 * @param Scanner
	 *				la réponse de l'utilisateur.
	 *
	 * @return Un boolean, true si tout c'est bien passé.
	 * 
	 * @throws UpdatePizzaException, si jamais : - le code n'existe pas.
	 * 							  			 
	 */
	@Override
	public boolean execute(Scanner scanner) throws UpdatePizzaException{
		
		System.out.println("Mise à jour d'une pizza");
		
		ListerPizzasOptionMenu liste = new ListerPizzasOptionMenu(dao, pizzas);
		liste.execute(scanner);
		
		System.out.println("Veuillez choisir la pizza à modifier (99 pour abandonner)");
		
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
			
			System.out.println("Veuillez saisir la categorie");
			System.out.println("1. Viande");
			System.out.println("2. Sans viande");
			System.out.println("3. Poisson");
			String categorie  = scanner.nextLine();
			
			CategoriePizza cate = null;
			switch(categorie) {
				
				case "1" : 
					
					cate = CategoriePizza.VIANDE;
					
					break;
					
				case "2" :
					
					cate = CategoriePizza.SANS_VIANDE;
					
					break;
					
				case "3" :
					
					cate = CategoriePizza.POISSON;
					
					break;
			}
			
			Pizza pizza = new Pizza(code, nom, Double.parseDouble(prix), cate);

			if(dao.updatePizza(action, pizza) == false) {
				
				throw new UpdatePizzaException("Erreur, la pizza à mettre à jour n'existe pas");
			}
		}
		
		return true;
	}
}
