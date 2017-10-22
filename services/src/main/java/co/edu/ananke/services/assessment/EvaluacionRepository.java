package  co.edu.ananke.services.assessment;

import io.pivotal.microservices.accounts.Usuarios;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

/**
 
 * @author SantiPurdy
 */



public interface EvaluacionRepository extends Repository<Usuarios, int> {

	

	public Evaluacion findByusu_numid(int Evaluacionusu_numid);

	

	public List<Usuarios> findByusu_tipoidContainingIgnoreCase(String partialUsuarios);


	

	
	@Query("SELECT count(*) from  Usuarios")
	public int countEvaluaciones();

   
