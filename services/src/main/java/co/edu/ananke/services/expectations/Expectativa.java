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

@Table(name = "Expectativa")

public class Expectativa implements Serializable {

	private static final long serialVersionUID = 1L;

	public static Long nextId = 0L;

	@Id

	
	protected String exp_pregunta;

	protected int exp_id;


	@Column(name = "Expectativa")
	protected String usu_tipoid;

	protected int usu_numid;

	
    private int exp_opcion;
    

	

	public Expectativa(int exp_opcion , String exp_pregunta , String exp_detalle) {
		
		this.exp_pregunta = pregunta;
		this.exp_opcion = opcion;
		this.exp_detalle = detalle;

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


	public int getexp_opcion() {
		return exp_opcion;
	}

	protected void setexp_opcion(int exp_opcion) {
		this.exp_opcion = exp_opcion;
	
	
	public String getexp_detalle() {
		return exp_detalle;
	}

	protected void setexp_detalle(String exp_detalle) {
		this.exp_detalle= exp_detalle;
	


}
	}