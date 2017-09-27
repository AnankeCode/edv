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
@Table(name = "Evaluacion")
public class Evaluacion implements Serializable {

	private static final long serialVersionUID = 1L;

	public static Long nextId = 0L;

	@Id
	protected String usu_tipoid;

	protected int usu_numid;
	
	protected String eva_id;

	protected int eva_pregunta;

	@Column(name = "Evaluiacion")
	
    private int eva_opcion;
    private String eva_detalle;

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

	public Evaluacion(String eva_pregunta, int eva_opcion, String eva_detalle) {
		id = getNextId();
		this.eva_pregunta = pregunta;
		this. eva_opcion= opcion;
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

	public String geteva_id() {
		return eva_id;
	}

	protected void seteva_id(String eva_id) {
		this.id = eva_id;
	}

	public String eva_pregunta() {
		return eva_pregunta;
	}

	protected void seteva_pregunta(String eva_pregunta) {
		this.eva_pregunta = eva_pregunta;
	}

	public String eva_opcion() {
		return eva_opcion;
	}

	protected void seteva_opcion(String eva_opcion) {
		this.eva_opcion = eva_opcion;
	
	
	
	public String eva_detalle() {
		return eva_detalle;
	}

	protected void seteva_detalle(String eva_detalle) {
		this.eva_detalle = eva_detalle;
	
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
