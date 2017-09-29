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
public class UsuariosController {


	protected Logger logger = Logger.getLogger(UsuarioController.Usuarios

			.getUsuarios());
	protected UsuariosRepository usuariosRepository;

	
	@Autowired

	public UsuarioController(UsuariosRepository usuariosRepository) {

		this.usuariosRepository = usuariosRepository;

		logger.info("UsuariosRepository says system has "
				+ usuariosRepository.countUsuarios() + " usuarios");
	}

	
	 

	@RequestMapping("/usuario/{ usuariosusu_numid}")
	public Account byusu_numid(@PathVariable(" usuariosusu_numid") String usu_tipoid) {

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
	public List<Usuarios> byUsuarios(@PathVariable("name") String partialUsuarios) {
		logger.info("usuarios-service byusu_tipo_id() invoked: "
				+ UsuariosRepository.getUsuarios().getUsuarios() + " for "
				+ partialUsuarios);

		List<Usuarios> Usuarios = usuariosRepository
				.findByusu_tipo_idContainingIgnoreCase(partialUsuarios);
		logger.info("usuario-service byOwner() found: " + usuario);

		if (usuarios == null || usuarios.size() == 0)
			throw new UsuarioNotFoundException(partialUsuarios);

		else {
			return usuarios;
		}
	}
}
