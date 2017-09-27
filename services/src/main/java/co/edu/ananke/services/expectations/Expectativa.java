package io.pivotal.microservices.accounts;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Persistent account entity with JPA markup. Accounts are stored in an H2
 * relational database.
 * 
 * @author SantiPurdy
 */
@Entity
@Table(name = "T_ACCOUNT")
public class Expectativa implements Serializable {

	private static final long serialVersionUID = 1L;

	public static Long nextId = 0L;

	@Id
	protected String usu_tipoid;

	protected int usu_numid;
	
	protected String exp_pregunta;

	protected int exp_id;

	@Column(name = "name")
	
    private int exp_opcion;
    

	/**
	 * This is a very simple, and non-scalable solution to generating unique
	 * ids. Not recommended for a real application. Consider using the
	 * <tt>@GeneratedValue</tt> annotation and a sequence to generate ids.
	 * 
	 * @return The next available id.
	 */
	protected static Long getNextId() {
		synchronized (nextId) {
			return nextId++;
		}
	}

	/**
	 * Default constructor for JPA only.
	 */
	protected Account() {
		balance = BigDecimal.ZERO;
	}

	public Account(int exp_opcion , String exp_pregunta) {
		id = getNextId();
		this.exp_pregunta = pregunta;
		this.exp_opcion = opcion;
		balance = BigDecimal.ZERO;
	}

	public long getId() {
		return id;
	}

	/**
	 * Set JPA id - for testing and JPA only. Not intended for normal use.
	 * 
	 * @param id
	 *            The new id.
	 */
	protected void setId(long id) {
		this.id = id;
	}

	public String getexp_id() {
		return exp_id;
	}

	protected void setexp_id(String exp_id) {
		this.exp_id = exp_id;
	}

	public String getexp_pregunta() {
		return exp_pregunta;
	}

	protected void setexp_pregunta(String exp_pregunta) {
		this.exp_pregunta = exp_pregunta;
	}

	public String getexp_opcion() {
		return exp_opcion;
	}

	protected void setexp_opcion(String exp_opcion) {
		this.exp_opcion = exp_opcion;
	
	
	
	public BigDecimal getBalance() {
		return balance.setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}

	public void withdraw(BigDecimal amount) {
		balance.subtract(amount);
	}

	public void deposit(BigDecimal amount) {
		balance.add(amount);
	}

	@Override
	public String toString() {
		return number + " [" + owner + "]: $" + balance;
	}

}
