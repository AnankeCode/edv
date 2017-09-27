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

	protected Logger logger = Logger.getLogger(AccountsController.class
			.getName());
	protected ExpectativaRepository expectativaRepository;

	/**
	 * Create an instance plugging in the respository of Accounts.
	 * 
	 * @param accountRepository
	 *            An account repository implementation.
	 */
	@Autowired
	public ExpectativaController(ExpectativaRepository expectativaRepository) {
		this.expectativaRepository = expectativaRepository;

		logger.info("AccountRepository says system has "
				+ expectativaRepository.countExpectativa() + " accounts");
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
	@RequestMapping("/accounts/{accountNumber}")
	public Expectativa byNumber(@PathVariable("accountNumber") String accountNumber) {

		logger.info("accounts-service byNumber() invoked: " + accountNumber);
		Expecatativa expectativa = expectativaRepository.findByNumber(accountNumber);
		logger.info("accounts-service byNumber() found: " + expectativa);

		if (expectativa == null)
			throw new AccountNotFoundException(accountNumber);
		else {
			return expectativa;
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
	@RequestMapping("/accounts/owner/{name}")
	public List<Account> byOwner(@PathVariable("name") String partialName) {
		logger.info("accounts-service byOwner() invoked: "
				+ accountRepository.getClass().getName() + " for "
				+ partialName);

		List<expectativa>expectativa = expectativaRepository
				.findByOwnerContainingIgnoreCase(partialName);
		logger.info("accounts-service byOwner() found: " + accounts);

		if (expectativa == null || expectativa.size() == 0)
			throw new AccountNotFoundException(partialName);
		else {
			return expectativa;
		}
	}
}
