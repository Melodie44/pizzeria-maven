package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.model.Pizza;

/**
 * - La classe qui contient les traitements
 * des fonctionnalités de l'application.
 * - La classe implémente l'interface IPizzaDao 
 * des méthodes actions de l'application.
 * 
 * @author Maubois Mélodie
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
	 * Permet de récupérer le tableau des pizzas.
	 * 
	 * @return Le tableau de pizzas.
	 */
	@Override
	public ArrayList<Pizza> findAllPizzas() {

		return (ArrayList<Pizza>) this.pizzas;
	}
	
	/**
	 * Permet de souvegarder la pizza renseignée.
	 * 
	 * @param pizza
	 * 			  La pizza à sauvegarder.
	 * 
	 * @return un boolean, true si la pizza a été sauvegardée.
	 */
	@Override
	public boolean saveNewPizza(Pizza pizza) {
		
		this.pizzas.add(pizza);
		
		return true;
	}
	
	/**
	 * Permet de mettre à jour les infos d'une pizza.
	 * 
	 * @param pizza
	 * 			  La pizza à mettre à jour.
	 * 
	 * @param codePizza
	 * 				  Le code de la pizza à mettre à jour.
	 * 
	 * @return un boolean, true la pizza a été mise à jour.
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
	 * 				  Le code de la pizza à supprimer.
	 * 
	 * @return un boolean, true si la pizza a été supprimée.
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
