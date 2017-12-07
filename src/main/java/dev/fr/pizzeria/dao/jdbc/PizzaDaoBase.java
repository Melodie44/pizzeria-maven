package dev.fr.pizzeria.dao.jdbc;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import dev.fr.pizzeria.dao.IPizzaDao;
import dev.fr.pizzeria.model.Categorie;
import dev.fr.pizzeria.model.Pizza;

public class PizzaDaoBase implements IPizzaDao{
	
	static ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
	
	static {
				
		try {
			Class.forName(bundle.getString("database.driver"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public ArrayList<Pizza> findAllPizzas(){
		
		Connection conn = null;
		Statement stat = null;
		try {
			conn = DriverManager.getConnection(bundle.getString("database.pizzeria.url"), bundle.getString("database.pizzeria.user"), bundle.getString("database.pizzeria.password"));
			conn.setAutoCommit(false);

			stat = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
		
		String query = "SELECT * FROM pizza";
		ResultSet resultats = null;
		try {
			resultats = stat.executeQuery(query);
		
			while(resultats.next()) {
				
				Integer id = resultats.getInt("ID");
				String code = resultats.getString("CODE");
				String name = resultats.getString("NOM");
				BigDecimal price = resultats.getBigDecimal("PRIX");
				Integer idCategorie = resultats.getInt("ID_CATEGORIE");
				
				Categorie cate = null;
				switch(idCategorie) {
					
					case 1 : 
						cate = new Categorie(1, "Viande");
						
						break;
						
					case 2 :
						
						cate = new Categorie(2, "Sans Viande");
						
						break;
						
					case 3 :
						
						cate = new Categorie(3, "Poisson");
						
						break;
				}
				
				Pizza pizza = new Pizza(id, code, name, price.doubleValue(), cate);
				
				pizzas.add(pizza);
			}

			resultats.close();
		
			conn.commit();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return pizzas;
	};

	@Override
	public boolean saveNewPizza(Pizza pizza) {
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(bundle.getString("database.pizzeria.url"), bundle.getString("database.pizzeria.user"), bundle.getString("database.pizzeria.password"));
			conn.setAutoCommit(false);
		
			PreparedStatement savePizza = conn.prepareStatement("INSERT INTO pizza(CODE, NOM, PRIX, ID_CATEGORIE) VALUES(?, ?, ?, ?)");
			
			savePizza.setString(1, pizza.getCode());
			savePizza.setString(2, pizza.getNom());
			savePizza.setDouble(3, pizza.getPrix());
			savePizza.setInt(4, pizza.getCategorie().getId());
			savePizza.executeUpdate();
		
			savePizza.close();
			
			conn.commit();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}


	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) {
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(bundle.getString("database.pizzeria.url"), bundle.getString("database.pizzeria.user"), bundle.getString("database.pizzeria.password"));
			conn.setAutoCommit(false);
			
			PreparedStatement updatePizza = conn.prepareStatement("UPDATE PIZZA SET CODE=?, NOM=?, PRIX=?, ID_CATEGORIE=? WHERE CODE=?");
		
			updatePizza.setString(1, pizza.getCode());
			updatePizza.setString(2, pizza.getNom());
			updatePizza.setDouble(3, pizza.getPrix());
			updatePizza.setInt(4, pizza.getCategorie().getId());
			updatePizza.setString(5, codePizza);
			updatePizza.executeUpdate();
		
			updatePizza.close();
		
			conn.commit();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}


	@Override
	public boolean deletePizza(String codePizza) {
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(bundle.getString("database.pizzeria.url"), bundle.getString("database.pizzeria.user"), bundle.getString("database.pizzeria.password"));
			conn.setAutoCommit(false);

			PreparedStatement updatePizza = conn.prepareStatement("DELETE FROM PIZZA WHERE CODE=?");
			updatePizza.setString(1, codePizza);
			updatePizza.executeUpdate();
			updatePizza.close();
		
			conn.commit();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	};
}
