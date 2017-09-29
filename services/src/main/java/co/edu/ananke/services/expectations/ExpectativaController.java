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
public class ExpectativaController {


	protected Logger logger = Logger.getLogger(ExpectativasController.class

			.getUsuarios());
	protected ExpectativaRepository expectativaRepository;

	
	@Autowired

	public ExpectativaSController(ExpectativaRepository expectativaRepository) {
		this.expectativaRepository = expectativaRepository;

		logger.info("AccountRepository says system has "
				+ expectativaRepository.countExpectativas() + " expectativas");

	}

	

	@RequestMapping("/expectativas/{expectativausu_numid}")
	public Expectativa byusu_numid(@PathVariable("usu_numid") String expectativausu_numid) {

		logger.info("expectativas-service byusu_numid() invoked: " + expectativausu_numid);
		Expectativa expectativa = expectativaRepository.findByusu_numid(expectativausu_numid);
		logger.info("expectativas-service byusu_numid() found: " + expectativas);

		if (expectativas == null)
			throw new ExpectativaNotFoundException(expectativausu_numid);
		else {
			return expectativas;

		}
	}

	

	@RequestMapping("/expectativas/usu_tipoid/{usuarios}")
	public List<Expectativa> byOwner(@PathVariable("name") String partialUsuarios) {

		logger.info("usuarios-service byOwner() invoked: "
				+ accountRepository.getExpectativa().getUsuarios() + " for "
				+ partialUsuarios);

		List<expectativa>expectativa = expectativaRepository

				.findByusu_tipoidContainingIgnoreCase(partialusu_tipoid);
		logger.info("expectativas-service byusu_tipoid() found: " + expectativas);

		if (expectativas == null || expectativas.size() == 0)
			throw new ExpectativaNotFoundException(partialName);
		else {
			return expectativas;

	}
}
