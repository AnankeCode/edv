package co.edu.ananke.services.assessment;

import io.pivotal.microservices.accounts.Usuarios;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.pivotal.microservices.exceptions.EvaluacionNotFoundException;

/**
 
 * @author SantiPurdy
 */
@RestController


public class EvaluacionesController {

    private static String evaluacion;

	protected static final Logger logger = Logger.getLogger(EvaluacionesController.evaluacion.getUsuarios());
	protected EvaluacionRepository evaluacionRepository;
    private int partialusuarios;

	
	@Autowired

	public EvaluacionesController(EvaluacionRepository evaluacionRepository) {
		this.evaluacionRepository = evaluacionRepository;

		logger.info("EvaluacionRepository says system has "
				+ evaluacionRepository.countEvaluaciones() + " evaluaciones");

	}

	

	@RequestMapping("/evaluacion/{usu_numid}")
	public Evaluacion byusu_numid(@PathVariable(" Evaluacionusu_numid") int Evaluacionusu_numid) {

		logger.info("evaluaciones-service byusu_numid() invoked: " + Evaluacionusu_numid);
		co.edu.ananke.services.assessment.Evaluacion evaluacion = evaluacionRepository.findByusu_numid(Evaluacionusu_numid);
		logger.info("evaluaciones-service byusu_numid() found: " + evaluacion);

		if (evaluacion == null)
			throw new EvaluacionNotFoundException(Evaluacionusu_numid);

		else {
			return evaluacion;
		}
	}

    /**
     *
     */
    @RequestMapping("/Usuarios/usu_tipoid/{Usuarios}")
	public List<Usuarios> by EvaluacionesController(@PathVariable("Usuarios") String partialUsuarios, String evaluaciones) {

		logger.info("evaluacion-service by() invoked: "
				+ evaluacionRepository.getEvaluacion().getUsuarios() + " for "
				+ partialUsuarios);

		List<evaluacion> evaluacion = evaluacionRepository

				.findByusu_tipo_idContainingIgnoreCase(partialUsuarios);
		logger.info("accounts-service byusu_tipoid() found: " + evaluaciones);

		if (evaluacion == null || evaluacion.size() == 0)
			throw new EvaluacionNotFoundException(partialusuarios);
		else {
		}
	}

    
}
