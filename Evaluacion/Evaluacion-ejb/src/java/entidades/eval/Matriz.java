/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.eval;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.NotNull;
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
    @NamedQuery(name = "Matriz.findAll", query = "SELECT m FROM Matriz m"),
    @NamedQuery(name = "Matriz.findByIdmatriz", query = "SELECT m FROM Matriz m WHERE m.idmatriz = :idmatriz"),
    @NamedQuery(name = "Matriz.findByMinimo", query = "SELECT m FROM Matriz m WHERE m.minimo = :minimo"),
    @NamedQuery(name = "Matriz.findByMaximo", query = "SELECT m FROM Matriz m WHERE m.maximo = :maximo"),
    @NamedQuery(name = "Matriz.findByCategoria", query = "SELECT m FROM Matriz m WHERE m.categoria = :categoria"),
    @NamedQuery(name = "Matriz.findByActiva", query = "SELECT m FROM Matriz m WHERE m.activa = :activa"),
    @NamedQuery(name = "Matriz.findByTotal", query = "SELECT m FROM Matriz m WHERE m.total = :total"),
    @NamedQuery(name = "Matriz.findByValoresClase", query = "SELECT m FROM Matriz m WHERE M.idtest.idtest =:idtest AND m.subclase.subclasePK.idclase = :idclase AND (m.maximo >= :valor and m.minimo <= :valor)"),
    @NamedQuery(name = "Matriz.findByValoresSubclase", query = "SELECT m FROM Matriz m WHERE M.idtest.idtest =:idtest AND M.subclase.subclasePK.idsubclase = :idsubclase AND (m.maximo >= :valor and m.minimo <= :valor)"),
    @NamedQuery(name = "Matriz.findByValoresClaseTotal", query = "SELECT m FROM Matriz m WHERE M.idtest.idtest =:idtest AND (m.maximo >= :valor and m.minimo <= :valor) AND m.total=TRUE"),})
public class Matriz implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idmatriz;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 10, scale = 1)
    private BigDecimal minimo;
    @Column(precision = 10, scale = 1)
    private BigDecimal maximo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 36)
    @Column(nullable = false, length = 36)
    private String categoria;
    private Boolean activa;
    private Boolean total;
    @JoinColumn(name = "idtest", referencedColumnName = "idtest", nullable = false)
    @ManyToOne(optional = false)
    private Test idtest;
    @JoinColumns({
        @JoinColumn(name = "idsubclase", referencedColumnName = "idsubclase", nullable = false),
        @JoinColumn(name = "idclase", referencedColumnName = "idclase", nullable = false)})
    @ManyToOne(optional = false)
    private Subclase subclase;
    @JoinColumn(name = "idocupacion", referencedColumnName = "idocupacion")
    @ManyToOne
    private Ocupacion idocupacion;
    @OneToMany(mappedBy = "idmatriz")
    private List<Resultado> resultadoList;

    public Matriz() {
    }

    public Matriz(Integer idmatriz) {
        this.idmatriz = idmatriz;
    }

    public Matriz(Integer idmatriz, String categoria) {
        this.idmatriz = idmatriz;
        this.categoria = categoria;
    }

    public Integer getIdmatriz() {
        return idmatriz;
    }

    public void setIdmatriz(Integer idmatriz) {
        this.idmatriz = idmatriz;
    }

    public BigDecimal getMinimo() {
        return minimo;
    }

    public void setMinimo(BigDecimal minimo) {
        this.minimo = minimo;
    }

    public BigDecimal getMaximo() {
        return maximo;
    }

    public void setMaximo(BigDecimal maximo) {
        this.maximo = maximo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Boolean getActiva() {
        return activa;
    }

    public void setActiva(Boolean activa) {
        this.activa = activa;
    }

    public Boolean getTotal() {
        return total;
    }

    public void setTotal(Boolean total) {
        this.total = total;
    }

    public Test getIdtest() {
        return idtest;
    }

    public void setIdtest(Test idtest) {
        this.idtest = idtest;
    }

    public Subclase getSubclase() {
        return subclase;
    }

    public void setSubclase(Subclase subclase) {
        this.subclase = subclase;
    }

    public Ocupacion getIdocupacion() {
        return idocupacion;
    }

    public void setIdocupacion(Ocupacion idocupacion) {
        this.idocupacion = idocupacion;
    }

    @XmlTransient
    public List<Resultado> getResultadoList() {
        return resultadoList;
    }

    public void setResultadoList(List<Resultado> resultadoList) {
        this.resultadoList = resultadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmatriz != null ? idmatriz.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matriz)) {
            return false;
        }
        Matriz other = (Matriz) object;
        if ((this.idmatriz == null && other.idmatriz != null) || (this.idmatriz != null && !this.idmatriz.equals(other.idmatriz))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.eval.Matriz[ idmatriz=" + idmatriz + " ]";
    }

}
