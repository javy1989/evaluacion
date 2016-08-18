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
    @NamedQuery(name = "Percentil.findAll", query = "SELECT p FROM Percentil p"),
    @NamedQuery(name = "Percentil.findByIdpercentil", query = "SELECT p FROM Percentil p WHERE p.idpercentil = :idpercentil"),
    @NamedQuery(name = "Percentil.findByMinimo", query = "SELECT p FROM Percentil p WHERE p.minimo = :minimo"),
    @NamedQuery(name = "Percentil.findByMaximo", query = "SELECT p FROM Percentil p WHERE p.maximo = :maximo"),
    @NamedQuery(name = "Percentil.findByPercentil", query = "SELECT p FROM Percentil p WHERE p.percentil = :percentil"),
    @NamedQuery(name = "Percentil.findByValor", query = "SELECT p FROM Percentil p where p.subclase.subclasePK.idsubclase = :idsubclase and p.idtest.idtest = :idtest and (p.maximo >= :valor and p.minimo <= :valor)")})
public class Percentil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idpercentil;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false, precision = 10, scale = 1)
    private BigDecimal minimo;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false, precision = 10, scale = 1)
    private BigDecimal maximo;
    @Column(precision = 10, scale = 1)
    private BigDecimal percentil;
    @JoinColumn(name = "idtest", referencedColumnName = "idtest", nullable = false)
    @ManyToOne(optional = false)
    private Test idtest;
    @JoinColumns({
        @JoinColumn(name = "idsubclase", referencedColumnName = "idsubclase", nullable = false),
        @JoinColumn(name = "idclase", referencedColumnName = "idclase", nullable = false)})
    @ManyToOne(optional = false)
    private Subclase subclase;
    @OneToMany(mappedBy = "idpercentil")
    private List<Resultado> resultadoList;

    public Percentil() {
    }

    public Percentil(Integer idpercentil) {
        this.idpercentil = idpercentil;
    }

    public Percentil(Integer idpercentil, BigDecimal minimo, BigDecimal maximo) {
        this.idpercentil = idpercentil;
        this.minimo = minimo;
        this.maximo = maximo;
    }

    public Integer getIdpercentil() {
        return idpercentil;
    }

    public void setIdpercentil(Integer idpercentil) {
        this.idpercentil = idpercentil;
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

    public BigDecimal getPercentil() {
        return percentil;
    }

    public void setPercentil(BigDecimal percentil) {
        this.percentil = percentil;
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
        hash += (idpercentil != null ? idpercentil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Percentil)) {
            return false;
        }
        Percentil other = (Percentil) object;
        if ((this.idpercentil == null && other.idpercentil != null) || (this.idpercentil != null && !this.idpercentil.equals(other.idpercentil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.eval.Percentil[ idpercentil=" + idpercentil + " ]";
    }

}
