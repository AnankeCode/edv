package io.pivotal.microservices.accounts;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

/**
 * Repository for Account data implemented using Spring Data JPA.
 * 
 * @author SantiPurdy
 */
public interface UsuariosRepository extends Repository<Usuarios, int> {
	/**
	 * Find an account with the specified account number.
	 *
	 * @param accountNumber
	 * @return The account if found, null otherwise.
	 */
	public Usuarios findByusu_numid(int usuariosusu_numid);

	/**
	 * Find accounts whose owner name contains the specified string
	 * 
	 * @param partialName
	 *            Any alphabetic string.
	 * @return The list of matching accounts - always non-null, but may be
	 *         empty.
	 */
	public List<Usuarios> findByusu_tipoidContainingIgnoreCase(String partialusu_tipoid);

	/**
	 * Fetch the number of accounts known to the system.
	 * 
	 * @return The number of accounts.
	 */
	@Query("SELECT count(*) from Usuarios")
	public int countUsuarios();
}
