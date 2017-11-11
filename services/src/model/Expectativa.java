
package model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "expectativa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Expectativa.findAll", query = "SELECT p FROM Expectativa p")})
public class Expectativa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "exp_id")
    private Integer exp_id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "exp_detalle")
    
    private String exp_detalle;
    

    public Expectativa() {
    }

    public Expectativa(Integer exp_id) {
        this.exp_id = exp_id;
    }

    public Expectativa(Integer exp_id, String exp_detalle ) {
        this.exp_id = exp_id;
        this.exp_detalle = exp_detalle;
        
    }

    public Integer getExp_id() {
        return exp_id;
    }

    public void setExp_id(Integer exp_id) {
        this.exp_id = exp_id;
    }

    public String getExp_detalle() {
        return exp_detalle;
    }

    public void setexp_detalle(String exp_detalle) {
        this.exp_detalle = exp_detalle;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (exp_id != null ?exp_id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
       
        if (!(object instanceof Expectativa)) {
            return false;
        }
        Expectativa other = (Expectativa) object;
        if ((this.exp_id == null && other.exp_id != null) || (this.exp_id != null && !this.exp_id.equals(other.exp_id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.expectativa[ exp_id=" + exp_id + " ]";
    }
    
}
