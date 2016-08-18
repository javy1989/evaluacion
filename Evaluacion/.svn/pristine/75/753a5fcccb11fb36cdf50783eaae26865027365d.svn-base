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
public class AsignacionPK implements Serializable {
    @Basic(optional = false)
    @Column(nullable = false)
    private int idasignacion;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int idtest;

    public AsignacionPK() {
    }

    public AsignacionPK(int idasignacion, int idtest) {
        this.idasignacion = idasignacion;
        this.idtest = idtest;
    }

    public int getIdasignacion() {
        return idasignacion;
    }

    public void setIdasignacion(int idasignacion) {
        this.idasignacion = idasignacion;
    }

    public int getIdtest() {
        return idtest;
    }

    public void setIdtest(int idtest) {
        this.idtest = idtest;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idasignacion;
        hash += (int) idtest;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsignacionPK)) {
            return false;
        }
        AsignacionPK other = (AsignacionPK) object;
        if (this.idasignacion != other.idasignacion) {
            return false;
        }
        if (this.idtest != other.idtest) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.eval.AsignacionPK[ idasignacion=" + idasignacion + ", idtest=" + idtest + " ]";
    }
    
}
