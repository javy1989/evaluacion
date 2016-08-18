/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.soft;

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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Multimedia
 */
@Entity
@Table(catalog = "nuevaplanificacion", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"fotografia"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesores.findAll", query = "SELECT p FROM Profesores p"),
    @NamedQuery(name = "Profesores.findById", query = "SELECT p FROM Profesores p WHERE p.id = :id"),
    @NamedQuery(name = "Profesores.findByActivo", query = "SELECT p FROM Profesores p WHERE p.activo = :activo"),
    @NamedQuery(name = "Profesores.findByFechaingreso", query = "SELECT p FROM Profesores p WHERE p.fechaingreso = :fechaingreso")})
public class Profesores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    private Boolean activo;
    @Temporal(TemporalType.DATE)
    private Date fechaingreso;
    @JoinColumn(name = "institucion", referencedColumnName = "id")
    @ManyToOne
    private Instituciones institucion;
    @JoinColumn(name = "fotografia", referencedColumnName = "id")
    @OneToOne
    private Fotos fotografia;
    @JoinColumn(name = "profesor", referencedColumnName = "id")
    @ManyToOne
    private Entidades profesor;
    @OneToMany(mappedBy = "docente")
    private List<Paralelos> paralelosList;

    public Profesores() {
    }

    public Profesores(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Date getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(Date fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public Instituciones getInstitucion() {
        return institucion;
    }

    public void setInstitucion(Instituciones institucion) {
        this.institucion = institucion;
    }

    public Fotos getFotografia() {
        return fotografia;
    }

    public void setFotografia(Fotos fotografia) {
        this.fotografia = fotografia;
    }

    public Entidades getProfesor() {
        return profesor;
    }

    public void setProfesor(Entidades profesor) {
        this.profesor = profesor;
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
        if (!(object instanceof Profesores)) {
            return false;
        }
        Profesores other = (Profesores) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Profesores[ id=" + id + " ]";
    }
    
}
