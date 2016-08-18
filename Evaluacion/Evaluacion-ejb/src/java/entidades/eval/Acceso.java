/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.eval;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Multimedia
 */
@Entity
@Table(catalog = "cuestionario", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acceso.findAll", query = "SELECT a FROM Acceso a"),
    @NamedQuery(name = "Acceso.findByIdacceso", query = "SELECT a FROM Acceso a WHERE a.idacceso = :idacceso"),
    @NamedQuery(name = "Acceso.findByEstado", query = "SELECT a FROM Acceso a WHERE a.estado = :estado"),
    @NamedQuery(name = "Acceso.findByIdinstitucion", query = "SELECT a FROM Acceso a WHERE a.idinstitucion = :idinstitucion"),
    @NamedQuery(name = "Acceso.findByIdDatos", query = "SELECT a FROM Acceso a WHERE a.iddatos.iddatos = :iddatos")})
public class Acceso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idacceso;
    private Boolean estado;
    private Integer idinstitucion;
    @JoinColumn(name = "idperfil", referencedColumnName = "idperfil", nullable = false)
    @ManyToOne(optional = false)
    private Perfil idperfil;
    @JoinColumn(name = "iddatos", referencedColumnName = "iddatos", nullable = false)
    @ManyToOne(optional = false)
    private Datos iddatos;

    public Acceso() {
    }

    public Acceso(Integer idacceso) {
        this.idacceso = idacceso;
    }

    public Integer getIdacceso() {
        return idacceso;
    }

    public void setIdacceso(Integer idacceso) {
        this.idacceso = idacceso;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Integer getIdinstitucion() {
        return idinstitucion;
    }

    public void setIdinstitucion(Integer idinstitucion) {
        this.idinstitucion = idinstitucion;
    }

    public Perfil getIdperfil() {
        return idperfil;
    }

    public void setIdperfil(Perfil idperfil) {
        this.idperfil = idperfil;
    }

    public Datos getIddatos() {
        return iddatos;
    }

    public void setIddatos(Datos iddatos) {
        this.iddatos = iddatos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idacceso != null ? idacceso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acceso)) {
            return false;
        }
        Acceso other = (Acceso) object;
        if ((this.idacceso == null && other.idacceso != null) || (this.idacceso != null && !this.idacceso.equals(other.idacceso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.eval.Acceso[ idacceso=" + idacceso + " ]";
    }

}
