package dev.fr.pizzeria.model;

public class Categorie {

	private int id;
	private String name;
	
	public Categorie(int id) {
		super();
		this.id = id;
	};
	
	public Categorie(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}
	
	
}
