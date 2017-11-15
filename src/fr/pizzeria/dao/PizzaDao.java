package fr.pizzeria.dao;

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
	
	private Pizza[] tabPizzas;

	public PizzaDao(Pizza[] tabPizzas) {
		
		this.tabPizzas = tabPizzas;
	}

	/**
	 * Permet de récupérer le tableau des pizzas.
	 * 
	 * @return Le tableau de pizzas.
	 */
	@Override
	public Pizza[] findAllPizzas() {

		return this.tabPizzas;
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
		
		this.tabPizzas = findAllPizzas();
		
		Pizza[] tabPizzas2 = new Pizza[tabPizzas.length+1];
		
		for(int i=0; i<tabPizzas.length; i++) {

			if(tabPizzas[i].getCode() != null) {
				
				tabPizzas2[i] = tabPizzas[i];

			}else {
				
				tabPizzas[i] = pizza;
				
				break;
			}
		}
		
		tabPizzas2[tabPizzas2.length-1] = pizza;
		
		this.tabPizzas = tabPizzas2;
		
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

		for(Pizza pizzaTab : this.tabPizzas) {
			
			if(codePizza.equals(pizzaTab.getCode())) {
				
				pizzaTab.setCode(pizza.getCode());
				pizzaTab.setNom(pizza.getNom());
				pizzaTab.setPrix(pizza.getPrix());
				
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
		
		for(Pizza pizza : this.tabPizzas) {
			
			if(codePizza.equals(pizza.getCode())) {
				
				pizza.setCode(null);
				pizza.setNom(null);
				pizza.setPrix(0);
				
				return true;	
			}
		}
		
		return false;
	}

}
