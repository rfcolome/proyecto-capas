package example;

import java.sql.*;
import java.util.*;

public class DB {
	
	public static Connection connect() {
		Connection connection = null;
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/proyectocapas","colo", "colo");
			System.err.println("hello!");
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		return connection;
	}
}
