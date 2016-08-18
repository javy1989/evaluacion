/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.soft;

import java.io.Serializable;
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
    @NamedQuery(name = "Estudiantes.findAll", query = "SELECT e FROM Estudiantes e"),
    @NamedQuery(name = "Estudiantes.findById", query = "SELECT e FROM Estudiantes e WHERE e.id = :id"),
    @NamedQuery(name = "Estudiantes.findByCodigo", query = "SELECT e FROM Estudiantes e WHERE e.codigo = :codigo"),
    @NamedQuery(name = "Estudiantes.findByActivo", query = "SELECT e FROM Estudiantes e WHERE e.activo = :activo"),
    @NamedQuery(name = "Estudiantes.findByRepresentado", query = "SELECT e FROM Estudiantes e WHERE e.representante.id = :id"),
    @NamedQuery(name = "Estudiantes.findByEstudianteEntidad", query = "SELECT e FROM Estudiantes e WHERE e.estudiante.id = :id")})
public class Estudiantes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String codigo;
    private Boolean activo;
    @OneToMany(mappedBy = "estudiante")
    private List<Matriculados> matriculadosList;
    @JoinColumn(name = "institucion", referencedColumnName = "id")
    @ManyToOne
    private Instituciones institucion;
    @JoinColumn(name = "representante", referencedColumnName = "id")
    @ManyToOne
    private Entidades representante;
    @JoinColumn(name = "estudiante", referencedColumnName = "id")
    @ManyToOne
    private Entidades estudiante;

    public Estudiantes() {
    }

    public Estudiantes(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    @XmlTransient
    public List<Matriculados> getMatriculadosList() {
        return matriculadosList;
    }

    public void setMatriculadosList(List<Matriculados> matriculadosList) {
        this.matriculadosList = matriculadosList;
    }

    public Instituciones getInstitucion() {
        return institucion;
    }

    public void setInstitucion(Instituciones institucion) {
        this.institucion = institucion;
    }

    public Entidades getRepresentante() {
        return representante;
    }

    public void setRepresentante(Entidades representante) {
        this.representante = representante;
    }

    public Entidades getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Entidades estudiante) {
        this.estudiante = estudiante;
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
        if (!(object instanceof Estudiantes)) {
            return false;
        }
        Estudiantes other = (Estudiantes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Estudiantes[ id=" + id + " ]";
    }

}
