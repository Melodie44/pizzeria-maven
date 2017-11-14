package fr.pizzeria.dao;

import fr.pizzeria.model.Pizza;

public class PizzaDao implements IPizzaDao{
	
	private Pizza[] tabPizzas;

	public PizzaDao(Pizza[] tabPizzas) {
		
		this.tabPizzas = tabPizzas;
	}

	@Override
	public Pizza[] findAllPizzas() {

		return this.tabPizzas;
	}

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

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) {

		for(Pizza pizzaTab : this.tabPizzas) {
			
			if(pizza.getCode().equals(pizzaTab.getCode())) {
				
				pizzaTab.setCode(pizza.getCode());
				pizzaTab.setNom(pizza.getCode());
				pizzaTab.setPrix(pizza.getPrix());
				
				break;
			}
		}
		
		return true;
	}

	@Override
	public boolean deletePizza(String codePizza) {
		
		for(Pizza pizza : this.tabPizzas) {

			Pizza newPizza = new Pizza(codePizza, null, 0);
			
			if(newPizza.getCode().equals(pizza.getCode())) {
				
				pizza.setCode(null);
				pizza.setNom(null);
				pizza.setPrix(0);
				
				break;	
			}
		}
		
		return true;
	}

}
