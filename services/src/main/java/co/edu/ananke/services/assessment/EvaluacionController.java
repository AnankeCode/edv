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
public class EvaluacionesController {

	protected Logger logger = Logger.getLogger(EvaluacionesController.class
			.getName());
	protected EvaluacionRepository evaluacionRepository;

	/**
	 * Create an instance plugging in the respository of Accounts.
	 * 
	 * @param accountRepository
	 *            An account repository implementation.
	 */
	@Autowired
	public EvaluacionesController(EvaluacionRepository evaluacionRepository) {
		this.evaluacionRepository = evaluacionRepository;

		logger.info("EvaluacionRepository says system has "
				+ evaluacionRepository.countEvaluaciones() + " evaluaciones");
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
	@RequestMapping("/evaluacion/{usu_numid}")
	public Account byusu_numid(@PathVariable(" Evaluacionusu_numid") int Evaluacionusu_numid) {

		logger.info("evaluaciones-service byusu_numid() invoked: " + Evaluacionusu_numid);
		Evaluacion evaluacion = evaluacionRepository.findByusu_numid(Evaluacionusu_numid);
		logger.info("evaluaciones-service byusu_numid() found: " + evaluacion);

		if (evaluacion == null)
			throw new EvaluacionNotFoundException(accountNumber);
		else {
			return evaluacion;
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
	@RequestMapping("/Usuarios/usu_tipoid/{name}")
	public List<Usuarios> by usu_numid(@PathVariable("name") String partialusu_tipoid) {
		logger.info("accounts-service byOwner() invoked: "
				+ evaluacionRepository.getClass().getName() + " for "
				+ partialName);

		List<evaluacion> evaluacion = evaluacionRepository
				.findByusu_tipo_idContainingIgnoreCase(partialName);
		logger.info("accounts-service byusu_tipoid() found: " + evaluaciones);

		if (evaluaciones == null || accounts.size() == 0)
			throw new EvaluacionNotFoundException(partialusu_tipoid);
		else {
			return evaluaciones;
		}
	}
}
