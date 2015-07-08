package example;

import org.apache.struts2.interceptor.validation.SkipValidation;
import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport {

    @Override
    public String execute() throws Exception {
    	System.out.println("el usuario es " + usuario + " y el password es " + password	);
        return SUCCESS;
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