package dev.fr.pizzeria.ihm;

import java.util.Scanner;

import dev.fr.pizzeria.model.OptionMenu;

/**
 * Classe de l'option pour quitter l'application.
 * 
 * @author Maubois Mélodie
 * @version 1.0
 *
 */
public class ExitApplication extends OptionMenu{

	/**
	 * Méthode d'affichage de l'option exit application.
	 * 
	 * @param Scanner
	 *				la réponse de l'utilisateur.
	 *
	 * @return Un boolean, true si tout c'est bien passé.
	 */
	@Override
	public boolean execute(Scanner scanner) {
		
		System.out.println("Aurevoir ");
		
		System.exit(0);
		
		return true;
	}
}
