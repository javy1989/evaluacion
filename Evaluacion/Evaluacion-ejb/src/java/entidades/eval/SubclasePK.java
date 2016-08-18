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
public class SubclasePK implements Serializable {
    @Basic(optional = false)
    @Column(nullable = false)
    private int idsubclase;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int idclase;

    public SubclasePK() {
    }

    public SubclasePK(int idsubclase, int idclase) {
        this.idsubclase = idsubclase;
        this.idclase = idclase;
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
        hash += (int) idsubclase;
        hash += (int) idclase;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubclasePK)) {
            return false;
        }
        SubclasePK other = (SubclasePK) object;
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
        return "entidades.eval.SubclasePK[ idsubclase=" + idsubclase + ", idclase=" + idclase + " ]";
    }
    
}
