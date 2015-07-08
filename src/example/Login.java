package example;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport {

    @Override
    public String execute() throws Exception {
    	ArrayList<Usuario> usuarios = Usuario.buscarUsuarios();
    	boolean encontrado = false;
    	Iterator iterator = usuarios.iterator();
    	while (iterator.hasNext()) {
    		Usuario usr = (Usuario) iterator.next();
    		if (usr.esUsuarioCorrecto(usuario, password)) {
    			encontrado = true;
    			break;
    		}
    	}
    	if (encontrado) {
    		return SUCCESS;
    	}
    	else {
    		return INPUT;
    	}
        //return SUCCESS;
    }

    @SkipValidation
    public String form() throws Exception {
        return INPUT;
    }

    private String usuario;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}