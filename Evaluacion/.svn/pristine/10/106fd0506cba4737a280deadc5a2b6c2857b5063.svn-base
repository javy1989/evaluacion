/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.soft;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Multimedia
 */
@Entity
@Table(catalog = "nuevaplanificacion", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"fotografia"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Matriculados.findAll", query = "SELECT m FROM Matriculados m"),
    @NamedQuery(name = "Matriculados.findById", query = "SELECT m FROM Matriculados m WHERE m.id = :id"),
    @NamedQuery(name = "Matriculados.findByProcedencia", query = "SELECT m FROM Matriculados m WHERE m.procedencia = :procedencia"),
    @NamedQuery(name = "Matriculados.findByProcedenciadir", query = "SELECT m FROM Matriculados m WHERE m.procedenciadir = :procedenciadir"),
    @NamedQuery(name = "Matriculados.findByFecha", query = "SELECT m FROM Matriculados m WHERE m.fecha = :fecha"),
    @NamedQuery(name = "Matriculados.findByParentesco", query = "SELECT m FROM Matriculados m WHERE m.parentesco = :parentesco"),
    @NamedQuery(name = "Matriculados.findByPromovido", query = "SELECT m FROM Matriculados m WHERE m.promovido = :promovido"),
    @NamedQuery(name = "Matriculados.findByNromatricula", query = "SELECT m FROM Matriculados m WHERE m.nromatricula = :nromatricula"),
    @NamedQuery(name = "Matriculados.findByNrofolio", query = "SELECT m FROM Matriculados m WHERE m.nrofolio = :nrofolio"),
    @NamedQuery(name = "Matriculados.findByNro", query = "SELECT m FROM Matriculados m WHERE m.nro = :nro"),
    @NamedQuery(name = "Matriculados.findByEstudianteAnioLectivo", query = "SELECT m FROM Matriculados m WHERE m.estudiante.id = :idestudiante and m.aniolectivo.id = :idaniolectivo")})
public class Matriculados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String procedencia;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String procedenciadir;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String parentesco;
    private Boolean promovido;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String nromatricula;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String nrofolio;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String nro;
    @JoinColumn(name = "paralelo", referencedColumnName = "id")
    @ManyToOne
    private Paralelos paralelo;
    @JoinColumn(name = "nivel", referencedColumnName = "id")
    @ManyToOne
    private Niveles nivel;
    @JoinColumn(name = "fotografia", referencedColumnName = "id")
    @OneToOne
    private Fotos fotografia;
    @JoinColumn(name = "estudiante", referencedColumnName = "id")
    @ManyToOne
    private Estudiantes estudiante;
    @JoinColumn(name = "estado", referencedColumnName = "id")
    @ManyToOne
    private Codigos estado;
    @JoinColumn(name = "procedenciatipo", referencedColumnName = "id")
    @ManyToOne
    private Codigos procedenciatipo;
    @JoinColumn(name = "aniolectivo", referencedColumnName = "id")
    @ManyToOne
    private Anioslectivos aniolectivo;

    public Matriculados() {
    }

    public Matriculados(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public String getProcedenciadir() {
        return procedenciadir;
    }

    public void setProcedenciadir(String procedenciadir) {
        this.procedenciadir = procedenciadir;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public Boolean getPromovido() {
        return promovido;
    }

    public void setPromovido(Boolean promovido) {
        this.promovido = promovido;
    }

    public String getNromatricula() {
        return nromatricula;
    }

    public void setNromatricula(String nromatricula) {
        this.nromatricula = nromatricula;
    }

    public String getNrofolio() {
        return nrofolio;
    }

    public void setNrofolio(String nrofolio) {
        this.nrofolio = nrofolio;
    }

    public String getNro() {
        return nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }

    public Paralelos getParalelo() {
        return paralelo;
    }

    public void setParalelo(Paralelos paralelo) {
        this.paralelo = paralelo;
    }

    public Niveles getNivel() {
        return nivel;
    }

    public void setNivel(Niveles nivel) {
        this.nivel = nivel;
    }

    public Fotos getFotografia() {
        return fotografia;
    }

    public void setFotografia(Fotos fotografia) {
        this.fotografia = fotografia;
    }

    public Estudiantes getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiantes estudiante) {
        this.estudiante = estudiante;
    }

    public Codigos getEstado() {
        return estado;
    }

    public void setEstado(Codigos estado) {
        this.estado = estado;
    }

    public Codigos getProcedenciatipo() {
        return procedenciatipo;
    }

    public void setProcedenciatipo(Codigos procedenciatipo) {
        this.procedenciatipo = procedenciatipo;
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
        if (!(object instanceof Matriculados)) {
            return false;
        }
        Matriculados other = (Matriculados) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Matriculados[ id=" + id + " ]";
    }

}
