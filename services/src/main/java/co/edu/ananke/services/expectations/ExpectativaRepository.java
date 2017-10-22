package co.edu.ananke.services.expectations;

import co.edu.ananke.services.dashboard.Usuarios;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

/**
 
 * @author SantiPurdy
 */

public interface ExpectativaRepository extends Repository<Usuarios, int> {

    public static Object getExpectativa();

	

	public Expectativa findByusu_numid(String expectativausu_numid);


	

	public List<Usuarios> findByusu_tipo_idContainingIgnoreCase(String partialUsuarios);


	
	@Query("SELECT count(*) from usuarios")

	public int countExpectativas();
}
