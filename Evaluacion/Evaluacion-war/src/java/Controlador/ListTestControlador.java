/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import entidades.eval.Acceso;
import entidades.eval.Asignacion;
import entidades.eval.Configuracion;
import entidades.eval.Datos;
import entidades.eval.Detallecofig;
import entidades.soft.Grupousuario;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import logica.eval.AccesoFacade;
import logica.eval.AsignacionFacade;
import logica.eval.ConfiguracionFacade;
import logica.eval.DetallecofigFacade;
import logica.soft.GrupousuarioFacade;
import utilidades.MostrarMensaje;

/**
 *
 * @author Multimedia
 */
@ManagedBean
@ViewScoped
public class ListTestControlador extends BaseControlador{

    @EJB
    private ConfiguracionFacade configuracionFacade;
    @EJB
    private AccesoFacade accesoFacade;
    @EJB
    private GrupousuarioFacade grupousuarioFacade;
    @EJB
    private AsignacionFacade asignacionFacade;
    @EJB
    private DetallecofigFacade detallecofigFacade;

    private List<Configuracion> listaConfiguracion;

    private List<Asignacion> listaAsignacion;


    private Acceso acceso;
    private Datos usuario;
    private Grupousuario grupousuario;
    private Configuracion configuracionSelect;
    public ListTestControlador() {
        listaAsignacion = new ArrayList<>();
    }

    @PostConstruct
    public void init() {
        usuario = (Datos) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        acceso = accesoFacade.acceso(usuario.getIddatos());
        List<Grupousuario> group = grupousuarioFacade.buscaGrupoUsuario(usuario.getDocumento());
        if (group != null && group.size() > 0) {
            grupousuario = group.get(0);
        }
        
        getListaAsignacion();
    }

    public List<Asignacion> getListaAsignacion() {
        listaAsignacion = asignacionFacade.buscaAsignacion(grupousuario.getInstitucion().getId());
        return listaAsignacion;
    }

    public List<Configuracion> getListaConfiguracion() {
        listaConfiguracion = new ArrayList<>();
        for (Asignacion as : listaAsignacion) {
            for (Configuracion con : as.getConfiguracionList()) {
                if(con.getActiva()){
                    listaConfiguracion.add(con);
                }
            }
        }
        return listaConfiguracion;
    }
    
        public void activarDesactivar() throws SystemException {
        Calendar cal = Calendar.getInstance();
        if (configuracionSelect.getActiva()) {
            configuracionSelect.setActiva(Boolean.FALSE);
        } else {
            configuracionSelect.setActiva(Boolean.TRUE);
        }
        try {
            if (configuracionSelect.getActiva()) {
                if (configuracionSelect.getFechafin().before(cal.getTime())) {
                    transaccion.begin();
                    for (Detallecofig de : configuracionSelect.getDetallecofigList()) {
                        de.setActiva(configuracionSelect.getActiva());
                        detallecofigFacade.edit(de);
                    }
                    configuracionFacade.edit(configuracionSelect);
                    transaccion.commit();
                    MostrarMensaje.informacion("Información", configuracionSelect.getActiva() ? "Test activado con exito" : "Test inactivado");
                } else {
                    MostrarMensaje.warning("Información", "No se permite activar un test con la fecha de finalización antes de la fecha actual");
                }
            } else {
                transaccion.begin();
                for (Detallecofig de : configuracionSelect.getDetallecofigList()) {
                    de.setActiva(configuracionSelect.getActiva());
                    detallecofigFacade.edit(de);
                }
                configuracionFacade.edit(configuracionSelect);
                transaccion.commit();
                MostrarMensaje.informacion("Información","Registro exitoso");
                getListaAsignacion();
            }

        } catch (NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException ex) {
            transaccion.rollback();
        }
    }


    public Configuracion getConfiguracionSelect() {
        return configuracionSelect;
    }

    public void setConfiguracionSelect(Configuracion configuracionSelect) {
        this.configuracionSelect = configuracionSelect;
    }

    
}
