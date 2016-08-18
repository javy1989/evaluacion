/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.eval;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    @NamedQuery(name = "Configuracion.findAll", query = "SELECT c FROM Configuracion c"),
    @NamedQuery(name = "Configuracion.findByIdconfiguracion", query = "SELECT c FROM Configuracion c WHERE c.idconfiguracion = :idconfiguracion"),
    @NamedQuery(name = "Configuracion.findByFechain", query = "SELECT c FROM Configuracion c WHERE c.fechain = :fechain"),
    @NamedQuery(name = "Configuracion.findByHorain", query = "SELECT c FROM Configuracion c WHERE c.horain = :horain"),
    @NamedQuery(name = "Configuracion.findByFechafin", query = "SELECT c FROM Configuracion c WHERE c.fechafin = :fechafin"),
    @NamedQuery(name = "Configuracion.findByHorafin", query = "SELECT c FROM Configuracion c WHERE c.horafin = :horafin"),
    @NamedQuery(name = "Configuracion.findByActiva", query = "SELECT c FROM Configuracion c WHERE c.activa = :activa"),
    @NamedQuery(name = "Configuracion.findByTestUsuarioIngreso", query = "SELECT c FROM Configuracion c where (:fecha BETWEEN c.inicio and c.cierre) and c.asignacion.test.codigo = :test and c.activa=true")})
public class Configuracion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idconfiguracion;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechain;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horain;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechafin;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horafin;
    private Boolean activa;

    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date inicio;
    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date cierre;
    @JoinColumns({
        @JoinColumn(name = "idasignacion", referencedColumnName = "idasignacion", nullable = false),
        @JoinColumn(name = "idtest", referencedColumnName = "idtest", nullable = false)})
    @ManyToOne(optional = false)
    private Asignacion asignacion;
    @OneToMany(mappedBy = "idconfiguracion")
    private List<Detallecofig> detallecofigList;

    public Configuracion() {
    }

    public Configuracion(Integer idconfiguracion) {
        this.idconfiguracion = idconfiguracion;
    }

    public Configuracion(Integer idconfiguracion, Date fechain, Date horain, Date fechafin, Date horafin) {
        this.idconfiguracion = idconfiguracion;
        this.fechain = fechain;
        this.horain = horain;
        this.fechafin = fechafin;
        this.horafin = horafin;
    }

    public Integer getIdconfiguracion() {
        return idconfiguracion;
    }

    public void setIdconfiguracion(Integer idconfiguracion) {
        this.idconfiguracion = idconfiguracion;
    }

    public Date getFechain() {
        return fechain;
    }

    public void setFechain(Date fechain) {
        this.fechain = fechain;
    }

    public Date getHorain() {
        return horain;
    }

    public void setHorain(Date horain) {
        this.horain = horain;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public Date getHorafin() {
        return horafin;
    }

    public void setHorafin(Date horafin) {
        this.horafin = horafin;
    }

    public Boolean getActiva() {
        return activa;
    }

    public void setActiva(Boolean activa) {
        this.activa = activa;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getCierre() {
        return cierre;
    }

    public void setCierre(Date cierre) {
        this.cierre = cierre;
    }

    public Asignacion getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(Asignacion asignacion) {
        this.asignacion = asignacion;
    }

    @XmlTransient
    public List<Detallecofig> getDetallecofigList() {
        return detallecofigList;
    }

    public void setDetallecofigList(List<Detallecofig> detallecofigList) {
        this.detallecofigList = detallecofigList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idconfiguracion != null ? idconfiguracion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Configuracion)) {
            return false;
        }
        Configuracion other = (Configuracion) object;
        if ((this.idconfiguracion == null && other.idconfiguracion != null) || (this.idconfiguracion != null && !this.idconfiguracion.equals(other.idconfiguracion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.eval.Configuracion[ idconfiguracion=" + idconfiguracion + " ]";
    }

}
