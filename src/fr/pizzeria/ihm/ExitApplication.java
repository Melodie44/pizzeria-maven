package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.model.OptionMenu;

/**
 * Classe de l'option pour quitter l'application.
 * 
 * @author Maubois M�lodie
 * @version 1.0
 *
 */
public class ExitApplication extends OptionMenu{

	/**
	 * M�thode d'affichage de l'option exit application.
	 * 
	 * @param Scanner
	 *				la r�ponse de l'utilisateur.
	 *
	 * @return Un boolean, true si tout c'est bien pass�.
	 */
	public boolean execute(Scanner scanner) {
		
		System.out.println("Aurevoir ");
		
		System.exit(0);
		
		return true;
	}
}
