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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(catalog = "cuestionario", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Test.findAll", query = "SELECT t FROM Test t"),
    @NamedQuery(name = "Test.findByIdtest", query = "SELECT t FROM Test t WHERE t.idtest = :idtest"),
    @NamedQuery(name = "Test.findByDescripcion", query = "SELECT t FROM Test t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "Test.findByCodigo", query = "SELECT t FROM Test t WHERE t.codigo = :codigo"),
    @NamedQuery(name = "Test.findByEstado", query = "SELECT t FROM Test t WHERE t.estado = :estado"),
    @NamedQuery(name = "Test.findByNumero", query = "SELECT t FROM Test t WHERE t.numero = :numero")})
public class Test implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idtest;
    @Size(max = 60)
    @Column(length = 60)
    private String descripcion;
    @Size(max = 6)
    @Column(length = 6)
    private String codigo;
    private Boolean estado;
    private Integer numero;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtest")
    private List<Percentil> percentilList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtest")
    private List<Matriz> matrizList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "test")
    private List<Asignacion> asignacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtest")
    private List<Aptitudes> aptitudesList;
    @OneToMany(mappedBy = "idtest")
    private List<Clase> claseList;

    public Test() {
    }

    public Test(Integer idtest) {
        this.idtest = idtest;
    }

    public Integer getIdtest() {
        return idtest;
    }

    public void setIdtest(Integer idtest) {
        this.idtest = idtest;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @XmlTransient
    public List<Percentil> getPercentilList() {
        return percentilList;
    }

    public void setPercentilList(List<Percentil> percentilList) {
        this.percentilList = percentilList;
    }

    @XmlTransient
    public List<Matriz> getMatrizList() {
        return matrizList;
    }

    public void setMatrizList(List<Matriz> matrizList) {
        this.matrizList = matrizList;
    }

    @XmlTransient
    public List<Asignacion> getAsignacionList() {
        return asignacionList;
    }

    public void setAsignacionList(List<Asignacion> asignacionList) {
        this.asignacionList = asignacionList;
    }

    @XmlTransient
    public List<Aptitudes> getAptitudesList() {
        return aptitudesList;
    }

    public void setAptitudesList(List<Aptitudes> aptitudesList) {
        this.aptitudesList = aptitudesList;
    }

    @XmlTransient
    public List<Clase> getClaseList() {
        return claseList;
    }

    public void setClaseList(List<Clase> claseList) {
        this.claseList = claseList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtest != null ? idtest.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Test)) {
            return false;
        }
        Test other = (Test) object;
        if ((this.idtest == null && other.idtest != null) || (this.idtest != null && !this.idtest.equals(other.idtest))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.eval.Test[ idtest=" + idtest + " ]";
    }
    
}
