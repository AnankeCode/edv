package co.edu.ananke.services.dashboard;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

/**
 
 * @author SantiPurdy
 */

public interface UsuariosRepository extends Repository<Usuarios, int> {


	public Usuarios findByusu_numid(int usuariosusu_numid);


	

	public List<Usuarios> findByusu_tipoidContainingIgnoreCase(String partialuUsuarios);


	
	@Query("SELECT count(*) from Usuarios")

	public int countUsuarios();

}
