/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.eval;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Multimedia
 */
@Entity
@Table(catalog = "cuestionario", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gruporespuesta.findAll", query = "SELECT g FROM Gruporespuesta g"),
    @NamedQuery(name = "Gruporespuesta.findByIdgruporespuesta", query = "SELECT g FROM Gruporespuesta g WHERE g.idgruporespuesta = :idgruporespuesta"),
    @NamedQuery(name = "Gruporespuesta.findByDetalle", query = "SELECT g FROM Gruporespuesta g WHERE g.detalle = :detalle"),
    @NamedQuery(name = "Gruporespuesta.findByActiva", query = "SELECT g FROM Gruporespuesta g WHERE g.activa = :activa"),
    @NamedQuery(name = "Gruporespuesta.findByCodigo", query = "SELECT g FROM Gruporespuesta g WHERE g.codigo = :codigo")})
public class Gruporespuesta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idgruporespuesta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(nullable = false, length = 60)
    private String detalle;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean activa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(nullable = false, length = 6)
    private String codigo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idgruporespuesta")
    private List<Respuesta> respuestaList;
    @OneToMany(mappedBy = "idgruporespuesta")
    private List<Pregunta> preguntaList;

    public Gruporespuesta() {
    }

    public Gruporespuesta(Integer idgruporespuesta) {
        this.idgruporespuesta = idgruporespuesta;
    }

    public Gruporespuesta(Integer idgruporespuesta, String detalle, boolean activa, String codigo) {
        this.idgruporespuesta = idgruporespuesta;
        this.detalle = detalle;
        this.activa = activa;
        this.codigo = codigo;
    }

    public Integer getIdgruporespuesta() {
        return idgruporespuesta;
    }

    public void setIdgruporespuesta(Integer idgruporespuesta) {
        this.idgruporespuesta = idgruporespuesta;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public boolean getActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @XmlTransient
    public List<Respuesta> getRespuestaList() {
        return respuestaList;
    }

    public void setRespuestaList(List<Respuesta> respuestaList) {
        this.respuestaList = respuestaList;
    }

    @XmlTransient
    public List<Pregunta> getPreguntaList() {
        return preguntaList;
    }

    public void setPreguntaList(List<Pregunta> preguntaList) {
        this.preguntaList = preguntaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgruporespuesta != null ? idgruporespuesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gruporespuesta)) {
            return false;
        }
        Gruporespuesta other = (Gruporespuesta) object;
        if ((this.idgruporespuesta == null && other.idgruporespuesta != null) || (this.idgruporespuesta != null && !this.idgruporespuesta.equals(other.idgruporespuesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.eval.Gruporespuesta[ idgruporespuesta=" + idgruporespuesta + " ]";
    }
    
}
