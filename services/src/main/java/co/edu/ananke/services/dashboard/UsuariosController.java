package co.edu.ananke.services.dashboard;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.pivotal.microservices.exceptions.UsuarioNotFoundException;

/**
 
 * @author SantiPurdy
 */
@RestController
public class UsuariosController {


	protected static final Logger logger = Logger.getLogger(UsuariosController.Usuarios

			.getUsuarios());
    private static Object Usuarios;
	protected UsuariosRepository usuariosRepository;
    private String usuarios;

	
	@Autowired

	public UsuariosController(UsuariosRepository usuariosRepository) {

		this.usuariosRepository = usuariosRepository;

		logger.info("UsuariosRepository says system has "
				+ usuariosRepository.countUsuarios() + " usuarios");
	}

	
	 

	@RequestMapping("/usuario/{ usuariosusu_numid}")
	public Usuarios byusu_numid(@PathVariable(" usuariosusu_numid") String usu_tipoid, String usuariosusu_numid) {

		logger.info("Usuarios-service byusu_numid() invoked: " +  usuariosusu_numid);
        Usuarios usuarios = usuariosRepository.findByusu_numid( usuariosusu_numid);
		logger.info("Usuarios-service byusu_numid() found: " + usuarios);


		if (usuarios == null)
			throw new UsuarioNotFoundException( usuariosusu_numid);
		else {
			return usuarios;
		}
	}

	

	@RequestMapping("/usuario/partialUsuarios/{usuarios}")
	public String byUsuarios(@PathVariable("name") String partialUsuarios) {
		logger.info("usuarios-service byusu_tipo_id() invoked: "
				+ UsuariosRepository.getUsuarios().getUsuarios() + " for "
				+ partialUsuarios);

		List<Usuarios> Usuarios = usuariosRepository
				.findByusu_tipo_idContainingIgnoreCase(partialUsuarios);
		logger.info("usuario-service byOwner() found: " + usuarios);

		if (usuarios == null || usuarios.size() == 0)
			throw new UsuarioNotFoundException(partialUsuarios);

		else {
			return usuarios;
		}
	}
}
