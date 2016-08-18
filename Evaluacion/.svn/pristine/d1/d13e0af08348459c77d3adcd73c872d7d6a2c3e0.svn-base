/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.eval;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Multimedia
 */
@Embeddable
public class PreguntaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idpregunta",nullable = false)
    private int idpregunta;
    @Basic(optional = false)
    @NotNull
    @Column(name="idsubclase",nullable = false)
    private int idsubclase;
    @Basic(optional = false)
    @NotNull
    @Column(name="idclase",nullable = false)
    private int idclase;

    public PreguntaPK() {
    }

    public PreguntaPK(int idpregunta, int idsubclase, int idclase) {
        this.idpregunta = idpregunta;
        this.idsubclase = idsubclase;
        this.idclase = idclase;
    }

    public int getIdpregunta() {
        return idpregunta;
    }

    public void setIdpregunta(int idpregunta) {
        this.idpregunta = idpregunta;
    }

    public int getIdsubclase() {
        return idsubclase;
    }

    public void setIdsubclase(int idsubclase) {
        this.idsubclase = idsubclase;
    }

    public int getIdclase() {
        return idclase;
    }

    public void setIdclase(int idclase) {
        this.idclase = idclase;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idpregunta;
        hash += (int) idsubclase;
        hash += (int) idclase;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PreguntaPK)) {
            return false;
        }
        PreguntaPK other = (PreguntaPK) object;
        if (this.idpregunta != other.idpregunta) {
            return false;
        }
        if (this.idsubclase != other.idsubclase) {
            return false;
        }
        if (this.idclase != other.idclase) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.eval.PreguntaPK[ idpregunta=" + idpregunta + ", idsubclase=" + idsubclase + ", idclase=" + idclase + " ]";
    }
    
}
