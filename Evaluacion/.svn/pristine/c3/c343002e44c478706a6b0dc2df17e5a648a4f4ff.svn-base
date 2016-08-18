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
    @NamedQuery(name = "Aptitudes.findAll", query = "SELECT a FROM Aptitudes a"),
    @NamedQuery(name = "Aptitudes.findByIdaptitudes", query = "SELECT a FROM Aptitudes a WHERE a.idaptitudes = :idaptitudes"),
    @NamedQuery(name = "Aptitudes.findByMinimo", query = "SELECT a FROM Aptitudes a WHERE a.minimo = :minimo"),
    @NamedQuery(name = "Aptitudes.findByMaximo", query = "SELECT a FROM Aptitudes a WHERE a.maximo = :maximo"),
    @NamedQuery(name = "Aptitudes.findByPonderacion", query = "SELECT a FROM Aptitudes a WHERE a.ponderacion = :ponderacion"),
    @NamedQuery(name = "Aptitudes.findByRecomendacion", query = "SELECT a FROM Aptitudes a WHERE a.recomendacion = :recomendacion")})
public class Aptitudes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idaptitudes;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false, precision = 10, scale = 1)
    private BigDecimal minimo;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false, precision = 10, scale = 1)
    private BigDecimal maximo;
    @Size(max = 64)
    @Column(length = 64)
    private String ponderacion;
    @Size(max = 224)
    @Column(length = 224)
    private String recomendacion;
    @JoinColumn(name = "idtest", referencedColumnName = "idtest", nullable = false)
    @ManyToOne(optional = false)
    private Test idtest;
    @OneToMany(mappedBy = "idaptitudes")
    private List<Resultado> resultadoList;

    public Aptitudes() {
    }

    public Aptitudes(Integer idaptitudes) {
        this.idaptitudes = idaptitudes;
    }

    public Aptitudes(Integer idaptitudes, BigDecimal minimo, BigDecimal maximo) {
        this.idaptitudes = idaptitudes;
        this.minimo = minimo;
        this.maximo = maximo;
    }

    public Integer getIdaptitudes() {
        return idaptitudes;
    }

    public void setIdaptitudes(Integer idaptitudes) {
        this.idaptitudes = idaptitudes;
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

    public String getPonderacion() {
        return ponderacion;
    }

    public void setPonderacion(String ponderacion) {
        this.ponderacion = ponderacion;
    }

    public String getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }

    public Test getIdtest() {
        return idtest;
    }

    public void setIdtest(Test idtest) {
        this.idtest = idtest;
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
        hash += (idaptitudes != null ? idaptitudes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aptitudes)) {
            return false;
        }
        Aptitudes other = (Aptitudes) object;
        if ((this.idaptitudes == null && other.idaptitudes != null) || (this.idaptitudes != null && !this.idaptitudes.equals(other.idaptitudes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.eval.Aptitudes[ idaptitudes=" + idaptitudes + " ]";
    }
    
}
