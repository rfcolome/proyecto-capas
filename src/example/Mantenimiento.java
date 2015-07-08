package example;

import com.opensymphony.xwork2.ActionSupport;

public class Mantenimiento extends ActionSupport{
	
	private String nombre;
    private String apellido;
    private String usuario;
    private String password;
	
    @Override
    public String execute() throws Exception {
    	if (nombre != null && !nombre.isEmpty() && 
    			apellido != null && !apellido.isEmpty() && 
    			usuario != null && !usuario.isEmpty() &&
    			password != null && !password.isEmpty()) {
    		Usuario usr = new Usuario(null, nombre, apellido, usuario, password);
    		usr.guardarUsuario();
    		return SUCCESS;
    	}
    	else {
    		return ActionSupport.ERROR;
    	}
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
}
