    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import entidades.eval.Datos;
import entidades.soft.Entidades;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Multimedia
 */
@ManagedBean
@ViewScoped
public class HomeControlador implements Serializable{

    private String nombre;
    private String mensaje;

    public HomeControlador() {
    }

    @PostConstruct
    public void init() {
        Entidades entidad = (Entidades) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("entidad");
        Datos usuario = (Datos) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        if (entidad != null) {
            nombre = entidad.getNombres();
        }
        if (usuario != null) {
            nombre = usuario.getNombre();
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
