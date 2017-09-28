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
@Table(name = "Nivelacion")
public class Nivelacion implements Serializable {

	private static final long serialVersionUID = 1L;

	public static Long nextId = 0L;

	@Id

	protected String niv_id;

	protected int niv_pregunta;

	
	@Column(name = "Nivelacion")
    protected String usu_tipoid;

	protected int usu_numid;	

	private int niv_opcion;

    private String niv_detalle;
	

	}

	public Nivelacion(String niv_pregunta, int niv_opcion, String niv_detalle) {
		id = getNextId();
		this.niv_pregunta = pregunta;
		this.niv_opcion= opcion;
		this.niv_detalle= detalle;

		

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

	

}
