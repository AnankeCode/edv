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
public class ExpectativaController {

	protected Logger logger = Logger.getLogger(ExpectativasController.class
			.getName());
	protected ExpectativaRepository expectativaRepository;

	/**
	 * Create an instance plugging in the respository of Accounts.
	 * 
	 * @param accountRepository
	 *            An account repository implementation.
	 */
	@Autowired
	public ExpectativaSController(ExpectativaRepository expectativaRepository) {
		this.expectativaRepository = expectativaRepository;

		logger.info("AccountRepository says system has "
				+ expectativaRepository.countExpectativas() + " expectativas");
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
	@RequestMapping("/expectativas/{expectativausu_numid}")
	public Expectativa byusu_numid(@PathVariable("usu_numid") String expectativausu_numid) {

		logger.info("expectativas-service byusu_numid() invoked: " + expectativausu_numid);
		Expectativa expectativa = expectativaRepository.findByusu_numid(expectativausu_numid);
		logger.info("expectativas-service byusu_numid() found: " + expectativa);

		if (expectativas == null)
			throw new ExpectativaNotFoundException(expectativausu_numid);
		else {
			return expectativas;
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
	@RequestMapping("/expectativas/usu_tipoid/{name}")
	public List<Expectativa> byOwner(@PathVariable("name") String partialName) {
		logger.info("accounts-service byOwner() invoked: "
				+ accountRepository.getClass().getName() + " for "
				+ partialName);

		List<expectativa>expectativa = expectativaRepository
				.findByusu_tipoidContainingIgnoreCase(partialusu_tipoid);
		logger.info("expectativas-service byusu_tipoid() found: " + expectativas);

		if (expectativas == null || expectativas.size() == 0)
			throw new ExpectativaNotFoundException(partialName);
		else {
			return expectativas;
		}
	}
}
