/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.soft;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Multimedia
 */
@Entity
@Table(catalog = "nuevaplanificacion", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Anioslectivos.findAll", query = "SELECT a FROM Anioslectivos a"),
    @NamedQuery(name = "Anioslectivos.findById", query = "SELECT a FROM Anioslectivos a WHERE a.id = :id"),
    @NamedQuery(name = "Anioslectivos.findByAniolectivo", query = "SELECT a FROM Anioslectivos a WHERE a.aniolectivo = :aniolectivo"),
    @NamedQuery(name = "Anioslectivos.findByFechainicio", query = "SELECT a FROM Anioslectivos a WHERE a.fechainicio = :fechainicio"),
    @NamedQuery(name = "Anioslectivos.findByFechafin", query = "SELECT a FROM Anioslectivos a WHERE a.fechafin = :fechafin"),
    @NamedQuery(name = "Anioslectivos.findByActivo", query = "SELECT a FROM Anioslectivos a WHERE a.activo = :activo"),
    @NamedQuery(name = "Anioslectivos.findByNotamaxima", query = "SELECT a FROM Anioslectivos a WHERE a.notamaxima = :notamaxima"),
    @NamedQuery(name = "Anioslectivos.findByHoraclase", query = "SELECT a FROM Anioslectivos a WHERE a.horaclase = :horaclase"),
    @NamedQuery(name = "Anioslectivos.findByInstitucion", query = "SELECT a FROM Anioslectivos a WHERE a.institucion.id = :id and a.activo=true")})
public class Anioslectivos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String aniolectivo;
    @Temporal(TemporalType.DATE)
    private Date fechainicio;
    @Temporal(TemporalType.DATE)
    private Date fechafin;
    private Boolean activo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 10, scale = 2)
    private BigDecimal notamaxima;
    private Integer horaclase;
    @JoinColumn(name = "institucion", referencedColumnName = "id")
    @ManyToOne
    private Instituciones institucion;
    @OneToMany(mappedBy = "aniolectivo")
    private List<Matriculados> matriculadosList;
    @OneToMany(mappedBy = "aniolectivo")
    private List<Paralelos> paralelosList;

    public Anioslectivos() {
    }

    public Anioslectivos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAniolectivo() {
        return aniolectivo;
    }

    public void setAniolectivo(String aniolectivo) {
        this.aniolectivo = aniolectivo;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public BigDecimal getNotamaxima() {
        return notamaxima;
    }

    public void setNotamaxima(BigDecimal notamaxima) {
        this.notamaxima = notamaxima;
    }

    public Integer getHoraclase() {
        return horaclase;
    }

    public void setHoraclase(Integer horaclase) {
        this.horaclase = horaclase;
    }

    public Instituciones getInstitucion() {
        return institucion;
    }

    public void setInstitucion(Instituciones institucion) {
        this.institucion = institucion;
    }

    @XmlTransient
    public List<Matriculados> getMatriculadosList() {
        return matriculadosList;
    }

    public void setMatriculadosList(List<Matriculados> matriculadosList) {
        this.matriculadosList = matriculadosList;
    }

    @XmlTransient
    public List<Paralelos> getParalelosList() {
        return paralelosList;
    }

    public void setParalelosList(List<Paralelos> paralelosList) {
        this.paralelosList = paralelosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Anioslectivos)) {
            return false;
        }
        Anioslectivos other = (Anioslectivos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Anioslectivos[ id=" + id + " ]";
    }

}
