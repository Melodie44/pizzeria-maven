package fr.pizzeria.dao;

import fr.pizzeria.model.Pizza;

/**
 * Interface des méthodes actions du menu.
 * 
 * @author Maubois Mélodie
 * @version 1.0
 *
 */
public interface IPizzaDao {
	
	Pizza[] findAllPizzas();
	boolean saveNewPizza(Pizza pizza);
	boolean updatePizza(String codePizza, Pizza pizza);
	boolean deletePizza(String codePizza);

}
