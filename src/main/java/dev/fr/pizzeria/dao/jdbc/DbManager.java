package dev.fr.pizzeria.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DbManager {
	
	ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
	
	private static Connection conn;
	
	private DbManager() {
		
		try {
			Class.forName(bundle.getString("database.driver"));	
			try {
				conn = DriverManager.getConnection(bundle.getString("database.pizzeria.url"), bundle.getString("database.pizzeria.user"), bundle.getString("database.pizzeria.password"));
				conn.setAutoCommit(false);
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	};
	
	private static DbManager singleton;
	
	public static synchronized DbManager getInstance() {
		
		if (singleton == null) {
			synchronized(singleton) {
				singleton = new DbManager();
			}
		}
		
		return singleton;
	}

}
