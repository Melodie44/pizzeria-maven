package fr.pizzeria.ihm;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.OptionMenu;
import fr.pizzeria.model.Pizza;

/**
 * Classe de l'option pour ajouter une pizza.
 * 
 * @author Maubois M�lodie
 * @version 1.0
 *
 */
public class AjouterPizzaOptionMenu extends OptionMenu{
	
	private PizzaDao dao;
	private List<Pizza> pizzas;
	
	/**
	 * Constructeur de cr�ation de l'option ajouter une pizza.
	 * 
	 * @param dao
	 * 			Une instance de classe PizzaDao.
	 * 
	 * @param tabPizzas
	 * 				  Le tableau contenant les pizzas.
	 */
	public AjouterPizzaOptionMenu(PizzaDao dao, List<Pizza> pizzas) {
		
		this.dao = dao;
		this.pizzas = pizzas;
	}

	/**
	 * M�thode d'affichage de l'option ajouter pizza.
	 * 
	 * @param Scanner
	 *				la r�ponse de l'utilisateur.
	 *
	 * @return Un boolean, true si tout c'est bien pass�.
	 * 
	 * @throws SavePizzaException, si jamais : - le code est trop grand.
	 * 							  			  - le prix est n�gatif.
	 */
	@Override
	public boolean execute(Scanner scanner) throws SavePizzaException{

		System.out.println("Veuillez saisir le code");
		String code  = scanner.nextLine();

		System.out.println("Veuillez saisir le nom (sans espace)");
		String nom  = scanner.nextLine();
		
		System.out.println("Veuillez saisir le prix");
		String prix  = scanner.nextLine();
		
		if(code.trim().length() > 4) {
			
			throw new SavePizzaException("Erreur, le code pizza doit �tre inf�rieur ou �gale � 4");
		}
		
		if(Double.parseDouble(prix) < 0) {
			
			throw new SavePizzaException("Erreur, le prix de la pizza ne doit pas �tre n�gatif");
			
		}
		
		Pizza newPizza = new Pizza(code, nom, Double.parseDouble(prix));
		
		dao.saveNewPizza(newPizza);
		
		return true;
	}
}
