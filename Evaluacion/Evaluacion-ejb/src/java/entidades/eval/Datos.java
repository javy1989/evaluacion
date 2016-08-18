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
    @NamedQuery(name = "Datos.findAll", query = "SELECT d FROM Datos d"),
    @NamedQuery(name = "Datos.findByIddatos", query = "SELECT d FROM Datos d WHERE d.iddatos = :iddatos"),
    @NamedQuery(name = "Datos.findByNombre", query = "SELECT d FROM Datos d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "Datos.findByApellido", query = "SELECT d FROM Datos d WHERE d.apellido = :apellido"),
    @NamedQuery(name = "Datos.findByDocumento", query = "SELECT d FROM Datos d WHERE d.documento = :documento"),
    @NamedQuery(name = "Datos.findByTipodoc", query = "SELECT d FROM Datos d WHERE d.tipodoc = :tipodoc"),
    @NamedQuery(name = "Datos.findByEmail", query = "SELECT d FROM Datos d WHERE d.email = :email"),
    @NamedQuery(name = "Datos.findByUsuario", query = "SELECT d FROM Datos d WHERE d.usuario = :usuario and d.password = :password")	})
public class Datos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer iddatos;
    @Size(max = 124)
    @Column(length = 124)
    private String nombre;
    @Size(max = 124)
    @Column(length = 124)
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(nullable = false, length = 15)
    private String documento;
    private Character tipodoc;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(length = 100)
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(nullable = false, length = 15)
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddatos")
    private List<Acceso> accesoList;

    public Datos() {
    }

    public Datos(Integer iddatos) {
        this.iddatos = iddatos;
    }

    public Datos(Integer iddatos, String documento, String usuario, String password) {
        this.iddatos = iddatos;
        this.documento = documento;
        this.usuario = usuario;
        this.password = password;
    }

    public Integer getIddatos() {
        return iddatos;
    }

    public void setIddatos(Integer iddatos) {
        this.iddatos = iddatos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Character getTipodoc() {
        return tipodoc;
    }

    public void setTipodoc(Character tipodoc) {
        this.tipodoc = tipodoc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public List<Acceso> getAccesoList() {
        return accesoList;
    }

    public void setAccesoList(List<Acceso> accesoList) {
        this.accesoList = accesoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddatos != null ? iddatos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Datos)) {
            return false;
        }
        Datos other = (Datos) object;
        if ((this.iddatos == null && other.iddatos != null) || (this.iddatos != null && !this.iddatos.equals(other.iddatos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.eval.Datos[ iddatos=" + iddatos + " ]";
    }
    
}
