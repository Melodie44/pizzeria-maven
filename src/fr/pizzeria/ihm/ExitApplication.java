package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.model.OptionMenu;

public class ExitApplication extends OptionMenu{

	public boolean execute(Scanner scanner) {
		
		System.out.println("Aurevoir ");
		
		System.exit(0);
		
		return true;
	}
}
