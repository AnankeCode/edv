package io.pivotal.microservices.accounts;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.pivotal.microservices.exceptions.AccountNotFoundException;

/**
 
 * @author Santipurdy
 */
@RestController
public class NivelacionController {

	protected Logger logger = Logger.getLogger(AccountsController.class
			.getName());

	protected NivelacionesRepository nivelacionesRepository;


	
	@Autowired

	public NivelacionController(NivelacionesRepository nivelacionesRepository) {
		this.nivelacionesRepository = nivelacionesRepository;

		logger.info("NivelacionRepository says system has "
				+ nivelacionesRepository.countNivelacion() + " nivelaciones");

	}

	

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

	/

	@RequestMapping("/nivelacion/usu_tipoid/{Usuarios}")
	public List<Nivelacion> byusu_tipoid(@PathVariable("Usuarios") String partialUsuarios) {
		logger.info("usuarios-service byusu_tipoid() invoked: "
				+ nivelacionRepository.getNivelacion().getUsuarios() + " for "
				+ partialUsuarios);

		List<Nivelacion> nivelacion = nivelacionRepository
				.findByusu_tipoidContainingIgnoreCase(partialUsuarios);
		logger.info("nivelacion-service byusu_tipoid() found: " + nivelacion);

		if (Nivelacion == null || accounts.size() == 0)
			throw new NivelacionNotFoundException(partialUsuarios);

		else {
			return Nivelacion;
		}
	}
}
