/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.eval;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Multimedia
 */
@Entity
@Table(catalog = "cuestionario", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Secuencial.findAll", query = "SELECT s FROM Secuencial s"),
    @NamedQuery(name = "Secuencial.findByIdsecuencial", query = "SELECT s FROM Secuencial s WHERE s.idsecuencial = :idsecuencial"),
    @NamedQuery(name = "Secuencial.findBySecuencial", query = "SELECT s FROM Secuencial s WHERE s.secuencial = :secuencial"),
    @NamedQuery(name = "Secuencial.findByDescripcion", query = "SELECT s FROM Secuencial s WHERE s.descripcion = :descripcion"),
    @NamedQuery(name = "Secuencial.findByCodigo", query = "SELECT s FROM Secuencial s WHERE s.codigo = :codigo")})
public class Secuencial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idsecuencial;
    private Integer secuencial;
    @Size(max = 100)
    @Column(length = 100)
    private String descripcion;
    @Size(max = 10)
    @Column(length = 10)
    private String codigo;

    public Secuencial() {
    }

    public Secuencial(Integer idsecuencial) {
        this.idsecuencial = idsecuencial;
    }

    public Integer getIdsecuencial() {
        return idsecuencial;
    }

    public void setIdsecuencial(Integer idsecuencial) {
        this.idsecuencial = idsecuencial;
    }

    public Integer getSecuencial() {
        return secuencial;
    }

    public void setSecuencial(Integer secuencial) {
        this.secuencial = secuencial;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsecuencial != null ? idsecuencial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Secuencial)) {
            return false;
        }
        Secuencial other = (Secuencial) object;
        if ((this.idsecuencial == null && other.idsecuencial != null) || (this.idsecuencial != null && !this.idsecuencial.equals(other.idsecuencial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.eval.Secuencial[ idsecuencial=" + idsecuencial + " ]";
    }
    
}
