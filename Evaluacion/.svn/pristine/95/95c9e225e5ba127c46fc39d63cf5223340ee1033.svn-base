/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.eval;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Multimedia
 */
@Entity
@Table(catalog = "cuestionario", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resultado.findAll", query = "SELECT r FROM Resultado r"),
    @NamedQuery(name = "Resultado.findByIdresultado", query = "SELECT r FROM Resultado r WHERE r.idresultado = :idresultado"),
    @NamedQuery(name = "Resultado.findBySubValor", query = "SELECT r FROM Resultado r WHERE r.subValor = :subValor"),
    @NamedQuery(name = "Resultado.findByValor", query = "SELECT r FROM Resultado r WHERE r.valor = :valor"),
    @NamedQuery(name = "Resultado.findByTotal", query = "SELECT r FROM Resultado r WHERE r.total = :total"),
    @NamedQuery(name = "Resultado.findByTestUser", query = "SELECT r FROM Resultado r WHERE r.idtestuser.idtestuser = :idtestuser"),
    @NamedQuery(name = "Resultado.findByClase", query = "SELECT r FROM Resultado r WHERE r.subclase.subclasePK.idclase = :idclase and r.idtestuser.idtestuser = :idtestuser")})
public class Resultado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idresultado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "sub_valor", precision = 10, scale = 1)
    private BigDecimal subValor;
    @Column(precision = 10, scale = 1)
    private BigDecimal valor;
    @Column(precision = 10, scale = 1)
    private BigDecimal total;
    @JoinColumn(name = "idtestuser", referencedColumnName = "idtestuser")
    @ManyToOne
    private Testuser idtestuser;
    @JoinColumns({
        @JoinColumn(name = "idsubclase", referencedColumnName = "idsubclase"),
        @JoinColumn(name = "idclase", referencedColumnName = "idclase")})
    @ManyToOne
    private Subclase subclase;
    @JoinColumn(name = "idpercentil", referencedColumnName = "idpercentil")
    @ManyToOne
    private Percentil idpercentil;
    @JoinColumn(name = "idmatriz", referencedColumnName = "idmatriz")
    @ManyToOne
    private Matriz idmatriz;
    @JoinColumn(name = "idaptitudes", referencedColumnName = "idaptitudes")
    @ManyToOne
    private Aptitudes idaptitudes;

    public Resultado() {
    }

    public Resultado(Integer idresultado) {
        this.idresultado = idresultado;
    }

    public Integer getIdresultado() {
        return idresultado;
    }

    public void setIdresultado(Integer idresultado) {
        this.idresultado = idresultado;
    }

    public BigDecimal getSubValor() {
        return subValor;
    }

    public void setSubValor(BigDecimal subValor) {
        this.subValor = subValor;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Testuser getIdtestuser() {
        return idtestuser;
    }

    public void setIdtestuser(Testuser idtestuser) {
        this.idtestuser = idtestuser;
    }

    public Subclase getSubclase() {
        return subclase;
    }

    public void setSubclase(Subclase subclase) {
        this.subclase = subclase;
    }

    public Percentil getIdpercentil() {
        return idpercentil;
    }

    public void setIdpercentil(Percentil idpercentil) {
        this.idpercentil = idpercentil;
    }

    public Matriz getIdmatriz() {
        return idmatriz;
    }

    public void setIdmatriz(Matriz idmatriz) {
        this.idmatriz = idmatriz;
    }

    public Aptitudes getIdaptitudes() {
        return idaptitudes;
    }

    public void setIdaptitudes(Aptitudes idaptitudes) {
        this.idaptitudes = idaptitudes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idresultado != null ? idresultado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resultado)) {
            return false;
        }
        Resultado other = (Resultado) object;
        if ((this.idresultado == null && other.idresultado != null) || (this.idresultado != null && !this.idresultado.equals(other.idresultado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.eval.Resultado[ idresultado=" + idresultado + " ]";
    }

}
