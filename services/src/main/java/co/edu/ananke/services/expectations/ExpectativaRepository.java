package io.pivotal.microservices.accounts;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

/**
 
 * @author SantiPurdy
 */

public interface ExpectativaRepository extends Repository<Usuarios, int> {

	

	public Expectativa findByusu_numid(String expectativausu_numid);


	

	public List<usuarios> findByusu_tipo_idContainingIgnoreCase(String partialUsuarios);


	
	@Query("SELECT count(*) from usuarios")

	public int countExpectativas();
}
