package io.pivotal.microservices.accounts;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.pivotal.microservices.exceptions.AccountNotFoundException;

/**
 * A RESTFul controller for accessing account information.
 * 
 * @author Santipurdy
 */
@RestController
public class NivelacionController {

	protected Logger logger = Logger.getLogger(AccountsController.class
			.getName());
	protected NivelacionesRepository nivelacionesRepository;

	/**
	 * Create an instance plugging in the respository of Accounts.
	 * 
	 * @param accountRepository
	 *            An account repository implementation.
	 */
	@Autowired
	public NivelacionController(NivelacionesRepository nivelacionesRepository) {
		this.nivelacionesRepository = nivelacionesRepository;

		logger.info("AccountRepository says system has "
				+ nivelacionesRepository.countNivelacion() + " nivelaciones");
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
	@RequestMapping("/Nivelacion/{Nivelacionusu_numid}")
	public Nivelacion byusu_numid(@PathVariable("nivelacionusu_numid") String nivelacionusu_numid) {

		logger.info("nivelacion-service byusu_numid() invoked: " + Nivelacionusu_numid);
		Nivelacion nivelacion = NivelacionRepository.findByusu_numid(nivelacionusu_numid);
		logger.info("nivelacion-service byusu_numid() found: " + nivelaciones);

		if (Nivelacion == null)
			throw new NivelacionNotFoundException(Nivelacionusu_numid);
		else {
			return Nivelacion;
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
	@RequestMapping("/nivelacion/usu_tipoid/{name}")
	public List<Nivelacion> byusu_tipoid(@PathVariable("name") String partialusu_tipoid) {
		logger.info("accounts-service byusu_tipoid() invoked: "
				+ nivelacionRepository.getClass().getName() + " for "
				+ partialusu_tipoid);

		List<Nivelacion> nivelacion = nivelacionRepository
				.findByusu_tipoidContainingIgnoreCase(partialusu_tipoid);
		logger.info("nivelacion-service byusu_tipoid() found: " + nivelacion);

		if (Nivelacion == null || accounts.size() == 0)
			throw new NivelacionNotFoundException(partialusu_tipoid);
		else {
			return Nivelacion;
		}
	}
}
