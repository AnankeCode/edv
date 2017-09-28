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
 * @author SantiPurdy
 */
@RestController
public class RecomendacionController {

	protected Logger logger = Logger.getLogger(RecomendacionController.class
			.getName());
	protected RecomendacionesRepository recomendacionesRepository;

	/**
	 * Create an instance plugging in the respository of Accounts.
	 * 
	 * @param accountRepository
	 *            An account repository implementation.
	 */
	@Autowired
	public RecomendacionController(RecomendacionesRepository recomendacionesRepository) {
		this.recomendacionesRepository = recomendacionesRepository;

		logger.info("RecomendacionesRepository says system has "
				+ recomendacionesRepository.countRecomendacion() + " recomendacion");
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
	@RequestMapping("/Recomendacion/{Recomendacionusu_numid}")
	public Recomendacion byusu_numid(@PathVariable("Recomendacionusu_numidr") String Recomendacionusu_numid) {

		logger.info("recomendacion-service byusu_numid() invoked: " + Recomendacionusu_numid);
		Recomendacion recomendacion = recomendacionRepository.findByusu_numid(Recomendacionusu_numid);
		logger.info("recomendacion-service byusu_numid() found: " + recomendaciones);

		if (recomendacion == null)
			throw new RecomendacionNotFoundException(Recomendacionusu_numid);
		else {
			return recomendacion;
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
	@RequestMapping("/recomendacion/usu_tipoid/{name}")
	public List<Account> byusu_tipoid(@PathVariable("name") String partialusu_tipoid) {
		logger.info("recomendacion-service byusu_tipoid() invoked: "
				+ recomendacionRepository.getClass().getName() + " for "
				+ partialusu_tipoid);

		List<Recomendacion> Recomendacion = RecomendacionRepository
				.findByOwnerContainingIgnoreCase(partialName);
		logger.info("recomendacion-service byOwner() found: " + Recomendacion);

		if (Recomendacion == null || Recomendacion.size() == 0)
			throw new RecomendacionNotFoundException(partialusu_tipoid);
		else {
			return Recomendacion;
		}
	}
}
