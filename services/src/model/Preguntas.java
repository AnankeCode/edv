package ServicesEDV.src.model;

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
@Table(name = "preguntas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Preguntas.findAll", query = "SELECT p FROM Preguntas p ")})
public class Preguntas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pre_id")
    private Integer pre_id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pre_detalle")
    
    private String pre_detalle;
    

    public Preguntas() {
    }

    public Preguntas(Integer pre_id) {
        this.pre_id = pre_id;
    }

    public Preguntas(Integer pre_id, String pre_detalle ) {
        this.pre_id = pre_id;
        this.pre_detalle = pre_detalle;
        
    }

    public Integer getPre_id() {
        return pre_id;
    }

    public void setPre_id(Integer pre_id) {
        this.pre_id = pre_id;
    }

    public String getPre_detalle() {
        return pre_detalle;
    }

    public void setpre_detalle(String pre_detalle) {
        this.pre_detalle = pre_detalle;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pre_id != null ?pre_id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
       
        if (!(object instanceof Preguntas)) {
            return false;
        }
        Preguntas other = (Preguntas) object;
        if ((this.pre_id == null && other.pre_id != null) || (this.pre_id != null && !this.pre_id.equals(other.pre_id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Preguntas[ pre_id=" + pre_id + " ]";
    }
    
}
