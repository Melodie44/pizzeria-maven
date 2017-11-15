package fr.pizzeria.model;

import java.util.Scanner;

import fr.pizzeria.exception.StockageException;

/**
 * Classe de cr�ation, gestion d'une option.
 * 
 * @author Maubois M�lodie
 * @ version 1.0
 *
 */
public abstract class OptionMenu {
	
	public String libelle;

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	public abstract boolean execute(Scanner scanner) throws StockageException;

}
