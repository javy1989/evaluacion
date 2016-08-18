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
    @NamedQuery(name = "Niveles.findAll", query = "SELECT n FROM Niveles n"),
    @NamedQuery(name = "Niveles.findById", query = "SELECT n FROM Niveles n WHERE n.id = :id"),
    @NamedQuery(name = "Niveles.findByCodigo", query = "SELECT n FROM Niveles n WHERE n.codigo = :codigo"),
    @NamedQuery(name = "Niveles.findByNombre", query = "SELECT n FROM Niveles n WHERE n.nombre = :nombre")})
public class Niveles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String codigo;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String nombre;
    @OneToMany(mappedBy = "nivel")
    private List<Matriculados> matriculadosList;
    @OneToMany(mappedBy = "nivel")
    private List<Paralelos> paralelosList;
    @OneToMany(mappedBy = "nivelsiguiente")
    private List<Niveles> nivelesList;
    @JoinColumn(name = "nivelsiguiente", referencedColumnName = "id")
    @ManyToOne
    private Niveles nivelsiguiente;
    @OneToMany(mappedBy = "nivelanterior")
    private List<Niveles> nivelesList1;
    @JoinColumn(name = "nivelanterior", referencedColumnName = "id")
    @ManyToOne
    private Niveles nivelanterior;
    @JoinColumn(name = "subnivel", referencedColumnName = "id")
    @ManyToOne
    private Codigos subnivel;
    @JoinColumn(name = "referencia", referencedColumnName = "id")
    @ManyToOne
    private Codigos referencia;
    @JoinColumn(name = "ciclo", referencedColumnName = "id")
    @ManyToOne
    private Codigos ciclo;

    public Niveles() {
    }

    public Niveles(Integer id) {
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    @XmlTransient
    public List<Niveles> getNivelesList() {
        return nivelesList;
    }

    public void setNivelesList(List<Niveles> nivelesList) {
        this.nivelesList = nivelesList;
    }

    public Niveles getNivelsiguiente() {
        return nivelsiguiente;
    }

    public void setNivelsiguiente(Niveles nivelsiguiente) {
        this.nivelsiguiente = nivelsiguiente;
    }

    @XmlTransient
    public List<Niveles> getNivelesList1() {
        return nivelesList1;
    }

    public void setNivelesList1(List<Niveles> nivelesList1) {
        this.nivelesList1 = nivelesList1;
    }

    public Niveles getNivelanterior() {
        return nivelanterior;
    }

    public void setNivelanterior(Niveles nivelanterior) {
        this.nivelanterior = nivelanterior;
    }

    public Codigos getSubnivel() {
        return subnivel;
    }

    public void setSubnivel(Codigos subnivel) {
        this.subnivel = subnivel;
    }

    public Codigos getReferencia() {
        return referencia;
    }

    public void setReferencia(Codigos referencia) {
        this.referencia = referencia;
    }

    public Codigos getCiclo() {
        return ciclo;
    }

    public void setCiclo(Codigos ciclo) {
        this.ciclo = ciclo;
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
        if (!(object instanceof Niveles)) {
            return false;
        }
        Niveles other = (Niveles) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Niveles[ id=" + id + " ]";
    }
    
}
