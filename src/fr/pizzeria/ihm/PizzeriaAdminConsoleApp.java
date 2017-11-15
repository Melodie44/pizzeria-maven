package fr.pizzeria.ihm;

import java.util.Scanner;
import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Menu;
import fr.pizzeria.model.OptionMenu;
import fr.pizzeria.model.Pizza;

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
		Pizza pizza0 = new Pizza("PEP", "Pépéroni", 12.50);
		Pizza pizza1 = new Pizza("MAR", "Margherita", 14);
		Pizza pizza2 = new Pizza("REIN", "La Reine", 11.50);
		Pizza pizza3 = new Pizza("FRO", "La 4 fromages", 12.00);
		Pizza pizza4 = new Pizza("CAN", "La cannibale", 12.50);
		Pizza pizza5 = new Pizza("SAV", "La savoyarde", 13.00);
		Pizza pizza6 = new Pizza("ORI", "L'orientale", 13.50);
		Pizza pizza7 = new Pizza("IND", "L'Indienne", 14.00);
		
		// Création du tableau des pizzas
		Pizza[] tabPizzas = {
				pizza0,
				pizza1,
				pizza2,
				pizza3,
				pizza4,
				pizza5,
				pizza6,
				pizza7,
		};
	
		// Création du tableau des options
		OptionMenu[] actions = new OptionMenu[5]; 
		
		// Création des libellés pizza
		PizzaDao dao = new PizzaDao(tabPizzas);
		
		actions[0] = new ListerPizzasOptionMenu(dao, tabPizzas);
		actions[0].setLibelle("1. Lister les pizzas");
		actions[1] = new AjouterPizzaOptionMenu(dao, tabPizzas);
		actions[1].setLibelle("2. Ajouter une nouvelle pizza");
		actions[2] = new ModifierPizzaOptionMenu(dao, tabPizzas);
		actions[2].setLibelle("3. Mettre à jour une pizza");
		actions[3] = new SupprimerPizzaOptionMenu(dao, tabPizzas);
		actions[3].setLibelle("4. Supprimer une pizza");
		actions[4] = new ExitApplication();
		actions[4].setLibelle("99. Sortir");
		
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
					
					option = new ListerPizzasOptionMenu(dao, tabPizzas);
					
					try {
						option.execute(scanner);
					} catch (Exception e) {
						
						System.out.println(e.getMessage());
					}
					
					break;
					
				case "2" :

					option = new AjouterPizzaOptionMenu(dao, tabPizzas);

					try {
						option.execute(scanner);
					} catch (StockageException e) {
						
						System.out.println(e.getMessage());
					}
	
					break;
					
				case "3" :
					
					option = new ModifierPizzaOptionMenu(dao, tabPizzas);
					
					try {
						option.execute(scanner);
					} catch (Exception e) {
						
						System.out.println(e.getMessage());
					}
					
					break;
				
				case "4" :
					
					option = new SupprimerPizzaOptionMenu(dao, tabPizzas);
					
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
