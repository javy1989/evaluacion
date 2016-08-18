/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import entidades.soft.Entidades;
import java.security.NoSuchAlgorithmException;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import logica.soft.EntidadesFacade;
import Seguridad.Crypt;
import entidades.eval.Datos;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.RequestScoped;
import logica.eval.DatosFacade;
import utilidades.MostrarMensaje;

/**
 *
 * @author Multimedia
 */
@ManagedBean
@RequestScoped
public class LoginControlador implements Serializable {

    @ManagedProperty("#{usuarioDataManager}")
    private UsuarioDataManager usuarioDataManager;

    @ManagedProperty("#{usuarioEvalDataManager}")
    private UsuarioEvalDataManager usuarioEvalDataManager;

    @EJB
    private EntidadesFacade entidadesFacade;

    @EJB
    private DatosFacade datosFacade;

    public static final String AUTH_ADM = "app.user.name";
    public static final String AUTH_KEY = "app.user.name";

    public LoginControlador() {
    }

    public String loginIn() throws NoSuchAlgorithmException {

        boolean respuesta = false;
        Entidades entidad = entidadesFacade.entidadBuscada(usuarioDataManager.getEntidad().getUserid(), Crypt.MD5Encriptar(usuarioDataManager.getEntidad().getPwd()));
        if (entidad != null) {
            respuesta = true;
        }
        if (respuesta) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(AUTH_KEY, entidad.getNombres());
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("entidad", entidad);
            return "logeado";
        } else {
            MostrarMensaje.informacion("Información", "Usuario o Claves incorrectas");
            return "fallo";
        }

    }

    public void logoutN() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove(AUTH_KEY);
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext().redirect("/Evaluacion-war");

    }

    public void logoutAd() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove(AUTH_ADM);
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext().redirect("/Evaluacion-war");

    }

    public void logoutException() throws IOException {
        if (AUTH_KEY != null) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove(AUTH_KEY);
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            FacesContext.getCurrentInstance().getExternalContext().redirect("/Evaluacion-war");

        } else {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove(AUTH_ADM);
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            FacesContext.getCurrentInstance().getExternalContext().redirect("/Evaluacion-war");
        }

    }
//login admin 

    public String loginInAdmin() throws NoSuchAlgorithmException {
        boolean respuesta = false;
        Datos usuario = datosFacade.buscaUsuario(usuarioEvalDataManager.getUsuarioEvalManager().getUsuario(), Crypt.MD5Encriptar(usuarioEvalDataManager.getUsuarioEvalManager().getPassword()));
        if (usuario != null) {
            respuesta = true;
        }
        if (respuesta) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(AUTH_ADM, usuario.getNombre());
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuario);
            return "logeadoAdm";
        } else {
            MostrarMensaje.informacion("Información", "Usuario o Claves incorrectas");
            return "falloAdm";
        }
    }

    public UsuarioDataManager getUsuarioDataManager() {
        return usuarioDataManager;
    }

    public void setUsuarioDataManager(UsuarioDataManager usuarioDataManager) {
        this.usuarioDataManager = usuarioDataManager;
    }

    public UsuarioEvalDataManager getUsuarioEvalDataManager() {
        return usuarioEvalDataManager;
    }

    public void setUsuarioEvalDataManager(UsuarioEvalDataManager usuarioEvalDataManager) {
        this.usuarioEvalDataManager = usuarioEvalDataManager;
    }
}
