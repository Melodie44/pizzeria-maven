package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.OptionMenu;
import fr.pizzeria.model.Pizza;

public class SupprimerPizzaOptionMenu extends OptionMenu{

	private PizzaDao dao;
	private Pizza[] tabPizzas;
	
	public SupprimerPizzaOptionMenu(PizzaDao dao, Pizza[] tabPizzas) {
		
		this.dao = dao;
		this.tabPizzas = tabPizzas;
	}

	@Override
	public boolean execute(Scanner scanner) throws DeletePizzaException{
		
		System.out.println("Veuillez saisir le code");
		String code  = scanner.nextLine();
		
		if(dao.deletePizza(code) == false) {
			
			throw new DeletePizzaException("Erreur, la pizza à supprimer n'existe pas");
			
		};
		
		return true;
	}
}
