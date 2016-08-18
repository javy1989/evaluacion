/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

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
import java.math.BigDecimal;
import java.math.RoundingMode;
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
import logica.eval.GruporespuestaFacade;
import logica.eval.RespuestaFacade;
import logica.eval.RespuestauserFacade;
import logica.eval.ResultadoFacade;
import logica.eval.SecuencialFacade;
import logica.eval.TestFacade;
import logica.eval.TestuserFacade;
import utilidades.MostrarMensaje;

/**
 *
 * @author Multimedia
 */
@ManagedBean
@SessionScoped
public class SatisfaccionPadreControler {

    @EJB
    private TestFacade testFacade;

    @EJB
    private GruporespuestaFacade gruporespuestaFacade;

    @EJB
    private RespuestauserFacade respuestauserFacade;
    @EJB
    private TestuserFacade testuserFacade;

    @EJB
    private RespuestaFacade respuestaFacade;

    @EJB
    private ResultadoFacade resultadoFacade;

    @EJB
    private SecuencialFacade secuencialFacade;

    private Entidades entidades;
    private List<Subclase> listaSubClase;
    private List<Respuestauser> listaRespuestaUsuario;
    private List<Pregunta> listaPregunta;
    private RespuestauserPK respuestauserPK;
    private Respuestauser respuestauser;
    private Respuesta nuevaRespuesta;
    private List<Respuesta> listaRespuesta;
    private final Testuser testuser;
    private List<Respuestauser> listaParaValidar;
    static final BigDecimal maximoRespuesta = new BigDecimal(5);
    static final BigDecimal porciento = new BigDecimal(100);
    static List<Resultado> listaResultado;
    private BigDecimal totalPorcentaje;
    private boolean boton;
    private Secuencial secuencial;
    private Test testActual;
    private Detallecofig detallecofig;
    public SatisfaccionPadreControler() {
        entidades = new Entidades();
        testuser = new Testuser();
        detallecofig=new Detallecofig();
    }

    public String init() {
        try {
            listaRespuestaUsuario = new ArrayList<>();
            boton = Boolean.TRUE;
            entidades = (Entidades) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("entidad");
            detallecofig=InicioTsapControler.getDetallecofig();
            getListaSubClase();
            for (Pregunta p : getListaPregunta()) {
                respuestauserPK = new RespuestauserPK();
                respuestauserPK.setIdpregunta(p.getPreguntaPK().getIdpregunta());
                respuestauserPK.setIdsubclase(p.getPreguntaPK().getIdsubclase());
                respuestauserPK.setIdclase(p.getPreguntaPK().getIdclase());
                nuevaRespuesta = new Respuesta();
                nuevaRespuesta.setIdgruporespuesta(p.getIdgruporespuesta());
                respuestauser = new Respuestauser();
                respuestauser.setRespuesta(nuevaRespuesta);
                respuestauser.setPregunta(p);
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
            testActual = testFacade.test("TSAP");
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
        if (validar()) {
            try {
                secuencial = secuencialFacade.buscaSecuencial(testActual.getCodigo());
                testuser.setIddetalle(detallecofig);
                testuser.setCodigo(testActual.getCodigo()+"-"+utilidades.Utilitarios.generarNumeroTest()+"-"+secuencial.getSecuencial());
                testuser.setIdusuario(entidades.getId());
                testuser.setFeccreacion(new Date());
                testuser.setFeccierre(new Date());
                testuser.setActiva(Boolean.TRUE);
                testuser.setVerificada(Boolean.FALSE);
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

                    } else {
                        nuevaRespuesta = new Respuesta();
                        nuevaRespuesta.setIdgruporespuesta(rp.getPregunta().getIdgruporespuesta());
                        if (rp.getRespuesta().getDescripcion().trim().isEmpty()) {
                            nuevaRespuesta.setDescripcion("NA");
                        } else {
                            nuevaRespuesta.setDescripcion(rp.getRespuesta().getDescripcion());
                        }
                        nuevaRespuesta.setActiva(Boolean.FALSE);
                        nuevaRespuesta.setCodigo("OBS");
                        respuestaFacade.create(nuevaRespuesta);

                        respuestauserPK = new RespuestauserPK();
                        respuestauserPK.setIdsubclase(rp.getPregunta().getPreguntaPK().getIdsubclase());
                        respuestauserPK.setIdclase(rp.getPregunta().getPreguntaPK().getIdclase());
                        respuestauserPK.setIdpregunta(rp.getPregunta().getPreguntaPK().getIdpregunta());
                        respuestauserPK.setIdrespuesta(nuevaRespuesta.getIdrespuesta());
                        respuestauserPK.setIdtestuser(testuser.getIdtestuser());
                        respuestauser = new Respuestauser();
                        respuestauser.setPregunta(rp.getPregunta());
                        respuestauser.setRespuesta(nuevaRespuesta);
                        respuestauser.setRespuestauserPK(respuestauserPK);
                        respuestauser.setTestuser(testuser);
                        respuestauser.setFecha(cal.getTime());
                        listaParaValidar.add(respuestauser);
                        respuestauser.getPregunta().setRespuestauserList(listaParaValidar);
                        respuestauserFacade.create(respuestauser);
                    }
                }
                sacaResultado();
                secuencial.setSecuencial(secuencial.getSecuencial()+1);
                secuencialFacade.edit(secuencial);
                boton = Boolean.FALSE;
                MostrarMensaje.informacion("Informacion", "Encuesta ingresada exitosamente");
                FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
                return "exito";
            } catch (SecurityException | IllegalStateException ex) {
                System.out.println(ex);
                MostrarMensaje.informacion("Error", "Error al ingresar la información");
                return "fallo";
            }
        } else {
            MostrarMensaje.warning("Información", "Preguntas sin contestar");
            return "fallo";
        }

    }

    public String cancelar() {
        listaRespuesta = null;
        return "cancelar";
    }

    public boolean validar() {
        boolean flag = true;
        for (Respuestauser resp : listaRespuestaUsuario) {
            if (resp.getRespuesta().getIdrespuesta() == null && resp.getPregunta().getTipo() != 'A') {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public void sacaResultado() {

        BigDecimal numeroPreguntas,
                sumaSubClase = null,
                porSubClase = null,
                maximoSubClase,
                numeroSubClase = null;
        totalPorcentaje = BigDecimal.ZERO;
        listaResultado = new ArrayList<>();
        for (Respuestauser res : listaParaValidar) {
            for (Clase c : res.getPregunta().getSubclase().getClase().getIdtest().getClaseList()) {
                // System.out.println("ingreso clase" + c.getIdclase());
                maximoSubClase = BigDecimal.ZERO;
                for (Subclase sb : c.getSubclaseList()) {
                    numeroSubClase = new BigDecimal(c.getSubclaseList().size() - 1);
                    sumaSubClase = BigDecimal.ZERO;
                    porSubClase = BigDecimal.ZERO;
                    numeroPreguntas = new BigDecimal(sb.getPreguntaList().size());
                    maximoSubClase = numeroPreguntas.multiply(maximoRespuesta);
                    for (Pregunta p : sb.getPreguntaList()) {
                        // System.out.println("ingreso pregunta" + p.getPreguntaPK().getIdpregunta());
                        for (Respuestauser resu : p.getRespuestauserList()) {
                            if (resu.getPregunta().getPreguntaPK().getIdpregunta() == p.getPreguntaPK().getIdpregunta()
                                    && p.getTipo() != 'A') {
                                System.out.println("sumando respuesta buena en subclase");
                                Respuesta re = respuestaFacade.find(resu.getRespuesta().getIdrespuesta());
                                sumaSubClase = sumaSubClase.add(re.getMultiplica());
                            }
                        }
                    }
                    if (sb.getCodigo().compareTo("OBB") != 0) {
                        //porSubClase = ((sumaSubClase.multiply(porciento)).divide(maximoSubClase));
                        porSubClase = sumaSubClase.multiply(porciento);
                        porSubClase = porSubClase.divide(maximoSubClase, RoundingMode.UP);
                        totalPorcentaje = totalPorcentaje.add(porSubClase);
                        Resultado r = new Resultado();
                        r.setSubclase(sb);
                        r.setIdtestuser(testuser);
                        r.setSubValor(sumaSubClase);
                        r.setValor(porSubClase);
                        listaResultado.add(r);
                    }

                }

            }
            break;
        }
        totalPorcentaje = totalPorcentaje.divide(numeroSubClase, RoundingMode.UP);
        for (Resultado re : listaResultado) {
            re.setTotal(totalPorcentaje);
            resultadoFacade.create(re);
        }
    }

    public static List<Resultado> getListaResultado() {
        return listaResultado;
    }

    public static void setListaResultado(List<Resultado> listaResultado) {
        SatisfaccionPadreControler.listaResultado = listaResultado;
    }

    public boolean isBoton() {
        return boton;
    }

    public void setBoton(boolean boton) {
        this.boton = boton;
    }

}
