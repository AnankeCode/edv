package co.edu.ananke.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

/**
 * Allow the controller to return a 404 if an account is not found by simply
 * throwing this exception. The @ResponseStatus causes Spring MVC to return a
 * 404 instead of the usual 500.
 * 
 * @author SantiPurdy
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsuarioNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UsuarioNotFoundException(int usuariousu_munid) {
		super("No such account: " + usuariousu_munid);
	}

    public UsuarioNotFoundException(String partialUsuarios) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
