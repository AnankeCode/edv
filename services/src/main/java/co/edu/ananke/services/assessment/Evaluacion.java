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
@Table(name = "Evaluacion")
public class Evaluacion implements Serializable {

	private static final long serialVersionUID = 1L;

	public static Long nextId = 0L;

	@Id
    protected int eva_id;

	protected String eva_pregunta;

	@Column(name = "Evaluacion")
	protected String usu_tipoid;
	protected int usu_numid;
    private int eva_opcion;
    private String eva_detalle;

	

		}
	}

	

	
	}

	public Evaluacion(String eva_pregunta, int eva_opcion, String eva_detalle) {
		
		this.eva_pregunta = pregunta;
		this.eva_detalle = detalle;
        this. eva_opcion= opcion;
		
	}

	

	
	

	

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

	public int eva_opcion() {
		return eva_opcion;
	}

	protected void seteva_opcion(int eva_opcion) {

		this.eva_opcion = eva_opcion;
	
	
	
	public String eva_detalle() {
		return eva_detalle;
	}

	protected void seteva_detalle(String eva_detalle) {
		this.eva_detalle = eva_detalle;
	
	




}
