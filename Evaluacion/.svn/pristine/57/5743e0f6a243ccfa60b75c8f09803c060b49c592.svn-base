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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Multimedia
 */
@Entity
@Table(catalog = "nuevaplanificacion", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"logotipo"}),
    @UniqueConstraint(columnNames = {"direccion"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Instituciones.findAll", query = "SELECT i FROM Instituciones i"),
    @NamedQuery(name = "Instituciones.findById", query = "SELECT i FROM Instituciones i WHERE i.id = :id"),
    @NamedQuery(name = "Instituciones.findByNombre", query = "SELECT i FROM Instituciones i WHERE i.nombre = :nombre"),
    @NamedQuery(name = "Instituciones.findByFecha", query = "SELECT i FROM Instituciones i WHERE i.fecha = :fecha"),
    @NamedQuery(name = "Instituciones.findByRegimen", query = "SELECT i FROM Instituciones i WHERE i.regimen = :regimen"),
    @NamedQuery(name = "Instituciones.findByReligioso", query = "SELECT i FROM Instituciones i WHERE i.religioso = :religioso")})
public class Instituciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String nombre;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    private Boolean regimen;
    private Boolean religioso;
    @OneToMany(mappedBy = "institucion")
    private List<Anioslectivos> anioslectivosList;
    @JoinColumn(name = "logotipo", referencedColumnName = "id")
    @OneToOne
    private Fotos logotipo;
    @JoinColumn(name = "direccion", referencedColumnName = "id")
    @OneToOne
    private Direcciones direccion;
    @JoinColumn(name = "tipo", referencedColumnName = "id")
    @ManyToOne
    private Codigos tipo;
    @OneToMany(mappedBy = "institucion")
    private List<Aulas> aulasList;
    @OneToMany(mappedBy = "institucion")
    private List<Grupousuario> grupousuarioList;
    @OneToMany(mappedBy = "institucion")
    private List<Estudiantes> estudiantesList;
    @OneToMany(mappedBy = "institucion")
    private List<Profesores> profesoresList;

    public Instituciones() {
    }

    public Instituciones(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Boolean getRegimen() {
        return regimen;
    }

    public void setRegimen(Boolean regimen) {
        this.regimen = regimen;
    }

    public Boolean getReligioso() {
        return religioso;
    }

    public void setReligioso(Boolean religioso) {
        this.religioso = religioso;
    }

    @XmlTransient
    public List<Anioslectivos> getAnioslectivosList() {
        return anioslectivosList;
    }

    public void setAnioslectivosList(List<Anioslectivos> anioslectivosList) {
        this.anioslectivosList = anioslectivosList;
    }

    public Fotos getLogotipo() {
        return logotipo;
    }

    public void setLogotipo(Fotos logotipo) {
        this.logotipo = logotipo;
    }

    public Direcciones getDireccion() {
        return direccion;
    }

    public void setDireccion(Direcciones direccion) {
        this.direccion = direccion;
    }

    public Codigos getTipo() {
        return tipo;
    }

    public void setTipo(Codigos tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public List<Aulas> getAulasList() {
        return aulasList;
    }

    public void setAulasList(List<Aulas> aulasList) {
        this.aulasList = aulasList;
    }

    @XmlTransient
    public List<Grupousuario> getGrupousuarioList() {
        return grupousuarioList;
    }

    public void setGrupousuarioList(List<Grupousuario> grupousuarioList) {
        this.grupousuarioList = grupousuarioList;
    }

    @XmlTransient
    public List<Estudiantes> getEstudiantesList() {
        return estudiantesList;
    }

    public void setEstudiantesList(List<Estudiantes> estudiantesList) {
        this.estudiantesList = estudiantesList;
    }

    @XmlTransient
    public List<Profesores> getProfesoresList() {
        return profesoresList;
    }

    public void setProfesoresList(List<Profesores> profesoresList) {
        this.profesoresList = profesoresList;
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
        if (!(object instanceof Instituciones)) {
            return false;
        }
        Instituciones other = (Instituciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Instituciones[ id=" + id + " ]";
    }
    
}
