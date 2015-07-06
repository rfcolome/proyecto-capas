package example;

import java.sql.*;
import java.util.*;

public class DB {
	
	public static void main(String[] argv) {
		if (tryConnection()) {
			System.out.println("success!!");
		}
		else {
			System.out.println("failure :C");
		}
	}
	
	public static boolean tryConnection() {
		boolean success = false;
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = null;
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/proyectocapas","colo", "colo");
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM usuario");
			ResultSet resultado = statement.executeQuery();
			//resultado.first();
			resultado.next();
			System.out.println(resultado.getString("nombre") + " " + resultado.getString("apellido"));
			connection.close();
			success = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return success;
	}
}
