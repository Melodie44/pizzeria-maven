

import java.util.Arrays;
import java.util.Scanner;
import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {
	
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		boolean exit = false;
		int index = 7;
		String code = new String();
		String nom = new String();
		String prix = new String();
		
		Pizza pizza0 = new Pizza("PEP", "Pépéroni", 12.50);
		Pizza pizza1 = new Pizza("MAR", "Margherita", 14);
		Pizza pizza2 = new Pizza("REIN", "La Reine", 11.50);
		Pizza pizza3 = new Pizza("FRO", "La 4 fromages", 12.00);
		Pizza pizza4 = new Pizza("CAN", "La cannibale", 12.50);
		Pizza pizza5 = new Pizza("SAV", "La savoyarde", 13.00);
		Pizza pizza6 = new Pizza("ORI", "L'orientale", 13.50);
		Pizza pizza7 = new Pizza("IND", "L'Indienne", 14.00);
		
		Pizza[] tabPizzas = {
				pizza0,
				pizza1,
				pizza2,
				pizza3,
				pizza4,
				pizza5,
				pizza6,
				pizza7,
		};

		do {
			menu();

			String action  = scanner.nextLine();
			
			switch(action) {
			
				case "1" :
					System.out.println("Liste des pizzas");
					
					affichePizzas(tabPizzas);
					
					break;
					
				case "2" :

					Pizza[] tabPizzas2 = new Pizza[tabPizzas.length+1];
					
					for(int i=0; i<tabPizzas.length; i++) {

						if(tabPizzas[i].getCode() != null) {
							
							tabPizzas2[i] = tabPizzas[i];

						}else {
							
							tabPizzas[i] = createPizza();
							
							break;
						}
					}
					
					tabPizzas2[tabPizzas2.length-1] = createPizza();
					
					tabPizzas = tabPizzas2;
	
					break;
					
				case "3" :
					
					System.out.println("Mise à jour d'une pizza");
					
					affichePizzas(tabPizzas);
					
					System.out.println("Veuillez choisir la pizza à modifier.");
					System.out.println("(99 pour abandonner)");
					
					action  = scanner.nextLine();
					
					if(action.equals("99")) {
						
						exitApp(true);
						
					}else {
						
						updatePizza(tabPizzas);
						
					}
					
					break;
				
				case "4" :
					
					System.out.println("Suppression d'une pizza");
					
					affichePizzas(tabPizzas);
					
					System.out.println("Veuillez choisir la pizza à supprimer.");
					System.out.println("(99 pour abandonner)");
					
					action  = scanner.nextLine();
					
					if(action.equals("99")) {
						
						exitApp(true);
						
					}else {
						
						deletePizza(tabPizzas);
						
					}
					
					break;
				
				case "99" :
					exitApp(true);
					break;
						
			}
		
		}while(exit != true);

	}
	
	public static void menu() {
		System.out.println("\n***** Pizzeria Administration *****");
		System.out.println("1. Listez les pizzas");
		System.out.println("2. Ajouter une nouvelle pizza");
		System.out.println("3. Mettre à jour une pizza");
		System.out.println("4. Supprimer une pizza");
		System.out.println("99. Sortir");
	
	}
	
	public static void affichePizzas(Pizza[] tab) {
		
		for(Pizza pizza : tab) {
			
			if(pizza.getCode() != null){
			
				System.out.println(pizza.toString());
			}
		}
		
	}
	
	public static Pizza createPizza() {
		
		System.out.println("Veuillez saisir le code");
		String code  = scanner.nextLine();
		
		System.out.println("Veuillez saisir le nom (sans espace)");
		String nom  = scanner.nextLine();
		
		System.out.println("Veuillez saisir le prix");
		String prix  = scanner.nextLine();
		
		Pizza newPizza = new Pizza(code, nom, Double.parseDouble(prix));
		
		return newPizza;
	}
	
	public static void updatePizza(Pizza[] tabPizzas) {
			
		for(Pizza pizza : tabPizzas) {
			
			Pizza newPizza = createPizza();
			
			if(newPizza.getCode().equals(pizza.getCode())) {
				
				pizza.setCode(newPizza.getCode());
				pizza.setNom(newPizza.getCode());
				pizza.setPrix(newPizza.getPrix());
				
				return ;
				
			}
		}
	}
	
	public static void deletePizza(Pizza[] tabPizzas) {
		
		System.out.println("Veuillez saisir le code");
		String code  = scanner.nextLine();
		
		for(Pizza pizza : tabPizzas) {

			Pizza newPizza = new Pizza(code, null, 0);
			
			if(newPizza.getCode().equals(pizza.getCode())) {
				
				pizza.setCode(null);
				pizza.setNom(null);
				pizza.setPrix(0);
				
				return ;
				
			}
		}
	}
	
	public static void exitApp(boolean exit) {
		
		System.out.println("Aurevoir ");
		exit = true;
		
	}

}
