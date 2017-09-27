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
	protected RecomendacionRepository recomendacionRepository;

	/**
	 * Create an instance plugging in the respository of Accounts.
	 * 
	 * @param accountRepository
	 *            An account repository implementation.
	 */
	@Autowired
	public RecomendacionController(RecomendacionRepository recomendacionRepository) {
		this.accountRepository = accountRepository;

		logger.info("AccountRepository says system has "
				+ RecomendacionRepository.countRecomendacion() + " accounts");
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
	@RequestMapping("/Recomendacion/{accountNumber}")
	public Recomendacion byNumber(@PathVariable("accountNumber") String accountNumber) {

		logger.info("accounts-service byNumber() invoked: " + accountNumber);
		Recomendacion recomendacion = recomendacionRepository.findByNumber(accountNumber);
		logger.info("accounts-service byNumber() found: " + account);

		if (recomendacion == null)
			throw new AccountNotFoundException(accountNumber);
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
	@RequestMapping("/recomendacion/owner/{name}")
	public List<Account> byOwner(@PathVariable("name") String partialName) {
		logger.info("accounts-service byOwner() invoked: "
				+ recomendacionRepository.getClass().getName() + " for "
				+ partialName);

		List<Recomendacion> Recomendacion = RecomendacionRepository
				.findByOwnerContainingIgnoreCase(partialName);
		logger.info("accounts-service byOwner() found: " + Recomendacion);

		if (Recomendacion == null || Recomendacion.size() == 0)
			throw new AccountNotFoundException(partialName);
		else {
			return Recomendacion;
		}
	}
}
