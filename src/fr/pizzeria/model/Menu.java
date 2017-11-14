package fr.pizzeria.model;

public class Menu {
	
	String titre;
	OptionMenu[] actions;
	
	public Menu(String titre, OptionMenu[] actions) {
		
		this.titre = titre;
		this.actions = actions;
	}
	
	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public OptionMenu[] getActions() {
		return actions;
	}

	public void setActions(OptionMenu[] actions) {
		this.actions = actions;
	}
	
	public void createMenu() {
		
		
		
	}
	
	public void afficher() {
		
		System.out.println(this.getTitre());
		
		for(OptionMenu action : this.actions) {
			
			System.out.println("\n" + action.getLibelle());
			
		}
		
	}

}
