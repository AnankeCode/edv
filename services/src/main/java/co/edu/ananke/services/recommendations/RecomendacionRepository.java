package io.pivotal.microservices.accounts;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

/**
 
 * @author SantiPurdy
 */

public interface RecomendacionRepository extends Repository<Usuarios, int> {

	

	public Recomendacion findByusu_numid(String Recomendacionusu_numid);


	public List<Usuarios> findByusu_tipoidContainingIgnoreCase(String partialUsuarios);

	

	@Query("SELECT count(*) from Usuarios")

	public int countRecomendacion();
}
