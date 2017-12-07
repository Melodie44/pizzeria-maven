package dev.fr.pizzeria.ihm;

import java.util.List;
import java.util.Scanner;

import dev.fr.pizzeria.dao.PizzaDao;
import dev.fr.pizzeria.dao.jdbc.PizzaDaoBase;
import dev.fr.pizzeria.exception.UpdatePizzaException;
import dev.fr.pizzeria.ihm.ExitApplication;
import dev.fr.pizzeria.ihm.ListerPizzasOptionMenu;
import dev.fr.pizzeria.model.Categorie;
import dev.fr.pizzeria.model.CategoriePizza;
import dev.fr.pizzeria.model.OptionMenu;
import dev.fr.pizzeria.model.Pizza;

/**
 * Classe de l'option pour modifier une pizza.
 * 
 * @author Maubois Mélodie
 * @version 1.0
 *
 */
public class ModifierPizzaOptionMenu extends OptionMenu{

	private PizzaDaoBase dao;
	
	/**
	 * Constructeur de création de l'option modifier une pizza.
	 * 
	 * @param dao
	 * 			Une instance de classe PizzaDao.
	 * 
	 * @param tabPizzas
	 * 				  Le tableau contenant les pizzas.
	 */
	public ModifierPizzaOptionMenu(PizzaDaoBase dao) {
		
		this.dao = dao;
	}

	/**
	 * Méthode d'affichage de l'option modifier pizza.
	 * 
	 * @param Scanner
	 *				la r�ponse de l'utilisateur.
	 *
	 * @return Un boolean, true si tout c'est bien passé.
	 * 
	 * @throws UpdatePizzaException, si jamais : - le code n'existe pas.
	 * 							  			 
	 */
	@Override
	public boolean execute(Scanner scanner) throws UpdatePizzaException{
		
		System.out.println("Mise à jour d'une pizza");
		
		ListerPizzasOptionMenu liste = new ListerPizzasOptionMenu(dao);
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
			
			Categorie cate = null;
			switch(categorie) {
				
				case "1" : 
					cate = new Categorie(1, "Viande");
					
					break;
					
				case "2" :
					
					cate = new Categorie(2, "Sans Viande");
					
					break;
					
				case "3" :
					
					cate = new Categorie(3, "Poisson");
					
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
