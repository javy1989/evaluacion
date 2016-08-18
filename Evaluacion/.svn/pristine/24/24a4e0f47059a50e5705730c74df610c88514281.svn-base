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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
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
    @NamedQuery(name = "Asignacion.findAll", query = "SELECT a FROM Asignacion a"),
    @NamedQuery(name = "Asignacion.findByIdasignacion", query = "SELECT a FROM Asignacion a WHERE a.asignacionPK.idasignacion = :idasignacion"),
    @NamedQuery(name = "Asignacion.findByIdtest", query = "SELECT a FROM Asignacion a WHERE a.asignacionPK.idtest = :idtest"),
    @NamedQuery(name = "Asignacion.findByIdinstitucion", query = "SELECT a FROM Asignacion a WHERE a.idinstitucion = :idinstitucion AND a.estado=true"),
    @NamedQuery(name = "Asignacion.findByEstado", query = "SELECT a FROM Asignacion a WHERE a.estado = :estado")})
public class Asignacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AsignacionPK asignacionPK;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int idinstitucion;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asignacion")
    private List<Configuracion> configuracionList;
    @JoinColumn(name = "idtest", referencedColumnName = "idtest", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Test test;

    public Asignacion() {
    }

    public Asignacion(AsignacionPK asignacionPK) {
        this.asignacionPK = asignacionPK;
    }

    public Asignacion(AsignacionPK asignacionPK, int idinstitucion, boolean estado) {
        this.asignacionPK = asignacionPK;
        this.idinstitucion = idinstitucion;
        this.estado = estado;
    }

    public Asignacion(int idasignacion, int idtest) {
        this.asignacionPK = new AsignacionPK(idasignacion, idtest);
    }

    public AsignacionPK getAsignacionPK() {
        return asignacionPK;
    }

    public void setAsignacionPK(AsignacionPK asignacionPK) {
        this.asignacionPK = asignacionPK;
    }

    public int getIdinstitucion() {
        return idinstitucion;
    }

    public void setIdinstitucion(int idinstitucion) {
        this.idinstitucion = idinstitucion;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Configuracion> getConfiguracionList() {
        return configuracionList;
    }

    public void setConfiguracionList(List<Configuracion> configuracionList) {
        this.configuracionList = configuracionList;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (asignacionPK != null ? asignacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asignacion)) {
            return false;
        }
        Asignacion other = (Asignacion) object;
        if ((this.asignacionPK == null && other.asignacionPK != null) || (this.asignacionPK != null && !this.asignacionPK.equals(other.asignacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.eval.Asignacion[ asignacionPK=" + asignacionPK + " ]";
    }
    
}
