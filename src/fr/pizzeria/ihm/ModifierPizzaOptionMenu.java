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
		
		System.out.println("Mise � jour d'une pizza");
		
		ListerPizzasOptionMenu liste = new ListerPizzasOptionMenu(dao, tabPizzas);
		liste.execute(scanner);
		
		System.out.println("Veuillez choisir la pizza � modifier.");
		System.out.println("(99 pour abandonner)");
		
		String action  = scanner.nextLine();
		
		if(action.equals("99")) {
			
			ExitApplication exit = new ExitApplication();
			exit.execute(scanner);
			
		}else {
			
			Pizza pizza = new Pizza(action, "", 0);
			
			dao.updatePizza(action, pizza);
			
		}
		
		return true;
	}
}
