/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.eval;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Multimedia
 */
@Entity
@Table(catalog = "cuestionario", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Respuestauser.findAll", query = "SELECT r FROM Respuestauser r"),
    @NamedQuery(name = "Respuestauser.findByIdpregunta", query = "SELECT r FROM Respuestauser r WHERE r.respuestauserPK.idpregunta = :idpregunta"),
    @NamedQuery(name = "Respuestauser.findByIdsubclase", query = "SELECT r FROM Respuestauser r WHERE r.respuestauserPK.idsubclase = :idsubclase"),
    @NamedQuery(name = "Respuestauser.findByIdclase", query = "SELECT r FROM Respuestauser r WHERE r.respuestauserPK.idclase = :idclase"),
    @NamedQuery(name = "Respuestauser.findByIdrespuesta", query = "SELECT r FROM Respuestauser r WHERE r.respuestauserPK.idrespuesta = :idrespuesta"),
    @NamedQuery(name = "Respuestauser.findByIdtestuser", query = "SELECT r FROM Respuestauser r WHERE r.respuestauserPK.idtestuser = :idtestuser"),
    @NamedQuery(name = "Respuestauser.findByFecha", query = "SELECT r FROM Respuestauser r WHERE r.fecha = :fecha")})
public class Respuestauser implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RespuestauserPK respuestauserPK;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "idtestuser", referencedColumnName = "idtestuser", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Testuser testuser;
    @JoinColumn(name = "idrespuesta", referencedColumnName = "idrespuesta", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Respuesta respuesta;
    @JoinColumns({
        @JoinColumn(name = "idpregunta", referencedColumnName = "idpregunta", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "idsubclase", referencedColumnName = "idsubclase", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "idclase", referencedColumnName = "idclase", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Pregunta pregunta;

    public Respuestauser() {
    }

    public Respuestauser(RespuestauserPK respuestauserPK) {
        this.respuestauserPK = respuestauserPK;
    }

    public Respuestauser(RespuestauserPK respuestauserPK, Date fecha) {
        this.respuestauserPK = respuestauserPK;
        this.fecha = fecha;
    }

    public Respuestauser(int idpregunta, int idsubclase, int idclase, int idrespuesta, int idtestuser) {
        this.respuestauserPK = new RespuestauserPK(idpregunta, idsubclase, idclase, idrespuesta, idtestuser);
    }

    public RespuestauserPK getRespuestauserPK() {
        return respuestauserPK;
    }

    public void setRespuestauserPK(RespuestauserPK respuestauserPK) {
        this.respuestauserPK = respuestauserPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Testuser getTestuser() {
        return testuser;
    }

    public void setTestuser(Testuser testuser) {
        this.testuser = testuser;
    }

    public Respuesta getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Respuesta respuesta) {
        this.respuesta = respuesta;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (respuestauserPK != null ? respuestauserPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Respuestauser)) {
            return false;
        }
        Respuestauser other = (Respuestauser) object;
        if ((this.respuestauserPK == null && other.respuestauserPK != null) || (this.respuestauserPK != null && !this.respuestauserPK.equals(other.respuestauserPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.eval.Respuestauser[ respuestauserPK=" + respuestauserPK + " ]";
    }
    
}
