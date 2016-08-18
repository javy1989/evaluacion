/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.eval;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    @NamedQuery(name = "Testuser.findAll", query = "SELECT t FROM Testuser t"),
    @NamedQuery(name = "Testuser.findByIdtestuser", query = "SELECT t FROM Testuser t WHERE t.idtestuser = :idtestuser"),
    @NamedQuery(name = "Testuser.findByIdusuario", query = "SELECT t FROM Testuser t WHERE t.idusuario = :idusuario"),
    @NamedQuery(name = "Testuser.findByFeccreacion", query = "SELECT t FROM Testuser t WHERE t.feccreacion = :fecha and t.idusuario = :idusuario and t.iddetalle.idconfiguracion.asignacion.test.codigo = :codigo"),
    @NamedQuery(name = "Testuser.findByFeccierre", query = "SELECT t FROM Testuser t WHERE t.feccierre = :feccierre"),
    @NamedQuery(name = "Testuser.findByActiva", query = "SELECT t FROM Testuser t WHERE t.activa = :activa"),
    @NamedQuery(name = "Testuser.findByVerificada", query = "SELECT t FROM Testuser t WHERE t.verificada = :verificada"),
    @NamedQuery(name = "Testuser.findByRecomendacion", query = "SELECT t FROM Testuser t WHERE t.recomendacion = :recomendacion")})
public class Testuser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idtestuser;
    @Size(max = 60)
    @Column(nullable = false)
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int idusuario;
    @Temporal(TemporalType.DATE)
    private Date feccreacion;
    @Temporal(TemporalType.DATE)
    private Date feccierre;
    private Boolean activa;
    private Boolean verificada;
    @Size(max = 450)
    @Column(length = 450)
    private String recomendacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "testuser")
    private List<Respuestauser> respuestauserList;
    @OneToMany(mappedBy = "idtestuser")
    private List<Resultado> resultadoList;
    @JoinColumn(name = "idocupacion", referencedColumnName = "idocupacion")
    @ManyToOne
    private Ocupacion idocupacion;
    @JoinColumn(name = "iddetalle", referencedColumnName = "iddetalle")
    @ManyToOne
    private Detallecofig iddetalle;

    public Testuser() {
    }

    public Testuser(Integer idtestuser) {
        this.idtestuser = idtestuser;
    }

    public Testuser(Integer idtestuser, int idusuario) {
        this.idtestuser = idtestuser;
        this.idusuario = idusuario;
    }

    public Integer getIdtestuser() {
        return idtestuser;
    }

    public void setIdtestuser(Integer idtestuser) {
        this.idtestuser = idtestuser;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public Date getFeccreacion() {
        return feccreacion;
    }

    public void setFeccreacion(Date feccreacion) {
        this.feccreacion = feccreacion;
    }

    public Date getFeccierre() {
        return feccierre;
    }

    public void setFeccierre(Date feccierre) {
        this.feccierre = feccierre;
    }

    public Boolean getActiva() {
        return activa;
    }

    public void setActiva(Boolean activa) {
        this.activa = activa;
    }

    public Boolean getVerificada() {
        return verificada;
    }

    public void setVerificada(Boolean verificada) {
        this.verificada = verificada;
    }

    public String getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }

    @XmlTransient
    public List<Respuestauser> getRespuestauserList() {
        return respuestauserList;
    }

    public void setRespuestauserList(List<Respuestauser> respuestauserList) {
        this.respuestauserList = respuestauserList;
    }

    @XmlTransient
    public List<Resultado> getResultadoList() {
        return resultadoList;
    }

    public void setResultadoList(List<Resultado> resultadoList) {
        this.resultadoList = resultadoList;
    }

    public Ocupacion getIdocupacion() {
        return idocupacion;
    }

    public void setIdocupacion(Ocupacion idocupacion) {
        this.idocupacion = idocupacion;
    }

    public Detallecofig getIddetalle() {
        return iddetalle;
    }

    public void setIddetalle(Detallecofig iddetalle) {
        this.iddetalle = iddetalle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtestuser != null ? idtestuser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Testuser)) {
            return false;
        }
        Testuser other = (Testuser) object;
        if ((this.idtestuser == null && other.idtestuser != null) || (this.idtestuser != null && !this.idtestuser.equals(other.idtestuser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.eval.Testuser[ idtestuser=" + idtestuser + " ]";
    }
    
}
