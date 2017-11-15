package fr.pizzeria.dao;

import java.util.ArrayList;

import fr.pizzeria.model.Pizza;

/**
 * Interface des m�thodes actions du menu.
 * 
 * @author Maubois M�lodie
 * @version 1.0
 *
 */
public interface IPizzaDao {
	
	ArrayList<Pizza> findAllPizzas();
	boolean saveNewPizza(Pizza pizza);
	boolean updatePizza(String codePizza, Pizza pizza);
	boolean deletePizza(String codePizza);

}
