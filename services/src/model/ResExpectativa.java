
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "ResExpectativa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResExpectativa.findAll", query = "SELECT p FROM ResExpectativa p ")})
public class ResExpectativa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rese_id")
    private Integer rese_id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "exp_id")
    private int exp_id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rese_escogida")
    private int rese_escogida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rese_expid")
    private int rese_expid;

    public ResExpectativa() {
    }

    public ResExpectativa(Integer rese_id) {
        this.rese_id = rese_id;
    }

    public ResExpectativa(Integer rese_id, int exp_id,	int rese_escogida, int rese_expid) {
        this.rese_id = rese_id;
        this.exp_id = exp_id;
        
        this.rese_escogida = rese_escogida;
        this.optPosition = optPosition;
    }

    public Integer getRese_id() {
        return rese_id;
    }

    public void setRese_id(Integer rese_id) {
        this.rese_id = rese_id;
    }

    public int getExp_id() {
        return exp_id;
    }

    public void setExp_id(int exp_id) {
        this.exp_id = exp_id;
    }

    public int getRese_escogida() {
        return rese_escogida;
    }

    public void setRese_escogida(int rese_escogida) {
        this.rese_escogida = rese_escogida;
    }

    public int getRese_expid() {
        return rese_expid;
    }

    public void setRese_expid(int rese_expid) {
        this.rese_expid = rese_expid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rese_id != null ? rese_id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof ResExpectativa)) {
            return false;
        }
        ResExpectativa other = (ResExpectativa) object;
        if ((this.rese_id == null && other.rese_id != null) || (this.rese_id != null && !this.rese_id.equals(other.rese_id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ResExpectativa[ rese_id=" + rese_id + " ]";
    }
    
}
