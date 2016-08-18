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
public class TestCfsoControler {

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

    private List<Subclase> listaSubClase;
    private List<Respuestauser> listaRespuestaUsuario;
    private List<Pregunta> listaPregunta;
    private RespuestauserPK respuestauserPK;
    private Respuestauser respuestauser;
    private Respuesta nuevaRespuesta;
    private List<Respuesta> listaRespuesta;
    private Test testActual;
    private static Testuser testuser;
    private Entidades entidades;
    private List<Respuestauser> listaParaValidar;
    private static List<Resultado> listaResultado;
    private boolean boton;
    private Secuencial secuencial;
    private Acceso acceso;
    private Detallecofig detallecofig;

    public TestCfsoControler() {
        entidades = new Entidades();
        acceso = new Acceso();
        detallecofig=new Detallecofig();
    }

    public String init() {
        try {
            testuser = new Testuser();
            entidades = (Entidades) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("entidad");
            acceso = accesoFacade.buscaAccesoIns(IniciaTcfsoControler.getGrupoUsuario().getInstitucion().getId());
            detallecofig=IniciaTcfsoControler.getDetallecofig();
            boton = Boolean.TRUE;
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
            MostrarMensaje.fatal("Información","No se pudo cargar el test, Comuniquese con el administrador del sistema");
            return "fallo";
        }
    }

    public List<Subclase> getListaSubClase() {
        if (listaSubClase == null) {
            testActual = testFacade.test("TCFSO");
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
        if (listaRespuesta == null) {
            listaRespuesta = new ArrayList<>();
            for (Respuesta r : p.getIdgruporespuesta().getRespuestaList()) {
                if (r.getActiva()) {
                    listaRespuesta.add(r);
                }
            }
            return listaRespuesta;
        } else {
            return listaRespuesta;
        }

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
            testuser.setCodigo(testActual.getCodigo() + "-" + Utilitarios.generarNumeroTest() + "-" + secuencial.getSecuencial());
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
            boton = Boolean.FALSE;
            secuencial.setSecuencial(secuencial.getSecuencial() + 1);
            secuencialFacade.edit(secuencial);

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
        BigDecimal sumaClase = null;
        BigDecimal sumaSubClase = null;
        listaResultado = new ArrayList<>();
        for (Respuestauser res : listaParaValidar) {
            for (Clase c : res.getPregunta().getSubclase().getClase().getIdtest().getClaseList()) {
                sumaClase = BigDecimal.ZERO;
                // System.out.println("ingreso clase" + c.getIdclase());
                for (Subclase sb : c.getSubclaseList()) {
                    sumaSubClase = BigDecimal.ZERO;
                    //System.out.println("ingreso subclase" + sb.getSubclasePK().getIdsubclase());
                    for (Pregunta p : sb.getPreguntaList()) {
                        // System.out.println("ingreso pregunta" + p.getPreguntaPK().getIdpregunta());
                        for (Respuestauser resu : p.getRespuestauserList()) {
                            if (resu.getPregunta().getPreguntaPK().getIdpregunta() == p.getPreguntaPK().getIdpregunta()) {
                                System.out.println("ingreso resusuario" + resu.getRespuesta().getIdrespuesta());
                                System.out.println("valindo pregunta" + p.getPreguntaPK().getIdpregunta());
                                if (p.getIdrespuesta().getIdrespuesta().equals(resu.getRespuesta().getIdrespuesta())) {
                                    System.out.println("sumando respuesta buena en subclase");
                                    sumaSubClase = sumaSubClase.add(BigDecimal.ONE);
                                }

                            }
                        }
                    }
                    System.out.println("sumando clase");
                    sumaClase = sumaClase.add(sumaSubClase);
                    Resultado re = new Resultado();
                    re.setIdtestuser(testuser);
                    re.setSubclase(sb);
                    re.setSubValor(sumaSubClase);
                    re.setValor(sumaSubClase);
                    listaResultado.add(re);
                }
            }
            break;
        }
        for (Resultado re : listaResultado) {
            resultadoFacade.create(re);
        }

        for (Clase cl : testActual.getClaseList()) {
            List<Resultado> listAuxi = resultadoFacade.listaResultadoClase(cl.getIdclase(), testuser.getIdtestuser());
            BigDecimal total = BigDecimal.ZERO;
            for (Resultado re : listAuxi) {
                total = total.add(re.getSubValor());
            }
            Matriz m;
            m = matrizFacade.buscaMatriz(cl.getIdclase(), total, testActual.getIdtest());
            for (Resultado re : listAuxi) {
                re.setIdmatriz(m);
                re.setTotal(total);
                resultadoFacade.edit(re);
            }
        }
    }

    public boolean isBoton() {
        return boton;
    }

    public void setBoton(boolean boton) {
        this.boton = boton;
    }

    public static Testuser getTestuser() {
        return testuser;
    }

    public static void setTestuser(Testuser testuser) {
        TestCfsoControler.testuser = testuser;
    }

}
