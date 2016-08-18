/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import entidades.eval.Clase;
import entidades.eval.Gruporespuesta;
import entidades.eval.Imagen;
import entidades.eval.Pregunta;
import entidades.eval.PreguntaPK;
import entidades.eval.Respuesta;
import entidades.eval.Subclase;
import entidades.eval.SubclasePK;
import entidades.eval.Test;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import logica.eval.ClaseFacade;
import logica.eval.GruporespuestaFacade;
import logica.eval.ImagenFacade;
import logica.eval.PreguntaFacade;
import logica.eval.RespuestaFacade;
import logica.eval.SubclaseFacade;
import logica.eval.TestFacade;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import utilidades.MostrarMensaje;

/**
 *
 * @author Multimedia
 */
@ManagedBean
@ViewScoped
public class PreguntaControler {

    @EJB
    private TestFacade testFacade;
    @EJB
    private ClaseFacade claseFacade;
    @EJB
    private SubclaseFacade subclaseFacade;
    @EJB
    private PreguntaFacade preguntaFacade;
    @EJB
    private GruporespuestaFacade gruporespuestaFacade;
    @EJB
    private ImagenFacade imagenFacade;
    @EJB
    private RespuestaFacade respuestaFacade;

    private List<Test> busTest;
    private List<Clase> busClase;
    private List<Subclase> busSubclase;
    private int idBusTest, idBusClase, idBusSubClase;

    private List<Test> listTest;
    private List<Clase> listClase;
    private List<Subclase> listSubclase;

    private List<Pregunta> listPregunta;
    private int idTest, idClase, idSubClase, idGrupoRespuesta, idRespuesta;
    private Pregunta preguntaSelec;
    private Imagen imagenSelec;
    private String tipo, accion;
    private static byte[] bytes;
    private List<Respuesta> listaRespuesta;
    private List<Gruporespuesta> listaGrupoRespuesta;
    private String urlImg;
    private UploadedFile fileTemp;

    private StreamedContent image;

    public PreguntaControler() {
        busTest = new ArrayList<>();
        busClase = new ArrayList<>();
        busSubclase = new ArrayList<>();
        listPregunta = new ArrayList<>();
    }

    @PostConstruct
    public void init() {
        Test t = new Test();
        Clase c = new Clase();
        c.setIdtest(t);
        SubclasePK pK = new SubclasePK();
        Subclase sb = new Subclase();
        sb.setSubclasePK(pK);
        sb.setClase(c);
        Gruporespuesta gr = new Gruporespuesta();
        Respuesta r = new Respuesta();
        r.setIdgruporespuesta(gr);
        Imagen img = new Imagen();
        preguntaSelec = new Pregunta();
        preguntaSelec.setIdrespuesta(r);
        preguntaSelec.setIdgruporespuesta(gr);
        preguntaSelec.setSubclase(sb);
        preguntaSelec.setIdfoto(img);
        cargaComboTest();
        getListTest();
        listaGrupoRespuesta = gruporespuestaFacade.findAll();
    }

    public void cargaComboTest() {
        busTest = testFacade.findAll();
        listTest = busTest;
    }

    public void cargaClase() {
        busSubclase.clear();
        idBusClase = 0;
        idBusSubClase = 0;
        busClase = claseFacade.listaClase(idBusTest);
    }

    public void cargaSubClase() {
        busSubclase = subclaseFacade.listaSubclase(idBusClase);
    }

    public void listarPregunta() {
        try {
            listPregunta = preguntaFacade.lista(idBusTest, idBusSubClase, idBusClase);
        } catch (Exception e) {
            System.out.println(e.getCause());
            MostrarMensaje.error("Información", "No se pudo realizar la petición");
        }
    }

    public void handleFileUpload(FileUploadEvent event) {
        try {
            if (accion.compareTo("new") == 0) {
                imagenSelec = new Imagen();
            }
            if (accion.compareTo("edit") == 0 && preguntaSelec.getIdfoto() == null) {
                imagenSelec = new Imagen();
            }
            fileTemp = event.getFile();
            bytes = fileTemp.getContents();
            imagenSelec.setImagen(bytes);
            urlImg = "/Evaluacion-war/PreviewImage";
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
    }

    public void nuevaPregunta() {
        accion = "new";
        Test t = new Test();
        Clase c = new Clase();
        c.setIdtest(t);
        Subclase sb = new Subclase();
        sb.setClase(c);
        Gruporespuesta gr = new Gruporespuesta();
        Respuesta r = new Respuesta();
        r.setIdgruporespuesta(gr);
        Imagen img = new Imagen();
        PreguntaPK pkPre = new PreguntaPK();
        preguntaSelec = new Pregunta();
        preguntaSelec.setSubclase(sb);
        preguntaSelec.setPreguntaPK(pkPre);
        preguntaSelec.setIdrespuesta(r);
        preguntaSelec.setIdgruporespuesta(gr);
        preguntaSelec.setIdfoto(img);
    }

    public void guardar() {
        try {
            if (accion.compareTo("new") == 0) {
                if (idRespuesta == 0) {
                    preguntaSelec.setIdrespuesta(null);
                } else {
                    Respuesta r = respuestaFacade.find(idRespuesta);
                    preguntaSelec.setIdrespuesta(r);

                }
                if (fileTemp != null) {
                    imagenFacade.create(imagenSelec);
                    preguntaSelec.setIdfoto(imagenSelec);

                } else {
                    preguntaSelec.setIdfoto(null);
                }
                SubclasePK sbPk = new SubclasePK();
                sbPk.setIdclase(preguntaSelec.getPreguntaPK().getIdclase());
                sbPk.setIdsubclase(preguntaSelec.getPreguntaPK().getIdsubclase());
                Subclase sb = new Subclase();
                sb.setSubclasePK(sbPk);
                preguntaSelec.getPreguntaPK().setIdpregunta(preguntaFacade.idPregunta());
                preguntaSelec.setSubclase(sb);
                preguntaFacade.create(preguntaSelec);
            } else {
                if (idRespuesta == 0) {
                    preguntaSelec.setIdrespuesta(null);
                } else {
                    Respuesta r = respuestaFacade.find(idRespuesta);
                    preguntaSelec.setIdrespuesta(r);
                }
                if (fileTemp != null) {
                    if (accion.compareTo("new") == 0) {
                        imagenFacade.create(imagenSelec);
                        preguntaSelec.setIdfoto(imagenSelec);
                    } else {
                        if (preguntaSelec.getIdfoto() != null) {
                            imagenFacade.edit(imagenSelec);
                        } else {
                            imagenFacade.create(imagenSelec);
                        }
                        preguntaSelec.setIdfoto(imagenSelec);
                    }
                } else {
                    preguntaSelec.setIdfoto(null);
                }
                preguntaFacade.edit(preguntaSelec);
            }
            MostrarMensaje.informacion("Información", "Registro exitoso");
            urlImg = "";
            listarPregunta();

        } catch (Exception e) {
            MostrarMensaje.error("Información", "Error al guardar registro");
        }
    }

    public void reset() {
        urlImg="";
        idRespuesta=0;
    }

//    public StreamedContent getImage() {
//        FacesContext context = FacesContext.getCurrentInstance();
//        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
//            return new DefaultStreamedContent();
//        } else {
//            String idImage = context.getExternalContext().getRequestParameterMap().get("idimagen");
//            Imagen img = imagenFacade.find(Integer.parseInt(idImage));
//            return new DefaultStreamedContent(new ByteArrayInputStream(img.getImagen()));
//        }
//    }

    public List<Pregunta> getListPregunta() {
        return listPregunta;
    }

    public void setListPregunta(List<Pregunta> listPregunta) {
        this.listPregunta = listPregunta;
    }

    public List<Test> getBusTest() {
        return busTest;
    }

    public void setBusTest(List<Test> busTest) {
        this.busTest = busTest;
    }

    public List<Clase> getBusClase() {
        return busClase;
    }

    public void setBusClase(List<Clase> busClase) {
        this.busClase = busClase;
    }

    public List<Subclase> getBusSubclase() {
        return busSubclase;
    }

    public void setBusSubclase(List<Subclase> busSubclase) {
        this.busSubclase = busSubclase;
    }

    public int getIdBusTest() {
        return idBusTest;
    }

    public void setIdBusTest(int idBusTest) {
        this.idBusTest = idBusTest;
    }

    public int getIdBusClase() {
        return idBusClase;
    }

    public void setIdBusClase(int idBusClase) {
        this.idBusClase = idBusClase;
    }

    public int getIdBusSubClase() {
        return idBusSubClase;
    }

    public void setIdBusSubClase(int idBusSubClase) {
        this.idBusSubClase = idBusSubClase;
    }

    public List<Test> getListTest() {
        return listTest;
    }

    public void setListTest(List<Test> listTest) {
        this.listTest = listTest;
    }

    public void cargarClaseDlg() {
        listClase = claseFacade.listaClase(preguntaSelec.getSubclase().getClase().getIdtest().getIdtest());
    }

    public List<Clase> getListClase() {
        return listClase;
    }

    public void setListClase(List<Clase> listClase) {
        this.listClase = listClase;
    }

    public void cargaSubClaseDlg() {
        listSubclase = subclaseFacade.listaSubclase(preguntaSelec.getPreguntaPK().getIdclase());
    }

    public List<Subclase> getListSubclase() {
        return listSubclase;
    }

    public void setListSubclase(List<Subclase> listSubclase) {
        this.listSubclase = listSubclase;
    }

    public int getIdTest() {
        return idTest;
    }

    public void setIdTest(int idTest) {
        this.idTest = idTest;
    }

    public int getIdClase() {
        return idClase;
    }

    public void setIdClase(int idClase) {
        this.idClase = idClase;
    }

    public int getIdSubClase() {
        return idSubClase;
    }

    public void setIdSubClase(int idSubClase) {
        this.idSubClase = idSubClase;
    }

    public Pregunta getPreguntaSelec() {
        return preguntaSelec;
    }

    public void setPreguntaSelec(Pregunta preguntaSelec) {
        this.preguntaSelec = preguntaSelec;
        accion = "edit";

        if (this.preguntaSelec.getSubclase().getClase().getIdtest() != null) {
            cargarClaseDlg();
        }
        if (this.preguntaSelec.getSubclase().getClase() != null) {
            cargaSubClaseDlg();
            this.preguntaSelec.setSubclase(preguntaSelec.getSubclase());
        }
        if (this.preguntaSelec.getIdgruporespuesta().getIdgruporespuesta() != null) {
            cargaRespuestaDlg();
            if (preguntaSelec.getIdrespuesta() != null) {
                idRespuesta = this.preguntaSelec.getIdrespuesta().getIdrespuesta();
            }
        }
        if (this.preguntaSelec.getIdfoto() != null) {
            imagenSelec = this.preguntaSelec.getIdfoto();
            bytes = imagenSelec.getImagen();
            urlImg = "/Evaluacion-war/PreviewImage";
        }
    }

    public List<Gruporespuesta> getListaGrupoRespuesta() {
        return listaGrupoRespuesta;
    }

    public void setListaGrupoRespuesta(List<Gruporespuesta> listaGrupoRespuesta) {
        this.listaGrupoRespuesta = listaGrupoRespuesta;
    }

    public int getIdGrupoRespuesta() {
        return idGrupoRespuesta;
    }

    public void setIdGrupoRespuesta(int idGrupoRespuesta) {
        this.idGrupoRespuesta = idGrupoRespuesta;

    }

    public void cargaRespuestaDlg() {
        listaRespuesta = gruporespuestaFacade.listaRespuesta(preguntaSelec.getIdgruporespuesta().getIdgruporespuesta());
    }

    public List<Respuesta> getListaRespuesta() {
        return listaRespuesta;
    }

    public void setListaRespuesta(List<Respuesta> listaRespuesta) {
        this.listaRespuesta = listaRespuesta;
    }

    public int getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(int idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Imagen getImagenSelec() {
        return imagenSelec;
    }

    public void setImagenSelec(Imagen imagenSelec) {
        this.imagenSelec = imagenSelec;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public static byte[] getBytes() {
        return bytes;
    }

    public static void setBytes(byte[] bytes) {
        PreguntaControler.bytes = bytes;
    }

    public UploadedFile getFileTemp() {
        return fileTemp;
    }

    public void setFileTemp(UploadedFile fileTemp) {
        this.fileTemp = fileTemp;
    }

}
