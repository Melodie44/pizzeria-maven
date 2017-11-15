package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.model.Pizza;

/**
 * - La classe qui contient les traitements
 * des fonctionnalit�s de l'application.
 * - La classe impl�mente l'interface IPizzaDao 
 * des m�thodes actions de l'application.
 * 
 * @author Maubois M�lodie
 * @version 1.0
 * @see IPizzaDao
 * 
 */
public class PizzaDao implements IPizzaDao{
	
	private List<Pizza> pizzas;

	public PizzaDao(List<Pizza> pizzas) {
		
		this.pizzas = pizzas;
	}

	/**
	 * Permet de r�cup�rer le tableau des pizzas.
	 * 
	 * @return Le tableau de pizzas.
	 */
	@Override
	public ArrayList<Pizza> findAllPizzas() {

		return (ArrayList<Pizza>) this.pizzas;
	}
	
	/**
	 * Permet de souvegarder la pizza renseign�e.
	 * 
	 * @param pizza
	 * 			  La pizza � sauvegarder.
	 * 
	 * @return un boolean, true si la pizza a �t� sauvegard�e.
	 */
	@Override
	public boolean saveNewPizza(Pizza pizza) {
		
		this.pizzas.add(pizza);
		
		return true;
	}
	
	/**
	 * Permet de mettre � jour les infos d'une pizza.
	 * 
	 * @param pizza
	 * 			  La pizza � mettre � jour.
	 * 
	 * @param codePizza
	 * 				  Le code de la pizza � mettre � jour.
	 * 
	 * @return un boolean, true la pizza a �t� mise � jour.
	 */
	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) {

		for(Pizza pizzaElt : this.pizzas) {
			
			if(codePizza.equals(pizzaElt.getCode())) {
				
				pizzaElt.setCode(pizza.getCode());
				pizzaElt.setNom(pizza.getNom());
				pizzaElt.setPrix(pizza.getPrix());
				pizzaElt.setCategorie(pizza.getCategorie());
				
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Permet de supprimer une pizza.
	 * 
	 * @param codePizza
	 * 				  Le code de la pizza � supprimer.
	 * 
	 * @return un boolean, true si la pizza a �t� supprim�e.
	 */
	@Override
	public boolean deletePizza(String codePizza) {
		
		for(Pizza pizzaElt : this.pizzas) {
			
			if(codePizza.equals(pizzaElt.getCode())) {
				
				pizzas.remove(pizzaElt);
				
				return true;	
			}
		}
		
		return false;
	}

}
