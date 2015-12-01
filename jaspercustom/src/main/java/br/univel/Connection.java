package br.univel;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
	private static java.sql.Connection connection;
	
	public static java.sql.Connection getConnection(){
		if(connection == null){
			try {
				connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/locadoradb", "postgres", "univel");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return connection;
	}
}
