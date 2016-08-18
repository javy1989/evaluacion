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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
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
    @NamedQuery(name = "Pregunta.findAll", query = "SELECT p FROM Pregunta p"),
    @NamedQuery(name = "Pregunta.findByIdpregunta", query = "SELECT p FROM Pregunta p WHERE p.preguntaPK.idpregunta = :idpregunta"),
    @NamedQuery(name = "Pregunta.findByIdsubclase", query = "SELECT p FROM Pregunta p WHERE p.preguntaPK.idsubclase = :idsubclase"),
    @NamedQuery(name = "Pregunta.findByIdclase", query = "SELECT p FROM Pregunta p WHERE p.preguntaPK.idclase = :idclase"),
    @NamedQuery(name = "Pregunta.findByDetalle", query = "SELECT p FROM Pregunta p WHERE p.detalle = :detalle"),
    @NamedQuery(name = "Pregunta.findByTipo", query = "SELECT p FROM Pregunta p WHERE p.tipo = :tipo"),
    @NamedQuery(name = "Pregunta.findByIdTest", query = "SELECT p FROM Pregunta p WHERE p.subclase.clase.idtest.idtest = :idtest"),
    @NamedQuery(name = "Pregunta.findByIdTestIdClase", query = "SELECT p FROM Pregunta p WHERE p.subclase.clase.idtest.idtest = :idtest AND p.preguntaPK.idclase = :idclase"),
    @NamedQuery(name = "Pregunta.findByIdTestIdClaseIdSubclase", query = "SELECT p FROM Pregunta p WHERE p.subclase.clase.idtest.idtest = :idtest AND p.preguntaPK.idclase = :idclase and p.preguntaPK.idsubclase = :idsubclase"),})

@SqlResultSetMappings({
    @SqlResultSetMapping(name = "mappregunta", entities = {
        @EntityResult(
                entityClass = Pregunta.class, fields = {
                    @FieldResult(name = "idpregunta", column = "idpregunta"),
                    @FieldResult(name = "idsubclase", column = "idsubclase"),
                    @FieldResult(name = "idclase", column = "idclase"),
                    @FieldResult(name = "idgruporespuesta", column = "idgruporespuesta"),
                    @FieldResult(name = "idrespuesta", column = "idrespuesta"),
                    @FieldResult(name = "idfoto", column = "iddoto"),
                    @FieldResult(name = "detalle", column = "detalle"),
                    @FieldResult(name = "tipo", column = "tipo")})})
})
public class Pregunta implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected PreguntaPK preguntaPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "detalle", nullable = false, length = 256)
    private String detalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo", nullable = false)
    private Character tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pregunta")
    private List<Respuestauser> respuestauserList;
    @JoinColumns({
        @JoinColumn(name = "idsubclase", referencedColumnName = "idsubclase", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "idclase", referencedColumnName = "idclase", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Subclase subclase;
    @JoinColumn(name = "idrespuesta", referencedColumnName = "idrespuesta")
    @ManyToOne
    private Respuesta idrespuesta;
    @JoinColumn(name = "idfoto", referencedColumnName = "idimagen")
    @ManyToOne
    private Imagen idfoto;
    @JoinColumn(name = "idgruporespuesta", referencedColumnName = "idgruporespuesta")
    @ManyToOne
    private Gruporespuesta idgruporespuesta;

    public Pregunta() {
    }

    public Pregunta(PreguntaPK preguntaPK) {
        this.preguntaPK = preguntaPK;
    }

    public Pregunta(PreguntaPK preguntaPK, String detalle, Character tipo) {
        this.preguntaPK = preguntaPK;
        this.detalle = detalle;
        this.tipo = tipo;
    }

    public Pregunta(int idpregunta, int idsubclase, int idclase) {
        this.preguntaPK = new PreguntaPK(idpregunta, idsubclase, idclase);
    }

    public PreguntaPK getPreguntaPK() {
        return preguntaPK;
    }

    public void setPreguntaPK(PreguntaPK preguntaPK) {
        this.preguntaPK = preguntaPK;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public List<Respuestauser> getRespuestauserList() {
        return respuestauserList;
    }

    public void setRespuestauserList(List<Respuestauser> respuestauserList) {
        this.respuestauserList = respuestauserList;
    }

    public Subclase getSubclase() {
        return subclase;
    }

    public void setSubclase(Subclase subclase) {
        this.subclase = subclase;
    }

    public Respuesta getIdrespuesta() {
        return idrespuesta;
    }

    public void setIdrespuesta(Respuesta idrespuesta) {
        this.idrespuesta = idrespuesta;
    }

    public Imagen getIdfoto() {
        return idfoto;
    }

    public void setIdfoto(Imagen idfoto) {
        this.idfoto = idfoto;
    }

    public Gruporespuesta getIdgruporespuesta() {
        return idgruporespuesta;
    }

    public void setIdgruporespuesta(Gruporespuesta idgruporespuesta) {
        this.idgruporespuesta = idgruporespuesta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (preguntaPK != null ? preguntaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pregunta)) {
            return false;
        }
        Pregunta other = (Pregunta) object;
        if ((this.preguntaPK == null && other.preguntaPK != null) || (this.preguntaPK != null && !this.preguntaPK.equals(other.preguntaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.eval.Pregunta[ preguntaPK=" + preguntaPK + " ]";
    }

}
