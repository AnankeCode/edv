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
	

	

	
	
	}

	
	

	public Recomendacion(String rec_detalle, int rec_id) {
		
		this.rec_detalle = detalle ;
		this.rec_id = id;
		
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

	

}
