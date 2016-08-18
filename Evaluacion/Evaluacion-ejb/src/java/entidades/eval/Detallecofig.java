/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.eval;

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
@Table(catalog = "cuestionario", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallecofig.findAll", query = "SELECT d FROM Detallecofig d"),
    @NamedQuery(name = "Detallecofig.findByIddetalle", query = "SELECT d FROM Detallecofig d WHERE d.iddetalle = :iddetalle"),
    @NamedQuery(name = "Detallecofig.findByIdaniolectivo", query = "SELECT d FROM Detallecofig d WHERE d.idaniolectivo = :idaniolectivo"),
    @NamedQuery(name = "Detallecofig.findByIdnivel", query = "SELECT d FROM Detallecofig d WHERE d.idnivel = :idnivel"),
    @NamedQuery(name = "Detallecofig.findByIdparalelo", query = "SELECT d FROM Detallecofig d WHERE d.idparalelo = :idparalelo"),
    @NamedQuery(name = "Detallecofig.findByTipo", query = "SELECT d FROM Detallecofig d WHERE d.tipo = :tipo"),
    @NamedQuery(name = "Detallecofig.findByActiva", query = "SELECT d FROM Detallecofig d WHERE d.activa = :activa"),
    @NamedQuery(name = "Detallecofig.findByNumero", query = "SELECT d FROM Detallecofig d WHERE d.numero = :numero")})
public class Detallecofig implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer iddetalle;
    private Integer idaniolectivo;
    private Integer idnivel;
    private Integer idparalelo;
    @Size(max = 2)
    @Column(length = 2)
    private String tipo;
    private Boolean activa;
    private Integer numero;
    @JoinColumn(name = "idconfiguracion", referencedColumnName = "idconfiguracion")
    @ManyToOne
    private Configuracion idconfiguracion;
    @OneToMany(mappedBy = "iddetalle")
    private List<Testuser> testuserList;

    public Detallecofig() {
    }

    public Detallecofig(Integer iddetalle) {
        this.iddetalle = iddetalle;
    }

    public Integer getIddetalle() {
        return iddetalle;
    }

    public void setIddetalle(Integer iddetalle) {
        this.iddetalle = iddetalle;
    }

    public Integer getIdaniolectivo() {
        return idaniolectivo;
    }

    public void setIdaniolectivo(Integer idaniolectivo) {
        this.idaniolectivo = idaniolectivo;
    }

    public Integer getIdnivel() {
        return idnivel;
    }

    public void setIdnivel(Integer idnivel) {
        this.idnivel = idnivel;
    }

    public Integer getIdparalelo() {
        return idparalelo;
    }

    public void setIdparalelo(Integer idparalelo) {
        this.idparalelo = idparalelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Boolean getActiva() {
        return activa;
    }

    public void setActiva(Boolean activa) {
        this.activa = activa;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Configuracion getIdconfiguracion() {
        return idconfiguracion;
    }

    public void setIdconfiguracion(Configuracion idconfiguracion) {
        this.idconfiguracion = idconfiguracion;
    }

    @XmlTransient
    public List<Testuser> getTestuserList() {
        return testuserList;
    }

    public void setTestuserList(List<Testuser> testuserList) {
        this.testuserList = testuserList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddetalle != null ? iddetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detallecofig)) {
            return false;
        }
        Detallecofig other = (Detallecofig) object;
        if ((this.iddetalle == null && other.iddetalle != null) || (this.iddetalle != null && !this.iddetalle.equals(other.iddetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.eval.Detallecofig[ iddetalle=" + iddetalle + " ]";
    }
    
}
