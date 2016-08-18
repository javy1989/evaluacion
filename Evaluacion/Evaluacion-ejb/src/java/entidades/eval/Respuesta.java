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
    @NamedQuery(name = "Respuesta.findAll", query = "SELECT r FROM Respuesta r"),
    @NamedQuery(name = "Respuesta.findByIdrespuesta", query = "SELECT r FROM Respuesta r WHERE r.idrespuesta = :idrespuesta"),
    @NamedQuery(name = "Respuesta.findByDescripcion", query = "SELECT r FROM Respuesta r WHERE r.descripcion = :descripcion"),
    @NamedQuery(name = "Respuesta.findByActiva", query = "SELECT r FROM Respuesta r WHERE r.activa = :activa"),
    @NamedQuery(name = "Respuesta.findByCodigo", query = "SELECT r FROM Respuesta r WHERE r.codigo = :codigo"),
    @NamedQuery(name = "Respuesta.findByMultiplica", query = "SELECT r FROM Respuesta r WHERE r.multiplica = :multiplica"),
    @NamedQuery(name = "Respuesta.findByRespuesraGrupoRespuesta", query = "SELECT r FROM Respuesta r WHERE r.idgruporespuesta.idgruporespuesta = :grupo")})
public class Respuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    @NotNull
    private Integer idrespuesta;
    private String descripcion = " ";
    private Boolean activa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(nullable = false, length = 10)
    private String codigo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 10, scale = 1)
    private BigDecimal multiplica;
    @JoinColumn(name = "idgruporespuesta", referencedColumnName = "idgruporespuesta", nullable = false)
    @ManyToOne(optional = false)
    private Gruporespuesta idgruporespuesta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "respuesta")
    private List<Respuestauser> respuestauserList;
    @OneToMany(mappedBy = "idrespuesta")
    private List<Pregunta> preguntaList;

    public Respuesta() {
    }

    public Respuesta(Integer idrespuesta) {
        this.idrespuesta = idrespuesta;
    }

    public Respuesta(Integer idrespuesta, String descripcion, String codigo) {
        this.idrespuesta = idrespuesta;
        this.descripcion = descripcion;
        this.codigo = codigo;
    }

    public Integer getIdrespuesta() {
        return idrespuesta;
    }

    public void setIdrespuesta(Integer idrespuesta) {
        this.idrespuesta = idrespuesta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getActiva() {
        return activa;
    }

    public void setActiva(Boolean activa) {
        this.activa = activa;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getMultiplica() {
        return multiplica;
    }

    public void setMultiplica(BigDecimal multiplica) {
        this.multiplica = multiplica;
    }

    public Gruporespuesta getIdgruporespuesta() {
        return idgruporespuesta;
    }

    public void setIdgruporespuesta(Gruporespuesta idgruporespuesta) {
        this.idgruporespuesta = idgruporespuesta;
    }

    @XmlTransient
    public List<Respuestauser> getRespuestauserList() {
        return respuestauserList;
    }

    public void setRespuestauserList(List<Respuestauser> respuestauserList) {
        this.respuestauserList = respuestauserList;
    }

    @XmlTransient
    public List<Pregunta> getPreguntaList() {
        return preguntaList;
    }

    public void setPreguntaList(List<Pregunta> preguntaList) {
        this.preguntaList = preguntaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrespuesta != null ? idrespuesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Respuesta)) {
            return false;
        }
        Respuesta other = (Respuesta) object;
        if ((this.idrespuesta == null && other.idrespuesta != null) || (this.idrespuesta != null && !this.idrespuesta.equals(other.idrespuesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.eval.Respuesta[ idrespuesta=" + idrespuesta + " ]";
    }

}
