/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import entidades.eval.Acceso;
import entidades.eval.Datos;
import entidades.soft.Entidades;
import entidades.soft.Grupousuario;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import logica.soft.GrupousuarioFacade;

/**
 *
 * @author Multimedia
 */
@ManagedBean
@SessionScoped
public class MenuControlador {

    @EJB
    private GrupousuarioFacade grupousuarioFacade;

    private List<Grupousuario> usuarioGrupoList;

    private boolean ingreso = Boolean.FALSE;
    private boolean ingresoAdm = Boolean.FALSE;

    private Datos usuario;

    public MenuControlador() {
        usuarioGrupoList = new ArrayList<>();
    }

    @PostConstruct
    public void init() {

            Entidades entidad = (Entidades) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("entidad");
            usuario = (Datos) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        if (entidad == null && usuario == null) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
                FacesContext.getCurrentInstance().getExternalContext().redirect("/Evaluacion-war/inicio.jsf?faces-redirect=true");
            } catch (Exception e) {
                System.out.println("error");
            }
        } else {
            if (entidad != null) {
                ingreso = Boolean.TRUE;
                usuarioGrupoList = grupousuarioFacade.buscaGrupoUsuario(entidad.getPin());
            }
            if (usuario != null) {
                ingresoAdm = Boolean.TRUE;
            }
        }

    }

    public boolean hasRole(String rol) {
                boolean resul = false;
        if (ingreso) {
            for (Grupousuario grupo : usuarioGrupoList) {
                if (grupo.getGrupo() != null) {
                    if (rol.compareTo(grupo.getGrupo().getCodigo()) == 0) {
                        resul = true;
                        break;
                    }
                }

            }
        }

        return resul;
    }

    public boolean hasRoleAdm(String codigo) {
        boolean resul = false;
        if (ingresoAdm) {
            for (Acceso ace : usuario.getAccesoList()) {
                if (ace.getIdperfil().getCodigo().compareTo(codigo) == 0) {
                    resul = true;
                    break;
                }
            }
        }
        return resul;
    }

    public boolean isIngreso() {
        return ingreso;
    }

    public void setIngreso(boolean ingreso) {
        this.ingreso = ingreso;
    }

    public boolean isIngresoAdm() {
        return ingresoAdm;
    }

    public void setIngresoAdm(boolean ingresoAdm) {
        this.ingresoAdm = ingresoAdm;
    }

    public List<Grupousuario> getUsuarioGrupoList() {
        return usuarioGrupoList;
    }

    public void setUsuarioGrupoList(List<Grupousuario> usuarioGrupoList) {
        this.usuarioGrupoList = usuarioGrupoList;
    }

}
