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
public class RespuestauserPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int idpregunta;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int idsubclase;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int idclase;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int idrespuesta;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int idtestuser;

    public RespuestauserPK() {
    }

    public RespuestauserPK(int idpregunta, int idsubclase, int idclase, int idrespuesta, int idtestuser) {
        this.idpregunta = idpregunta;
        this.idsubclase = idsubclase;
        this.idclase = idclase;
        this.idrespuesta = idrespuesta;
        this.idtestuser = idtestuser;
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

    public int getIdrespuesta() {
        return idrespuesta;
    }

    public void setIdrespuesta(int idrespuesta) {
        this.idrespuesta = idrespuesta;
    }

    public int getIdtestuser() {
        return idtestuser;
    }

    public void setIdtestuser(int idtestuser) {
        this.idtestuser = idtestuser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idpregunta;
        hash += (int) idsubclase;
        hash += (int) idclase;
        hash += (int) idrespuesta;
        hash += (int) idtestuser;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RespuestauserPK)) {
            return false;
        }
        RespuestauserPK other = (RespuestauserPK) object;
        if (this.idpregunta != other.idpregunta) {
            return false;
        }
        if (this.idsubclase != other.idsubclase) {
            return false;
        }
        if (this.idclase != other.idclase) {
            return false;
        }
        if (this.idrespuesta != other.idrespuesta) {
            return false;
        }
        if (this.idtestuser != other.idtestuser) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.eval.RespuestauserPK[ idpregunta=" + idpregunta + ", idsubclase=" + idsubclase + ", idclase=" + idclase + ", idrespuesta=" + idrespuesta + ", idtestuser=" + idtestuser + " ]";
    }
    
}
