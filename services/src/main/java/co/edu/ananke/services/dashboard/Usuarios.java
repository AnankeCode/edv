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

	

		}
	}

	
	

	public Usuarios(String usu_nombre, String usu_correo, int usu_telefono, int usu_celular) {
		
		this.usu_nombre = nombre;
		this.usu_correo = correo;
		this.usu_telefono = telefono;
		this.usu_celular = celular;
		
		
		
	}


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

		return usu_nombre;

	}

	protected void setusu_nombre(String usu_nombre) {
		this.usu_nombre = usu_nombre;
	}
    public String getusu_correo() {
		return usu_correo;
	}


	protected void setusu_correo(String usu_correo) {
		this.usu_correo = usu_correo;
	
	 public int getusu_telefono() {
		return usu_telefono;
	}

	protected void setusu_telefono(int usu_telefono) {
		this.usu_telefono = usu_telefono;
	
	
	 public int getusu_celular() {
		return usu_celular;
	}

	protected void setusu_celular(int usu_celular) {

		this.usu_celular = usu_celular;
	
	
	}
	}
	
