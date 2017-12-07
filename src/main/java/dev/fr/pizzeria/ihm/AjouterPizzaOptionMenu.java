package dev.fr.pizzeria.ihm;

import java.util.List;
import java.util.Scanner;

import dev.fr.pizzeria.dao.jdbc.PizzaDaoBase;
import dev.fr.pizzeria.exception.SavePizzaException;
import dev.fr.pizzeria.model.Categorie;
import dev.fr.pizzeria.model.OptionMenu;
import dev.fr.pizzeria.model.Pizza;

/**
 * Classe de l'option pour ajouter une pizza.
 * 
 * @author Maubois Mélodie
 * @version 1.0
 *
 */
public class AjouterPizzaOptionMenu extends OptionMenu{
	
	private PizzaDaoBase dao;
	private List<Pizza> pizzas;
	
	/**
	 * Constructeur de création de l'option ajouter une pizza.
	 * 
	 * @param dao
	 * 			Une instance de classe PizzaDao.
	 * 
	 * @param tabPizzas
	 * 				  Le tableau contenant les pizzas.
	 */
	public AjouterPizzaOptionMenu(PizzaDaoBase dao) {
		
		this.dao = dao;
		this.pizzas = pizzas;
	}

	/**
	 * Méthode d'affichage de l'option ajouter pizza.
	 * 
	 * @param Scanner
	 *				la réponse de l'utilisateur.
	 *
	 * @return Un boolean, true si tout c'est bien passé.
	 * 
	 * @throws SavePizzaException, si jamais : - le code est trop grand.
	 * 							  			  - le prix est négatif.
	 */
	@Override
	public boolean execute(Scanner scanner) throws SavePizzaException{

		System.out.println("Veuillez saisir le code");
		String code  = scanner.nextLine();

		System.out.println("Veuillez saisir le nom (sans espace)");
		String nom  = scanner.nextLine();
		
		System.out.println("Veuillez saisir le prix");
		String prix  = scanner.nextLine();
		
		System.out.println("Veuillez saisir la categorie :");
		System.out.println("1. Viande");
		System.out.println("2. Sans viande");
		System.out.println("3. Poisson");
		
		String categorie  = scanner.nextLine();
		
		if(code.trim().length() > 4) {
			
			throw new SavePizzaException("Erreur, le code pizza doit �tre inf�rieur ou �gale � 4");
		}
		
		if(Double.parseDouble(prix) < 0) {
			
			throw new SavePizzaException("Erreur, le prix de la pizza ne doit pas �tre n�gatif");
			
		}
		
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
		
		Pizza newPizza = new Pizza(code, nom, Double.parseDouble(prix), cate);
		
		dao.saveNewPizza(newPizza);
		
		return true;
	}
}
