package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "ResPreguntas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResPreguntas.findAll", query = "SELECT p FROM ResPreguntas p ")})
public class ResPreguntas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "resp_id")
    private Integer resp_id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pre_id")
    private int pre_id;
    @Basic(optional = false)
    @NotNull
    @Column(name = " resp_escogida")
    private int  resp_escogida;
    @Basic(optional = false)
    @NotNull
    @Column(name = " resp_preid")
    private int  resp_preid;

    public ResPreguntas() {
    }

    public ResPreguntas(Integer resp_id) {
        this.resp_id = resp_id;
    }

    public ResPreguntas(Integer resp_id, int pre_id, int  resp_escogida, int  resp_preid) {
        this.resp_id = resp_id;
        this.pre_id = pre_id;
        
        this.resp_escogida = resp_escogida;
        this. resp_preid =  resp_preid;
    }

    public Integer getRese_id() {
        return resp_id;
    }

    public void setResp_id(Integer resp_id) {
        this.resp_id= resp_id;
    }

    public int getPre_id() {
        return pre_id;
    }

    public void setPre_id(int pre_id) {
        this.pre_id = pre_id;
    }

    public int getResp_escogida() {
        return  resp_escogida;
    }

    public void setResp_escogida(int resp_escogida) {
        this. resp_escogida =  resp_escogida;
    }

    public int getResp_preid() {
        return  resp_preid;
    }

    public void setRese_expid(int resp_preid) {
        this. resp_preid =  resp_preid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resp_id != null ? resp_id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof ResPreguntas)) {
            return false;
        }
        ResPreguntas other = (ResPreguntas) object;
        if ((this.resp_id == null && other.resp_id != null) || (this.resp_id != null && !this.resp_id.equals(other.resp_id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ResPreguntas[ resp_id=" + resp_id + " ]";
    }
    
}
