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
    @NamedQuery(name = "Maestros.findAll", query = "SELECT m FROM Maestros m"),
    @NamedQuery(name = "Maestros.findById", query = "SELECT m FROM Maestros m WHERE m.id = :id"),
    @NamedQuery(name = "Maestros.findByCodigo", query = "SELECT m FROM Maestros m WHERE m.codigo = :codigo"),
    @NamedQuery(name = "Maestros.findByNombre", query = "SELECT m FROM Maestros m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "Maestros.findByMudulo", query = "SELECT m FROM Maestros m WHERE m.mudulo = :mudulo")})
public class Maestros implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Size(max = 10)
    @Column(length = 10)
    private String codigo;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String nombre;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String mudulo;
    @OneToMany(mappedBy = "maestro")
    private List<Codigos> codigosList;

    public Maestros() {
    }

    public Maestros(Integer id) {
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

    public String getMudulo() {
        return mudulo;
    }

    public void setMudulo(String mudulo) {
        this.mudulo = mudulo;
    }

    @XmlTransient
    public List<Codigos> getCodigosList() {
        return codigosList;
    }

    public void setCodigosList(List<Codigos> codigosList) {
        this.codigosList = codigosList;
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
        if (!(object instanceof Maestros)) {
            return false;
        }
        Maestros other = (Maestros) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Maestros[ id=" + id + " ]";
    }
    
}
