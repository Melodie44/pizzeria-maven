package dev.fr.pizzeria.ihm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import dev.fr.pizzeria.dao.PizzaDao;
import dev.fr.pizzeria.dao.jdbc.PizzaDaoBase;
import dev.fr.pizzeria.exception.StockageException;
import dev.fr.pizzeria.ihm.AjouterPizzaOptionMenu;
import dev.fr.pizzeria.ihm.ExitApplication;
import dev.fr.pizzeria.ihm.ListerPizzasOptionMenu;
import dev.fr.pizzeria.ihm.ModifierPizzaOptionMenu;
import dev.fr.pizzeria.ihm.SupprimerPizzaOptionMenu;
import dev.fr.pizzeria.model.CategoriePizza;
import dev.fr.pizzeria.model.Menu;
import dev.fr.pizzeria.model.OptionMenu;
import dev.fr.pizzeria.model.Pizza;

/**
 * Classe de lancement de l'application.
 * 
 * @author Maubois Mélodie
 * @version 1.0
 *
 */
public class PizzeriaAdminConsoleApp {
	
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		boolean exit = false;
		int index = 7;
		String code = new String();
		String nom = new String();
		String prix = new String();
		
		// Création des pizzas
		/*Pizza pizza0 = new Pizza("PEP", "P�p�roni", 12.50, CategoriePizza.SANS_VIANDE);
		Pizza pizza1 = new Pizza("MAR", "Margherita", 14, CategoriePizza.VIANDE);
		Pizza pizza2 = new Pizza("REIN", "La Reine", 11.50, CategoriePizza.VIANDE);
		Pizza pizza3 = new Pizza("FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE);
		Pizza pizza4 = new Pizza("CAN", "La cannibale", 12.50, CategoriePizza.VIANDE);
		Pizza pizza5 = new Pizza("SAV", "La savoyarde", 13.00, CategoriePizza.SANS_VIANDE);
		Pizza pizza6 = new Pizza("ORI", "L'orientale", 13.50, CategoriePizza.VIANDE);
		Pizza pizza7 = new Pizza("IND", "L'Indienne", 14.00, CategoriePizza.VIANDE);*/
		
		// Création de la liste des pizzas
		List<Pizza> pizzas = new ArrayList<Pizza>();
		/*pizzas.add(pizza0);
		pizzas.add(pizza1);
		pizzas.add(pizza2);
		pizzas.add(pizza3);
		pizzas.add(pizza4);
		pizzas.add(pizza5);
		pizzas.add(pizza6);
		pizzas.add(pizza7);*/
	
		// Création du tableau des options
		Map<Integer, OptionMenu> actions = new HashMap<Integer, OptionMenu>(); 
		
		// Appel au DAO (connection BDD)
		PizzaDaoBase dao = new PizzaDaoBase();
		
		actions.put(1, new ListerPizzasOptionMenu(dao));
		actions.get(1).setLibelle("1. Lister les pizzas");
		actions.put(2, new AjouterPizzaOptionMenu(dao));
		actions.get(2).setLibelle("2. Ajouter une nouvelle pizza");
		actions.put(3, new ModifierPizzaOptionMenu(dao));
		actions.get(3).setLibelle("3. Mettre à jour une pizza");
		actions.put(4, new SupprimerPizzaOptionMenu(dao));
		actions.get(4).setLibelle("4. Supprimer une pizza");
		actions.put(5, new ExitApplication());
		actions.get(5).setLibelle("99. Sortir");
		
		// Création du menu
		String titre = "\n***** Pizzeria Administration *****";
		Menu menu = new Menu(titre, actions);

		// Déroulement programme
		do {
			menu.afficher();
			
			String action = scanner.nextLine();
			
			OptionMenu option;
			
			switch(action) {
			
				case "1" :
					
					option = new ListerPizzasOptionMenu(dao);
					
					try {
						option.execute(scanner);
					} catch (Exception e) {
						
						System.out.println(e.getMessage());
					}
					
					break;
					
				case "2" :

					option = new AjouterPizzaOptionMenu(dao);

					try {
						option.execute(scanner);
					} catch (StockageException e) {
						
						System.out.println(e.getMessage());
					}
	
					break;
					
				case "3" :
					
					option = new ModifierPizzaOptionMenu(dao);
					
					try {
						option.execute(scanner);
					} catch (Exception e) {
						
						System.out.println(e.getMessage());
					}
					
					break;
				
				case "4" :
					
					option = new SupprimerPizzaOptionMenu(dao);
					
					try {
						option.execute(scanner);
					} catch (Exception e) {
						
						System.out.println(e.getMessage());
					}
					
					break;
				
				case "99" :
					
					option = new ExitApplication();
					
					try {
						option.execute(scanner);
					} catch (Exception e) {
						
						System.out.println(e.getMessage());
					}
					
					exit = true;
					
					break;		
			}
		
		}while(exit != true);

	}

}