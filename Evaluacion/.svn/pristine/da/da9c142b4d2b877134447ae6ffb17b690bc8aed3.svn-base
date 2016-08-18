/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import entidades.eval.Configuracion;
import entidades.eval.Detallecofig;
import entidades.eval.Testuser;
import entidades.soft.Anioslectivos;
import entidades.soft.Entidades;
import entidades.soft.Estudiantes;
import entidades.soft.Grupousuario;
import entidades.soft.Matriculados;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import logica.eval.ConfiguracionFacade;
import logica.eval.TestuserFacade;
import logica.soft.AnioslectivosFacade;
import logica.soft.EstudiantesFacade;
import logica.soft.GrupousuarioFacade;
import logica.soft.MatriculadosFacade;
import utilidades.MostrarMensaje;

/**
 *
 * @author Multimedia
 */
@ManagedBean
@ViewScoped
public class InicioTcemoControlador {

    @EJB
    private GrupousuarioFacade grupousuarioFacade;

    @EJB
    private EstudiantesFacade estudiantesFacade;

    @EJB
    private AnioslectivosFacade anioslectivosFacade;

    @EJB
    private MatriculadosFacade matriculadosFacade;

    @EJB
    private ConfiguracionFacade configuracionFacade;

    @EJB
    private TestuserFacade testuserFacade;
    

    private Entidades entidad;
    private static Grupousuario grupoUsuario;
    private Anioslectivos aniolectivo;
    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private boolean boton;
    private boolean verifica;
    private static Detallecofig detallecofig;

    public InicioTcemoControlador() {
        grupoUsuario = new Grupousuario();
        aniolectivo = new Anioslectivos();
    }

    @PostConstruct
    public void init() {
        boton = Boolean.FALSE;
        verifica = Boolean.FALSE;
        try {
            entidad = (Entidades) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("entidad");
            Calendar calendario = Calendar.getInstance();
            String fec = formatoFecha.format(calendario.getTime());
            Date fecha = formatoFecha.parse(fec);
            List<Testuser> listadoVerifica = testuserFacade.listaTestFecha(fecha, entidad.getId(), "TCEMO");
            if (listadoVerifica.isEmpty()) {
                verifica = Boolean.TRUE;
                List<Configuracion> listaTestFecha = configuracionFacade.listadoConfiguracion("TCEMO", fecha);
                if (listaTestFecha != null && listaTestFecha.size() > 0) {
                    List<Grupousuario> group = grupousuarioFacade.buscaGrupoUsuario(entidad.getPin());
                    if (group != null && group.size() > 0) {
                        grupoUsuario = group.get(0);
                    }
                    List<Anioslectivos> anioLectivos = anioslectivosFacade.listaAnioLectivo(grupoUsuario.getInstitucion().getId());
                    if (anioLectivos != null && anioLectivos.size() > 0) {
                        aniolectivo = anioLectivos.get(0);
                    }
                    Estudiantes estudiante = estudiantesFacade.estudiante(entidad.getId());
                    if (estudiante != null) {
                        List<Matriculados> listaMatriculas = matriculadosFacade.listasMatriculas(estudiante.getId(), aniolectivo.getId());
                        if (listaMatriculas != null && listaMatriculas.size() > 0) {
                            for (Matriculados mat : listaMatriculas) {
                                for (Configuracion cfg : listaTestFecha) {
                                    for (Detallecofig deta : cfg.getDetallecofigList()) {
                                        if (deta.getIdaniolectivo().equals(mat.getAniolectivo().getId())
                                                && deta.getIdnivel().equals(mat.getNivel().getId())
                                                && deta.getIdparalelo().equals(mat.getParalelo().getId())
                                                && deta.getTipo().compareTo("ES") == 0) {
                                            detallecofig = deta;
                                            boton = Boolean.TRUE;
                                            break;
                                        }
                                    }
                                }
                            }

                        }
                    }
                }
            }
        } catch (Exception e) {
            Logger.getLogger(IniciaTcfsoControler.class.getName()).log(Level.SEVERE, null, e);
        }
        if (!boton && verifica) {
            MostrarMensaje.informacion("Información", "Estimado alumno no se asignado ninguna encuesta para realizar");
        } else if (!verifica && !boton) {
            MostrarMensaje.informacion("Información", "Estimado alumno ya a realizado una encuesta asignada");
        }
    }

    public boolean isBoton() {
        return boton;
    }

    public void setBoton(boolean boton) {
        this.boton = boton;
    }

    public boolean isVerifica() {
        return verifica;
    }

    public void setVerifica(boolean verifica) {
        this.verifica = verifica;
    }

    public static Detallecofig getDetallecofig() {
        return detallecofig;
    }

    public static void setDetallecofig(Detallecofig detallecofig) {
        InicioTcemoControlador.detallecofig = detallecofig;
    }

    public static Grupousuario getGrupoUsuario() {
        return grupoUsuario;
    }
    
}
