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
    @NamedQuery(name = "Subclase.findAll", query = "SELECT s FROM Subclase s"),
    @NamedQuery(name = "Subclase.findByIdsubclase", query = "SELECT s FROM Subclase s WHERE s.subclasePK.idsubclase = :idsubclase"),
    @NamedQuery(name = "Subclase.findByIdclase", query = "SELECT s FROM Subclase s WHERE s.subclasePK.idclase = :idclase"),
    @NamedQuery(name = "Subclase.findByDetalle", query = "SELECT s FROM Subclase s WHERE s.detalle = :detalle"),
    @NamedQuery(name = "Subclase.findByCodigo", query = "SELECT s FROM Subclase s WHERE s.codigo = :codigo")})
public class Subclase implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SubclasePK subclasePK;
    @Size(max = 48)
    @Column(length = 48)
    private String detalle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(nullable = false, length = 6)
    private String codigo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subclase")
    private List<Percentil> percentilList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subclase")
    private List<Matriz> matrizList;
    @JoinColumn(name = "idclase", referencedColumnName = "idclase", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Clase clase;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subclase")
    private List<Pregunta> preguntaList;
    @OneToMany(mappedBy = "subclase")
    private List<Resultado> resultadoList;

    public Subclase() {
    }

    public Subclase(SubclasePK subclasePK) {
        this.subclasePK = subclasePK;
    }

    public Subclase(SubclasePK subclasePK, String codigo) {
        this.subclasePK = subclasePK;
        this.codigo = codigo;
    }

    public Subclase(int idsubclase, int idclase) {
        this.subclasePK = new SubclasePK(idsubclase, idclase);
    }

    public SubclasePK getSubclasePK() {
        return subclasePK;
    }

    public void setSubclasePK(SubclasePK subclasePK) {
        this.subclasePK = subclasePK;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @XmlTransient
    public List<Percentil> getPercentilList() {
        return percentilList;
    }

    public void setPercentilList(List<Percentil> percentilList) {
        this.percentilList = percentilList;
    }

    @XmlTransient
    public List<Matriz> getMatrizList() {
        return matrizList;
    }

    public void setMatrizList(List<Matriz> matrizList) {
        this.matrizList = matrizList;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    @XmlTransient
    public List<Pregunta> getPreguntaList() {
        return preguntaList;
    }

    public void setPreguntaList(List<Pregunta> preguntaList) {
        this.preguntaList = preguntaList;
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
        hash += (subclasePK != null ? subclasePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subclase)) {
            return false;
        }
        Subclase other = (Subclase) object;
        if ((this.subclasePK == null && other.subclasePK != null) || (this.subclasePK != null && !this.subclasePK.equals(other.subclasePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.eval.Subclase[ subclasePK=" + subclasePK + " ]";
    }
    
}
