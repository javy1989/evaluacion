/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.soft;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Multimedia
 */
@Entity
@Table(catalog = "nuevaplanificacion", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"direccion"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entidades.findAll", query = "SELECT e FROM Entidades e"),
    @NamedQuery(name = "Entidades.findById", query = "SELECT e FROM Entidades e WHERE e.id = :id"),
    @NamedQuery(name = "Entidades.findByNombres", query = "SELECT e FROM Entidades e WHERE e.nombres = :nombres"),
    @NamedQuery(name = "Entidades.findByApellidos", query = "SELECT e FROM Entidades e WHERE e.apellidos = :apellidos"),
    @NamedQuery(name = "Entidades.findByEmail", query = "SELECT e FROM Entidades e WHERE e.email = :email"),
    @NamedQuery(name = "Entidades.findByUserid", query = "SELECT e FROM Entidades e WHERE e.userid = :userid"),
    @NamedQuery(name = "Entidades.findByPwd", query = "SELECT e FROM Entidades e WHERE e.pwd = :pwd"),
    @NamedQuery(name = "Entidades.findByPin", query = "SELECT e FROM Entidades e WHERE e.pin = :pin"),
    @NamedQuery(name = "Entidades.findByFecha", query = "SELECT e FROM Entidades e WHERE e.fecha = :fecha"),
    @NamedQuery(name = "Entidades.findByRol", query = "SELECT e FROM Entidades e WHERE e.rol = :rol"),
    @NamedQuery(name = "Entidades.findByActivo", query = "SELECT e FROM Entidades e WHERE e.activo = :activo"),
    @NamedQuery(name = "Entidades.findByOcupacion", query = "SELECT e FROM Entidades e WHERE e.ocupacion = :ocupacion"),
    @NamedQuery(name = "Entidades.findByLugartrabajo", query = "SELECT e FROM Entidades e WHERE e.lugartrabajo = :lugartrabajo"),
    @NamedQuery(name = "Entidades.findByFoto", query = "SELECT e FROM Entidades e WHERE e.foto = :foto"),
    @NamedQuery(name = "Entidades.findByUserPassword", query = "SELECT e FROM Entidades e WHERE e.userid = :user and e.pwd = :pass and e.activo = true")})
public class Entidades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String nombres;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String apellidos;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String email;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String userid;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String pwd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(nullable = false, length = 2147483647)
    private String pin;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String rol;
    private Boolean activo;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String ocupacion;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String lugartrabajo;
    private Integer foto;
    @OneToMany(mappedBy = "representante")
    private List<Estudiantes> estudiantesList;
    @OneToMany(mappedBy = "estudiante")
    private List<Estudiantes> estudiantesList1;
    @OneToMany(mappedBy = "profesor")
    private List<Profesores> profesoresList;
    @JoinColumn(name = "direccion", referencedColumnName = "id")
    @OneToOne
    private Direcciones direccion;
    @JoinColumn(name = "tiposangre", referencedColumnName = "id")
    @ManyToOne
    private Codigos tiposangre;
    @JoinColumn(name = "nacionalidad", referencedColumnName = "id")
    @ManyToOne
    private Codigos nacionalidad;
    @JoinColumn(name = "genero", referencedColumnName = "id")
    @ManyToOne
    private Codigos genero;
    @JoinColumn(name = "estadocivil", referencedColumnName = "id")
    @ManyToOne
    private Codigos estadocivil;

    public Entidades() {
    }

    public Entidades(Integer id) {
        this.id = id;
    }

    public Entidades(Integer id, String pin) {
        this.id = id;
        this.pin = pin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getLugartrabajo() {
        return lugartrabajo;
    }

    public void setLugartrabajo(String lugartrabajo) {
        this.lugartrabajo = lugartrabajo;
    }

    public Integer getFoto() {
        return foto;
    }

    public void setFoto(Integer foto) {
        this.foto = foto;
    }

    @XmlTransient
    public List<Estudiantes> getEstudiantesList() {
        return estudiantesList;
    }

    public void setEstudiantesList(List<Estudiantes> estudiantesList) {
        this.estudiantesList = estudiantesList;
    }

    @XmlTransient
    public List<Estudiantes> getEstudiantesList1() {
        return estudiantesList1;
    }

    public void setEstudiantesList1(List<Estudiantes> estudiantesList1) {
        this.estudiantesList1 = estudiantesList1;
    }

    @XmlTransient
    public List<Profesores> getProfesoresList() {
        return profesoresList;
    }

    public void setProfesoresList(List<Profesores> profesoresList) {
        this.profesoresList = profesoresList;
    }

    public Direcciones getDireccion() {
        return direccion;
    }

    public void setDireccion(Direcciones direccion) {
        this.direccion = direccion;
    }

    public Codigos getTiposangre() {
        return tiposangre;
    }

    public void setTiposangre(Codigos tiposangre) {
        this.tiposangre = tiposangre;
    }

    public Codigos getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(Codigos nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Codigos getGenero() {
        return genero;
    }

    public void setGenero(Codigos genero) {
        this.genero = genero;
    }

    public Codigos getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(Codigos estadocivil) {
        this.estadocivil = estadocivil;
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
        if (!(object instanceof Entidades)) {
            return false;
        }
        Entidades other = (Entidades) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Entidades[ id=" + id + " ]";
    }

}
