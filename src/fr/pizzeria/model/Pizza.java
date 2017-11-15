package fr.pizzeria.model;

/**
 * Classe de création, gestion d'une pizza.
 * 
 * @author Maubois Mélodie
 * @version 1.0
 *
 */
public class Pizza {

	private int id;
	private String code;
	private String nom;
	private double prix;
	private CategoriePizza categorie;
	
	public Pizza(String code, String nom, double prix, CategoriePizza categorie) {
		this.id += 1;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categorie = categorie;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public CategoriePizza getCategorie() {
		return categorie;
	}

	public void setCategorie(CategoriePizza categorie) {
		this.categorie = categorie;
	}

	@Override
	public String toString() {
		
		String infos = code + " -> " + nom + " (" + prix + " €) catégorie " + categorie.getValue();
		
		return infos;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pizza other = (Pizza) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}
	
	

}
