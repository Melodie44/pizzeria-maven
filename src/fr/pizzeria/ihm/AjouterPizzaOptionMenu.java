package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.OptionMenu;
import fr.pizzeria.model.Pizza;

public class AjouterPizzaOptionMenu extends OptionMenu{
	
	private PizzaDao dao;
	private Pizza[] tabPizzas;
	
	public AjouterPizzaOptionMenu(PizzaDao dao, Pizza[] tabPizzas) {
		
		this.dao = dao;
		this.tabPizzas = tabPizzas;
	}

	@Override
	public boolean execute(Scanner scanner) throws SavePizzaException{
		
		System.out.println("Veuillez saisir le code");
		String code  = scanner.nextLine();
		
		System.out.println("Veuillez saisir le nom (sans espace)");
		String nom  = scanner.nextLine();
		
		System.out.println("Veuillez saisir le prix");
		String prix  = scanner.nextLine();
		
		Pizza newPizza = new Pizza(code, nom, Double.parseDouble(prix));
		
		if(dao.saveNewPizza(newPizza) == false) {
			
			throw new SavePizzaException("Erreur, la sauvegarde de la pizza a �chou�e");
			
		};
		
		return true;
	}
}
