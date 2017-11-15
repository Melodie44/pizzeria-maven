package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;
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
		
		if(code.trim().length() > 4) {
			
			throw new SavePizzaException("Erreur, le code pizza doit être inférieur ou égale à 4");
		}
		
		if(Double.parseDouble(prix) < 0) {
			
			throw new SavePizzaException("Erreur, le prix de la pizza ne doit pas être négatif");
			
		}
		
		Pizza newPizza = new Pizza(code, nom, Double.parseDouble(prix));
		
		dao.saveNewPizza(newPizza);
		
		return true;
	}
}
