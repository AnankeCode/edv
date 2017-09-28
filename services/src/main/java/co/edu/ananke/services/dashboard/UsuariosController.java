package io.pivotal.microservices.accounts;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.pivotal.microservices.exceptions.AccountNotFoundException;

/**
 
 * @author SantiPurdy
 */
@RestController
public class UsuariosController {

	protected Logger logger = Logger.getLogger(UsuarioController.class
			.getName());
	protected UsuariosRepository usuariosRepository;

	/**
	 * Create an instance plugging in the respository of Accounts.
	 * 
	 * @param accountRepository
	 *            An account repository implementation.
	 */
	@Autowired
	public UsuarioController(UsuariosRepository usuariosRepository) {
		this.usuariosRepository = usuariosRepository;

		logger.info("AccountRepository says system has "
				+ usuariosRepository.countusuarios() + " accounts");
	}

	/**
	 * Fetch an account with the specified account number.
	 * 
	 * @param accountNumber
	 *            A numeric, 9 digit account number.
	 * @return The account if found.
	 * @throws AccountNotFoundException
	 *             If the number is not recognised.
	 */
	@RequestMapping("/usuario/{ usuariosusu_numid}")
	public Account byNumber(@PathVariable(" usuariosusu_numid") String usu_tipoid) {

		logger.info("Usuarios-service byusu_numid() invoked: " +  usuariosusu_numid);
        Usuarios usuarios = usuariosRepository.findByusu_numid( usuariosusu_numid);
		logger.info("Usuarios-service byusu_numid() found: " + usuarios);

		if (usuarios == null)
			throw new UsuariosNotFoundException( usuariosusu_numid);
		else {
			return usuarios;
		}
	}

	/**
	 * Fetch accounts with the specified name. A partial case-insensitive match
	 * is supported. So <code>http://.../accounts/owner/a</code> will find any
	 * accounts with upper or lower case 'a' in their name.
	 * 
	 * @param partialName
	 * @return A non-null, non-empty set of accounts.
	 * @throws AccountNotFoundException
	 *             If there are no matches at all.
	 */
	@RequestMapping("/usuario/usu_tipoid/{name}")
	public List<Usuarios> byUsuarios(@PathVariable("name") String partialName) {
		logger.info("accounts-service byOwner() invoked: "
				+ UsuariosRepository.getClass().getName() + " for "
				+ partialusu_tipoid);

		List<Usuarios> Usuarios = usuariosRepository
				.findByOwnerContainingIgnoreCase(partialName);
		logger.info("usuario-service byOwner() found: " + usuario);

		if (usuarios == null || usuarios.size() == 0)
			throw new AccountNotFoundException(partialusu_tipoid);
		else {
			return usuarios;
		}
	}
}
