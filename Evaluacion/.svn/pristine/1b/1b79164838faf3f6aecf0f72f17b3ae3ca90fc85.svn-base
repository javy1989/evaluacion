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
    @NamedQuery(name = "Paralelos.findAll", query = "SELECT p FROM Paralelos p"),
    @NamedQuery(name = "Paralelos.findById", query = "SELECT p FROM Paralelos p WHERE p.id = :id"),
    @NamedQuery(name = "Paralelos.findByParalelo", query = "SELECT p FROM Paralelos p WHERE p.paralelo = :paralelo"),
    @NamedQuery(name = "Paralelos.findByActivo", query = "SELECT p FROM Paralelos p WHERE p.activo = :activo"),
    @NamedQuery(name = "Paralelos.findByAnioNivel", query = "SELECT p FROM Paralelos p WHERE p.aniolectivo.id = :idanio and p.nivel.id = :idnivel and p.activo=true")})
public class Paralelos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String paralelo;
    private Boolean activo;
    @OneToMany(mappedBy = "paralelo")
    private List<Matriculados> matriculadosList;
    @JoinColumn(name = "docente", referencedColumnName = "id")
    @ManyToOne
    private Profesores docente;
    @JoinColumn(name = "nivel", referencedColumnName = "id")
    @ManyToOne
    private Niveles nivel;
    @JoinColumn(name = "aula", referencedColumnName = "id")
    @ManyToOne
    private Aulas aula;
    @JoinColumn(name = "aniolectivo", referencedColumnName = "id")
    @ManyToOne
    private Anioslectivos aniolectivo;

    public Paralelos() {
    }

    public Paralelos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParalelo() {
        return paralelo;
    }

    public void setParalelo(String paralelo) {
        this.paralelo = paralelo;
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

    public Profesores getDocente() {
        return docente;
    }

    public void setDocente(Profesores docente) {
        this.docente = docente;
    }

    public Niveles getNivel() {
        return nivel;
    }

    public void setNivel(Niveles nivel) {
        this.nivel = nivel;
    }

    public Aulas getAula() {
        return aula;
    }

    public void setAula(Aulas aula) {
        this.aula = aula;
    }

    public Anioslectivos getAniolectivo() {
        return aniolectivo;
    }

    public void setAniolectivo(Anioslectivos aniolectivo) {
        this.aniolectivo = aniolectivo;
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
        if (!(object instanceof Paralelos)) {
            return false;
        }
        Paralelos other = (Paralelos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Paralelos[ id=" + id + " ]";
    }

}
