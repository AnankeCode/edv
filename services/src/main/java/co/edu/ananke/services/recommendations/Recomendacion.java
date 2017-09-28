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
@Table(name = "Recomendacion")
public class Recomendacion implements Serializable {

	private static final long serialVersionUID = 1L;

	public static Long nextId = 0L;

	@Id
	
	protected int rec_id;

	

	@Column(name = "Recomendacion")
	protected String rec_detalle;
    protected String usu_tipoid;

	protected int usu_numid;
	
	

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

	public Account(String rec_detalle, int rec_id) {
		id = getNextId();
		this.rec_detalle = detalle ;
		this.rec_id = id;
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

	public String getrec_detalle() {
		return rec_detalle;
	}

	protected void setrec_detalle(String rec_detalle) {
		this.rec_detalle = rec_detalle;
	}

	public int getrec_id() {
		return rec_id;
	}

	protected void setrec_id(String rec_id) {
		this.rec_id = rec_id;
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
