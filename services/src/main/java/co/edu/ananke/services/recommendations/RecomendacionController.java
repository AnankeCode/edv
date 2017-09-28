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


	
	@Autowired

	public RecomendacionController(RecomendacionesRepository recomendacionesRepository) {
		this.recomendacionesRepository = recomendacionesRepository;

		logger.info("RecomendacionesRepository says system has "
				+ recomendacionesRepository.countRecomendacion() + " recomendacion");

	}

	

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

	

	@RequestMapping("/recomendacion/usu_tipoid/{Usuarios}")
	public List<Usuarios> byusu_tipoid(@PathVariable("Usuarios") String partialUsuarios) {
		logger.info("recomendacion-service byusu_tipoid() invoked: "
				+ recomendacionRepository.getRecomendacion().getUsuarios() + " for "
				+ partialUsuarios);

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
