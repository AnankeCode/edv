package io.pivotal.microservices.accounts;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
  
 * @author SantiPurdy
 */
@Entity
@Table(name = "Usuarios")
public class Usuarios implements Serializable {

	private static final long serialVersionUID = 1L;

	public static Long nextId = 0L;

	@Id
	protected String usu_tipoid;

	protected int usu_numid;

	@Column(name = "Usuarios")
	private String usu_nombre;
    private String usu_correo;
    private int usu_telefono;
    private int usu_celular;

	/**
	 * This is a very simple, and non-scalable solution to generating unique
	 * ids. Not recommended for a real application. Consider using the
	 * <tt>@GeneratedValue</tt> annotation and a sequence to generate ids.
	 * 
	 * @return The next available id.
	 */
	protected static Long getNextusu_tipoid() {
		synchronized (nextusu_tipoid) {
			return nextusu_tipoid++;
		}
	}

	/**
	 * Default constructor for JPA only.
	 */
	protected Usuarios() {
		balance = BigDecimal.ZERO;
	}

	public Usuarios(String usu_nombre, String usu_correo, int usu_telefono, int usu_celular) {
		id = getNextusu_tipoid();
		id1= getNextusu_numid();
		this.usu_nombre = nombre;
		this.usu_correo = correo;
		this.usu_telefono = telefono;
		this.usu_celular = celular;
		
		
		balance = BigDecimal.ZERO;
	}

	public String getusu_tipoid() {
		return usu_tipoid;
	}

	/**
	 * Set JPA id - for testing and JPA only. Not intended for normal use.
	 * 
	 * @param id
	 *            The new id.
	 */
	protected void setusu_tipoid(String usu_tipoid) {
		this.usu_tipoid = usu_tipoid;
	}

	public int getusu_numid() {
		return usu_numid;
	}

	protected void setusu_numid(int usuariosusu_numid) {
		this.usu_numid = usuariosusu_numid;
	}

	public String getusu_nombre() {
		return owner;
	}

	protected void setusu_nombre(String usu_nombre) {
		this.usu_nombre = usu_nombre;
	}
    public String getusu_correo() {
		return usu_correo;
	}

	protected void setusu_correo(int usu_correo) {
		this.usu_correo = usu_correo;
	
	 public Stri getusu_telefono() {
		return usu_telefono;
	}

	protected void setusu_telefono(String usu_telefono) {
		this.usu_telefono = usu_telefono;
	
	
	 public String getusu_celular() {
		return usu_celular;
	}

	protected void setusu_celular(String usu_celular) {
		this.usu_celular = usu_celular;
	
	public string getBalance() {
		return balance.setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}

	public void withdraw(BigDecimal amount) {
		balance.subtract(amount);
	}

	public void deposit(BigDecimal amount) {
		balance.add(amount);
	}

	
