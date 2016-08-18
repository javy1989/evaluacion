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
    @NamedQuery(name = "Codigos.findAll", query = "SELECT c FROM Codigos c"),
    @NamedQuery(name = "Codigos.findById", query = "SELECT c FROM Codigos c WHERE c.id = :id"),
    @NamedQuery(name = "Codigos.findByNombre", query = "SELECT c FROM Codigos c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Codigos.findByCodigo", query = "SELECT c FROM Codigos c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "Codigos.findByDescripcion", query = "SELECT c FROM Codigos c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "Codigos.findByParametros", query = "SELECT c FROM Codigos c WHERE c.parametros = :parametros")})
public class Codigos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String nombre;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String codigo;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String descripcion;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String parametros;
    @OneToMany(mappedBy = "estado")
    private List<Matriculados> matriculadosList;
    @OneToMany(mappedBy = "procedenciatipo")
    private List<Matriculados> matriculadosList1;
    @OneToMany(mappedBy = "tipo")
    private List<Instituciones> institucionesList;
    @OneToMany(mappedBy = "tipo")
    private List<Aulas> aulasList;
    @OneToMany(mappedBy = "modulo")
    private List<Grupousuario> grupousuarioList;
    @OneToMany(mappedBy = "grupo")
    private List<Grupousuario> grupousuarioList1;
    @JoinColumn(name = "maestro", referencedColumnName = "id")
    @ManyToOne
    private Maestros maestro;
    @OneToMany(mappedBy = "subnivel")
    private List<Niveles> nivelesList;
    @OneToMany(mappedBy = "referencia")
    private List<Niveles> nivelesList1;
    @OneToMany(mappedBy = "ciclo")
    private List<Niveles> nivelesList2;
    @OneToMany(mappedBy = "tiposangre")
    private List<Entidades> entidadesList;
    @OneToMany(mappedBy = "nacionalidad")
    private List<Entidades> entidadesList1;
    @OneToMany(mappedBy = "genero")
    private List<Entidades> entidadesList2;
    @OneToMany(mappedBy = "estadocivil")
    private List<Entidades> entidadesList3;

    public Codigos() {
    }

    public Codigos(Integer id) {
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getParametros() {
        return parametros;
    }

    public void setParametros(String parametros) {
        this.parametros = parametros;
    }

    @XmlTransient
    public List<Matriculados> getMatriculadosList() {
        return matriculadosList;
    }

    public void setMatriculadosList(List<Matriculados> matriculadosList) {
        this.matriculadosList = matriculadosList;
    }

    @XmlTransient
    public List<Matriculados> getMatriculadosList1() {
        return matriculadosList1;
    }

    public void setMatriculadosList1(List<Matriculados> matriculadosList1) {
        this.matriculadosList1 = matriculadosList1;
    }

    @XmlTransient
    public List<Instituciones> getInstitucionesList() {
        return institucionesList;
    }

    public void setInstitucionesList(List<Instituciones> institucionesList) {
        this.institucionesList = institucionesList;
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
    public List<Grupousuario> getGrupousuarioList1() {
        return grupousuarioList1;
    }

    public void setGrupousuarioList1(List<Grupousuario> grupousuarioList1) {
        this.grupousuarioList1 = grupousuarioList1;
    }

    public Maestros getMaestro() {
        return maestro;
    }

    public void setMaestro(Maestros maestro) {
        this.maestro = maestro;
    }

    @XmlTransient
    public List<Niveles> getNivelesList() {
        return nivelesList;
    }

    public void setNivelesList(List<Niveles> nivelesList) {
        this.nivelesList = nivelesList;
    }

    @XmlTransient
    public List<Niveles> getNivelesList1() {
        return nivelesList1;
    }

    public void setNivelesList1(List<Niveles> nivelesList1) {
        this.nivelesList1 = nivelesList1;
    }

    @XmlTransient
    public List<Niveles> getNivelesList2() {
        return nivelesList2;
    }

    public void setNivelesList2(List<Niveles> nivelesList2) {
        this.nivelesList2 = nivelesList2;
    }

    @XmlTransient
    public List<Entidades> getEntidadesList() {
        return entidadesList;
    }

    public void setEntidadesList(List<Entidades> entidadesList) {
        this.entidadesList = entidadesList;
    }

    @XmlTransient
    public List<Entidades> getEntidadesList1() {
        return entidadesList1;
    }

    public void setEntidadesList1(List<Entidades> entidadesList1) {
        this.entidadesList1 = entidadesList1;
    }

    @XmlTransient
    public List<Entidades> getEntidadesList2() {
        return entidadesList2;
    }

    public void setEntidadesList2(List<Entidades> entidadesList2) {
        this.entidadesList2 = entidadesList2;
    }

    @XmlTransient
    public List<Entidades> getEntidadesList3() {
        return entidadesList3;
    }

    public void setEntidadesList3(List<Entidades> entidadesList3) {
        this.entidadesList3 = entidadesList3;
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
        if (!(object instanceof Codigos)) {
            return false;
        }
        Codigos other = (Codigos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Codigos[ id=" + id + " ]";
    }
    
}
