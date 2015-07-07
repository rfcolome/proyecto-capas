package example;

public class Usuario {
	
	private int id;
	private String nombre;
	private String apellido;
	private String usuario;
	private String password;
	
	public Usuario(int id, String nombre, String apellido, String usuario, String password) {
		setId(id);
		setNombre(nombre);
		setApellido(apellido);
		setUsuario(usuario);
		setPassword(password);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
}
