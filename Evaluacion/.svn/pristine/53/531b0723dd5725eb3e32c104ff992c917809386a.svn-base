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
    @NamedQuery(name = "Clase.findAll", query = "SELECT c FROM Clase c"),
    @NamedQuery(name = "Clase.findByIdclase", query = "SELECT c FROM Clase c WHERE c.idclase = :idclase"),
    @NamedQuery(name = "Clase.findByDetalle", query = "SELECT c FROM Clase c WHERE c.detalle = :detalle"),
    @NamedQuery(name = "Clase.findByIdTest", query = "SELECT c FROM Clase c WHERE c.idtest.idtest = :idtest")})
public class Clase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idclase;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 48)
    @Column(nullable = false, length = 48)
    private String detalle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clase")
    private List<Subclase> subclaseList;
    @JoinColumn(name = "idtest", referencedColumnName = "idtest")
    @ManyToOne
    private Test idtest;

    public Clase() {
    }

    public Clase(Integer idclase) {
        this.idclase = idclase;
    }

    public Clase(Integer idclase, String detalle) {
        this.idclase = idclase;
        this.detalle = detalle;
    }

    public Integer getIdclase() {
        return idclase;
    }

    public void setIdclase(Integer idclase) {
        this.idclase = idclase;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    @XmlTransient
    public List<Subclase> getSubclaseList() {
        return subclaseList;
    }

    public void setSubclaseList(List<Subclase> subclaseList) {
        this.subclaseList = subclaseList;
    }

    public Test getIdtest() {
        return idtest;
    }

    public void setIdtest(Test idtest) {
        this.idtest = idtest;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idclase != null ? idclase.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clase)) {
            return false;
        }
        Clase other = (Clase) object;
        if ((this.idclase == null && other.idclase != null) || (this.idclase != null && !this.idclase.equals(other.idclase))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.eval.Clase[ idclase=" + idclase + " ]";
    }

}
