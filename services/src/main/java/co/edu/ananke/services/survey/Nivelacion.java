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
@Table(name = "Nivelacion")
public class Nivelacion implements Serializable {

	private static final long serialVersionUID = 1L;

	public static Long nextId = 0L;

	@Id
	protected String usu_tipoid;

	protected int usu_numid;
	
	protected String niv_id;

	protected int niv_pregunta;
	@Column(name = "Nivelacion")
	 private int niv_opcion;
    private String niv_detalle;
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

	public Account(String eva_pregunta, int niv_opcion, String niv_detalle) {
		id = getNextId();
		this.niv_pregunta = pregunta;
		this.niv_opcion= opcion;
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

	public int getniv_id() {
		return niv_id;
	}

	protected void setniv_id(int niv_id) {
		this.id = niv_id;
	}

	public String niv_pregunta() {
		return niv_pregunta;
	}

	protected void setniv_pregunta(String niv_pregunta) {
		this.niv_pregunta = niv_pregunta;
	}

	public int niv_opcion() {
		return niv_opcion;
	}

	protected void setniv_opcion(int niv_opcion) {
		this.niv_opcion = niv_opcion;
	
	
	
	public String niv_detalle() {
		return niv_detalle;
	}

	protected void setniv_detalle(String niv_detalle) {
		this.niv_detalle = niv_detalle;
	}

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
