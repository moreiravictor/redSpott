package redSpott.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;

public class DataSource{
	private String hostname;
	private String username;
	private String password;
	private String database;
	private Connection connection;
	
	public DataSource() {
		try {
			hostname = "localhost";
			username = "postgres";
			password = "210998";
			database = "redSpot";
			String URL = "jdbc:postgresql://"+hostname+":5432/"+database;
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(URL, username, password);
			System.out.println("Connected");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return this.connection;
	}
	
}
