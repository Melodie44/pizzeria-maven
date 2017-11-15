package fr.pizzeria.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Classe de création, gestion du menu.
 * 
 * @author Maubois Mélodie
 * @version 1.0
 *
 */
public class Menu {
	
	String titre;
	 Map<Integer, OptionMenu> actions;
	
	public Menu(String titre, Map<Integer, OptionMenu> actions) {
		
		this.titre = titre;
		this.actions = actions;
	}
	
	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public  HashMap<Integer, OptionMenu> getActions() {
		return (HashMap<Integer, OptionMenu>) actions;
	}

	public void setActions(Map<Integer, OptionMenu> actions) {
		this.actions = actions;
	}
	
	public void createMenu() {
		
		
		
	}
	
	public void afficher() {
		
		System.out.println(this.getTitre());
		
		Iterator iterator = actions.values().iterator();
		while(iterator.hasNext()) {
			
			OptionMenu option = (OptionMenu) iterator.next();
			
			System.out.println(option.getLibelle());
			
		}
		
	}

}
