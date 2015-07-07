package example;

import java.sql.*;
import java.util.*;

public class DB {
	
	public static void main(String[] argv) {
		ArrayList<Usuario> usuarios = buscarUsuarios();
		for (int i = 0; i < usuarios.size(); i++) {
			System.out.println(usuarios.get(i).getNombre() + " " + usuarios.get(i).getApellido());
		}
	}
	
	public static Connection connect() {
		Connection connection = null;
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/proyectocapas","colo", "colo");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return connection;
	}
	
	public static ArrayList<Usuario> buscarUsuarios() {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			Connection connection = connect();
			String sql = "" +
					" SELECT *     " +
					" FROM usuario ";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultado = statement.executeQuery();
			while (resultado.next()) {
				usuarios.add(
						new Usuario(
								resultado.getInt("id"), 
								resultado.getString("nombre"), 
								resultado.getString("apellido"),
								resultado.getString("usuario"),
								resultado.getString("password")));
			}
			connection.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return usuarios;
	}
}
