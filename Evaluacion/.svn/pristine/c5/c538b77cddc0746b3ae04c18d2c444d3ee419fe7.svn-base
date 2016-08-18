/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import entidades.eval.Acceso;
import entidades.eval.Clase;
import entidades.eval.Detallecofig;
import entidades.eval.Pregunta;
import entidades.eval.Respuesta;
import entidades.eval.Respuestauser;
import entidades.eval.RespuestauserPK;
import entidades.eval.Resultado;
import entidades.eval.Secuencial;
import entidades.eval.Subclase;
import entidades.eval.Test;
import entidades.eval.Testuser;
import entidades.soft.Entidades;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import logica.eval.AccesoFacade;
import logica.eval.MatrizFacade;
import logica.eval.PreguntaFacade;
import logica.eval.RespuestauserFacade;
import logica.eval.ResultadoFacade;
import logica.eval.SecuencialFacade;
import logica.eval.TestFacade;
import logica.eval.TestuserFacade;
import org.primefaces.context.RequestContext;
import utilidades.MostrarMensaje;

/**
 *
 * @author Multimedia
 */
@ManagedBean
@SessionScoped
public class TestTadiControler {

    @EJB
    private TestFacade testFacade;

    @EJB
    private RespuestauserFacade respuestauserFacade;
    @EJB
    private TestuserFacade testuserFacade;

    @EJB
    private ResultadoFacade resultadoFacade;
    @EJB
    private MatrizFacade matrizFacade;
    @EJB
    private SecuencialFacade secuencialFacade;
    @EJB
    private AccesoFacade accesoFacade;
    @EJB
    private PreguntaFacade preguntaFacade;

    private List<Subclase> listaSubClase;
    private List<Respuestauser> listaRespuestaUsuario;
    private List<Pregunta> listaPregunta;
    private RespuestauserPK respuestauserPK;
    private Respuestauser respuestauser;
    private Respuesta nuevaRespuesta;
    private List<Respuesta> listaRespuesta;
    private List<Pregunta> listaRandomPregunta;
    private Test testActual;
    private static Testuser testuser;
    private Entidades entidades;
    private List<Respuestauser> listaParaValidar;
    private static List<Resultado> listaResultado;
    private boolean boton;
    private Secuencial secuencial;
    private Acceso acceso;
    private Detallecofig detallecofig;

    Calendar cronometro = Calendar.getInstance();
    Calendar cronStop = Calendar.getInstance();
    private DateFormat formato = new SimpleDateFormat("HH:mm:ss");
    private final byte contagem;
    private boolean exit;
    private boolean process = false;

    public TestTadiControler() {
        contagem = -1;
        entidades = new Entidades();
        acceso = new Acceso();
        detallecofig = new Detallecofig();
        load();
    }

    private void load() {
        exit = true;
        process = true;
        cronometro.set(0, 0, 0, 0, 15, 0);
        cronStop.set(0, 0, 0, 0, 0, 0);
    }

    public String init() {
        try {
            process = false;
            RequestContext.getCurrentInstance().execute("poll.start();");
            testuser = new Testuser();
            entidades = (Entidades) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("entidad");
            acceso = accesoFacade.buscaAccesoIns(InicioTadiControler.getGrupoUsuario().getId());
            detallecofig = IniciaTcfsoControler.getDetallecofig();
            getListaSubClase();
            listaRespuestaUsuario = new ArrayList<>();
            for (Pregunta p : getListaPregunta()) {
                respuestauserPK = new RespuestauserPK();
                respuestauserPK.setIdsubclase(p.getPreguntaPK().getIdsubclase());
                respuestauserPK.setIdclase(p.getPreguntaPK().getIdclase());
                nuevaRespuesta = new Respuesta();
                nuevaRespuesta.setIdgruporespuesta(p.getIdgruporespuesta());
                respuestauser = new Respuestauser();
                respuestauser.setRespuesta(nuevaRespuesta);
                respuestauser.setRespuestauserPK(respuestauserPK);
                respuestauser.setPregunta(p);
                listaRespuestaUsuario.add(respuestauser);
            }

            return "exito";
        } catch (Exception e) {
            MostrarMensaje.fatal("Información", "No se pudo cargar el test, Comuniquese con el administrador del sistema");
            return "fallo";
        }

    }

    public String getTiempoTranscurrido() {
        cronometro.add(Calendar.SECOND, contagem);
        if (cronometro.compareTo(cronStop) == 0 || cronometro.before(cronStop)) {
            exit = false;
            process = true;
            System.out.println("se acabo");
        }
        return formato.format(cronometro.getTime());
    }

    public void cron() throws IOException {
        if (exit) {
            getTiempoTranscurrido();
        } else {
            dialogTimer();
            System.out.println("acabo tiempo");
        }
    }

    private void dialogTimer() throws IOException {
        RequestContext.getCurrentInstance().execute("PF('dialogTimer').show();");
        RequestContext.getCurrentInstance().execute("poll.stop();");
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("#{TestTadiControler}");
        FacesContext.getCurrentInstance().getExternalContext().redirect("/Evaluacion-war/paginas/home.jsf");
    }

    public List<Subclase> getListaSubClase() {
        if (listaSubClase == null) {
            testActual = testFacade.test("TADI");
            listaSubClase = new ArrayList<>();
            if (testActual != null) {
                for (Clase c : testActual.getClaseList()) {
                    for (Subclase sb : c.getSubclaseList()) {
                        listaSubClase.add(sb);
                    }
                }
                return listaSubClase;
            } else {
                return null;
            }
        }
        return listaSubClase;
    }

    public List<Pregunta> getListaPregunta() {
        if (listaPregunta == null) {
            listaPregunta = new ArrayList<>();
            for (Subclase sb : listaSubClase) {
                listaPregunta=preguntaFacade.listaPregRandom(sb.getSubclasePK().getIdsubclase());
            }
            return listaPregunta;
        } else {
            return listaPregunta;
        }
    }

    public boolean isExit() {
        return exit;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }

    public boolean isProcess() {
        return process;
    }

    public void setProcess(boolean process) {
        this.process = process;
    }

}
