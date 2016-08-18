/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import entidades.eval.Acceso;
import entidades.eval.Clase;
import entidades.eval.Detallecofig;
import entidades.eval.Matriz;
import entidades.eval.Percentil;
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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import logica.eval.AccesoFacade;
import logica.eval.MatrizFacade;
import logica.eval.PercentilFacade;
import logica.eval.RespuestaFacade;
import logica.eval.RespuestauserFacade;
import logica.eval.ResultadoFacade;
import logica.eval.SecuencialFacade;
import logica.eval.TestFacade;
import logica.eval.TestuserFacade;
import utilidades.MostrarMensaje;
import utilidades.Utilitarios;

/**
 *
 * @author Multimedia
 */
@ManagedBean
@SessionScoped
public class TestTemoControlador {

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
    private PercentilFacade percentilFacade;

    @EJB
    private RespuestaFacade respuestaFacade;

    @EJB
    private SecuencialFacade secuencialFacade;
    @EJB
    private AccesoFacade accesoFacade;

    private List<Subclase> listaSubClase;
    private List<Respuestauser> listaRespuestaUsuario;
    private List<Pregunta> listaPregunta;
    private RespuestauserPK respuestauserPK;
    private Respuestauser respuestauser;
    private Respuesta nuevaRespuesta;
    private List<Respuesta> listaRespuesta;
    private static Test testActual;
    private Testuser testuser;
    private Entidades entidades;
    private boolean boton;
    private Secuencial secuencial;
    private Detallecofig detallecofig;
    private List<Respuestauser> listaParaValidar;
    private static List<Resultado> listaResultado;
    private Acceso acceso;

    public TestTemoControlador() {
        listaRespuesta = null;
        detallecofig = new Detallecofig();
        acceso=new Acceso();
    }

    public String iniciaTestEmociones() {
        return init();
    }

    public String init() {
        try {
            testuser = new Testuser();
            entidades = (Entidades) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("entidad");
            acceso = accesoFacade.buscaAccesoIns(InicioTcemoControlador.getGrupoUsuario().getInstitucion().getId());
            detallecofig = InicioTcemoControlador.getDetallecofig();
            boton = Boolean.TRUE;

            getListaSubClase();
            listaRespuestaUsuario = new ArrayList<>();
            for (Pregunta p : getListaPregunta()) {
                respuestauserPK = new RespuestauserPK();
                respuestauserPK.setIdsubclase(p.getPreguntaPK().getIdsubclase());
                respuestauserPK.setIdclase(p.getPreguntaPK().getIdclase());
                nuevaRespuesta = new Respuesta();
                nuevaRespuesta.setIdgruporespuesta(p.getIdgruporespuesta());
                // nuevaRespuesta.setMultiplica(p.getIdrespuesta().getMultiplica());
                respuestauser = new Respuestauser();
                respuestauser.setRespuesta(nuevaRespuesta);
                respuestauser.setRespuestauserPK(respuestauserPK);
                respuestauser.setPregunta(p);

                listaRespuestaUsuario.add(respuestauser);
            }
            return "exito";
        } catch (Exception e) {
            MostrarMensaje.fatal("Información","No se pudo cargar el test, Comuniquese con el administrador del sistema");
            return "fallo";
        }

    }

    public List<Subclase> getListaSubClase() {
        if (listaSubClase == null) {
            testActual = testFacade.test("TCEMO");
            listaSubClase = new ArrayList<>();
            if (testActual != null) {
                for (Clase c : testActual.getClaseList()) {
                    for (Subclase sc : c.getSubclaseList()) {
                        listaSubClase.add(sc);
                    }
                }

                return listaSubClase;
            } else {
                return null;
            }

        } else {
            return listaSubClase;
        }
    }

    public List<Pregunta> getListaPregunta() {
        if (listaPregunta == null) {
            listaPregunta = new ArrayList<>();
            for (Subclase sb : listaSubClase) {
                for (Pregunta p : sb.getPreguntaList()) {
                    listaPregunta.add(p);
                }

            }
            return listaPregunta;
        } else {
            return listaPregunta;
        }

    }

    public List<Respuestauser> getListaRespuestaUsuario() {
        return listaRespuestaUsuario;
    }

    public List<Respuesta> getListaRespuesta(Pregunta p) {
        listaRespuesta = new ArrayList<>();
        for (Respuesta r : p.getIdgruporespuesta().getRespuestaList()) {
            if (r.getActiva()) {
                listaRespuesta.add(r);
            }

        }
        return listaRespuesta;
    }

    public String guardar() throws NotSupportedException,
            SystemException,
            RollbackException,
            HeuristicMixedException,
            HeuristicRollbackException {

        Calendar cal = Calendar.getInstance();
        listaParaValidar = new ArrayList<>();
        try {
            secuencial = secuencialFacade.buscaSecuencial(testActual.getCodigo());
            testuser.setIddetalle(detallecofig);
            testuser.setCodigo(testActual.getCodigo() + "-" + utilidades.Utilitarios.generarNumeroTest() + "-" + secuencial.getSecuencial());
            testuser.setIdusuario(entidades.getId());
            testuser.setFeccreacion(new Date());
            testuser.setFeccierre(new Date());
            testuser.setVerificada(Boolean.FALSE);
            testuser.setActiva(Boolean.TRUE);
            testuserFacade.create(testuser);

            for (Respuestauser rp : listaRespuestaUsuario) {
                if (rp.getPregunta().getTipo() == 'C') {
                    respuestauserPK = new RespuestauserPK();
                    respuestauserPK.setIdsubclase(rp.getPregunta().getPreguntaPK().getIdsubclase());
                    respuestauserPK.setIdclase(rp.getPregunta().getPreguntaPK().getIdclase());
                    respuestauserPK.setIdtestuser(testuser.getIdtestuser());
                    respuestauserPK.setIdpregunta(rp.getPregunta().getPreguntaPK().getIdpregunta());
                    respuestauserPK.setIdrespuesta(rp.getRespuesta().getIdrespuesta());
                    respuestauser = new Respuestauser();
                    respuestauser.setRespuestauserPK(respuestauserPK);
                    respuestauser.setTestuser(testuser);
                    respuestauser.setPregunta(rp.getPregunta());
                    respuestauser.setRespuesta(rp.getRespuesta());
                    respuestauser.setFecha(cal.getTime());
                    listaParaValidar.add(respuestauser);
                    respuestauser.getPregunta().setRespuestauserList(listaParaValidar);
                    respuestauserFacade.create(respuestauser);

                }
            }
            sacaResultado();
            secuencial.setSecuencial(secuencial.getSecuencial() + 1);
            secuencialFacade.edit(secuencial);
            boton = false;
            utilidades.EnvioMail.enviaMail(acceso.getIddatos().getEmail(), Utilitarios.emailPsico(acceso.getIddatos().getNombre(), testuser.getCodigo()));
            MostrarMensaje.informacion("Informacion", "Encuesta ingresada exitosamente");
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            return "exito";
        } catch (SecurityException | IllegalStateException ex) {
            System.out.println(ex);
            MostrarMensaje.informacion("Error", "Error al ingresar la información");
            return "fallo";
        }

    }

    public String cancelar() {
        listaRespuesta = null;
        return "cancelar";
    }

    public void sacaResultado() {
        BigDecimal sumaSubClase = null;
        BigDecimal sumaPregunta = null;
        BigDecimal total = null;
        listaResultado = new ArrayList<>();
        for (Respuestauser res : listaParaValidar) {
            total = BigDecimal.ZERO;
            for (Clase c : res.getPregunta().getSubclase().getClase().getIdtest().getClaseList()) {
                // System.out.println("ingreso clase" + c.getIdclase());
                for (Subclase sb : c.getSubclaseList()) {
                    sumaSubClase = BigDecimal.ZERO;
                    //System.out.println("ingreso subclase" + sb.getSubclasePK().getIdsubclase());
                    for (Pregunta p : sb.getPreguntaList()) {
                        // System.out.println("ingreso pregunta" + p.getPreguntaPK().getIdpregunta());
                        for (Respuestauser resu : p.getRespuestauserList()) {
                            if (resu.getPregunta().getPreguntaPK().getIdpregunta() == p.getPreguntaPK().getIdpregunta()) {
                                System.out.println("sumando respuesta buena en subclase");
                                Respuesta re = respuestaFacade.find(resu.getRespuesta().getIdrespuesta());
                                sumaPregunta = BigDecimal.ZERO;
                                sumaPregunta = sumaPregunta.add(BigDecimal.ONE).multiply(re.getMultiplica());
                                sumaSubClase = sumaSubClase.add(sumaPregunta);
                            }
                        }
                    }
                    total = total.add(sumaSubClase);
                    System.out.println("sumando clase");
                    Resultado re = new Resultado();
                    re.setIdtestuser(testuser);
                    re.setSubclase(sb);
                    re.setValor(sumaSubClase);
                    listaResultado.add(re);
                }
            }
            break;
        }
        for (Resultado re : listaResultado) {
            Matriz m = matrizFacade.buscaMatrizSubClase(re.getValor(), testActual.getIdtest(), re.getSubclase().getSubclasePK().getIdsubclase());
            Percentil p = percentilFacade.buscaPercentil(re.getSubclase().getSubclasePK().getIdsubclase(), testActual.getIdtest(), re.getValor());
            re.setIdpercentil(p);
            re.setIdmatriz(m);
            re.setTotal(total);
            resultadoFacade.create(re);
        }
    }

    public boolean isBoton() {
        return boton;
    }

    public void setBoton(boolean boton) {
        this.boton = boton;
    }

    public static List<Resultado> getListaResultado() {
        return listaResultado;
    }

    public static Test getTestActual() {
        return testActual;
    }
}
