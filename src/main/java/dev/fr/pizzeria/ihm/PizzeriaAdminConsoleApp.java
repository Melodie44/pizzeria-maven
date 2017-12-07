package dev.fr.pizzeria.ihm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import dev.fr.pizzeria.dao.jdbc.PizzaDaoBase;
import dev.fr.pizzeria.exception.StockageException;
import dev.fr.pizzeria.ihm.AjouterPizzaOptionMenu;
import dev.fr.pizzeria.ihm.ExitApplication;
import dev.fr.pizzeria.ihm.ListerPizzasOptionMenu;
import dev.fr.pizzeria.ihm.ModifierPizzaOptionMenu;
import dev.fr.pizzeria.ihm.SupprimerPizzaOptionMenu;
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
