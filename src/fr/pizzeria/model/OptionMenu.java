package fr.pizzeria.model;

import java.util.Scanner;

public abstract class OptionMenu {
	
	public String libelle;

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	public abstract boolean execute(Scanner scanner);

}
