package example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Usuario {
	
	private Integer id;
	private String  nombre;
	private String  apellido;
	private String  usuario;
	private String  password;
	
	public Usuario(Integer id, String nombre, String apellido, String usuario, String password) {
		setId      (id);
		setNombre  (nombre);
		setApellido(apellido);
		setUsuario (usuario);
		setPassword(password);
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public boolean esUsuarioCorrecto(String usuario, String password) {
		return usuario.equalsIgnoreCase(this.usuario) && password.equals(this.password);
	}
	
	public static ArrayList<Usuario> buscarUsuarios() {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			Connection connection = DB.connect();
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
	
	public boolean guardarUsuario() {
		String sql = "" +
				" INSERT INTO usuario(nombre, apellido, usuario, password) " +
				" VALUES (?, ?, ?, ?);                                     ";
		if (id != null && id.intValue() > 0) {
			sql = "" +
					" UPDATE usuario " +
					" SET nombre = ?, apellido = ?, usuario = ?, password = ? " +
					" WHERE id = ?";
		}
		try {
			Connection connection = DB.connect();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, nombre);
			statement.setString(2, apellido);
			statement.setString(3, usuario);
			statement.setString(4, password);
			statement.execute();
			connection.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}
