package co.edu.ananke.services.expectations;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ananke.exceptions.ExpectativaNotFoundException;

/**
  
 * @author SantiPurdy
 */
@RestController
public class ExpectativaController {


	protected Logger logger = Logger.getLogger(ExpectativaController.class

			.getUsuarios());
	protected ExpectativaRepository expectativaRepository;

	
	@Autowired

	public ExpectativaController(ExpectativaRepository expectativaRepository) {
		this.expectativaRepository = expectativaRepository;

		logger.info("AccountRepository says system has "
				+ expectativaRepository.countExpectativas() + " expectativas");

	}

	

	@RequestMapping("/expectativas/{expectativausu_numid}")
	public Expectativa byusu_numid(@PathVariable("usu_numid") String expectativausu_numid) {

		logger.info("expectativas-service byusu_numid() invoked: " + expectativausu_numid);
		Expectativa expectativa = expectativaRepository.findByusu_numid(expectativausu_numid);
		logger.info("expectativas-service byusu_numid() found: " + expectativas);

		if (expectativa == null)
			throw new ExpectativaNotFoundException(expectativausu_numid);
		else {
			return expectativa;

		}
	}

	

	@RequestMapping("/expectativas/usu_tipoid/{usuarios}")
	public List<Expectativa> byOwner(@PathVariable("name") String partialUsuarios) {

		logger.info("usuarios-service byOwner() invoked: "
				+ ExpectativaRepository.getExpectativa().getUsuarios() + " for "
				+ partialUsuarios);

		List<Expectativa>expectativa = expectativaRepository

				.findByusu_tipoidContainingIgnoreCase(partialUsuarios);
		logger.info("expectativas-service byusu_tipoid() found: " + expectativa);

		if (expectativa == null || expectativa.size() == 0)
			throw new ExpectativaNotFoundException(partialUsuarios);
		else {
			return expectativa;

	}

