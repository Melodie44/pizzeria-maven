package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.model.OptionMenu;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaOptionMenu extends OptionMenu{

	private PizzaDao dao;
	private Pizza[] tabPizzas;
	
	public ModifierPizzaOptionMenu(PizzaDao dao, Pizza[] tabPizzas) {
		
		this.dao = dao;
		this.tabPizzas = tabPizzas;
	}

	@Override
	public boolean execute(Scanner scanner) {
		
		System.out.println("Mise à jour d'une pizza");
		
		ListerPizzasOptionMenu liste = new ListerPizzasOptionMenu(dao, tabPizzas);
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
			
			Pizza pizza = new Pizza(code, nom, Double.parseDouble(prix));

			dao.updatePizza(action, pizza);
			
		}
		
		return true;
	}
}
