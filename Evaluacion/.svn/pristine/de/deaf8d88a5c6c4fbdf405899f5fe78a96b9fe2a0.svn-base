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
import entidades.soft.Anioslectivos;
import entidades.soft.Grupousuario;
import entidades.soft.Niveles;
import entidades.soft.Paralelos;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import logica.eval.AccesoFacade;
import logica.eval.AsignacionFacade;
import logica.eval.ConfiguracionFacade;
import logica.eval.DetallecofigFacade;
import logica.soft.AnioslectivosFacade;
import logica.soft.GrupousuarioFacade;
import logica.soft.NivelesFacade;
import logica.soft.ParalelosFacade;
import org.primefaces.event.SelectEvent;
import utilidades.MostrarMensaje;

/**
 *
 * @author Multimedia
 */
@ManagedBean
@SessionScoped
public class DetalleTestControlador extends BaseControlador {
    
    @EJB
    private AsignacionFacade asignacionFacade;
    @EJB
    private AccesoFacade accesoFacade;
    
    @EJB
    private GrupousuarioFacade grupousuarioFacade;
    
    @EJB
    private AnioslectivosFacade anioslectivosFacade;
    
    @EJB
    private NivelesFacade nivelesFacade;
    @EJB
    private ParalelosFacade paralelosFacade;
    @EJB
    private DetallecofigFacade detallecofigFacade;
    @EJB
    private ConfiguracionFacade configuracionFacade;
    
    private List<Asignacion> listaTestAsignados;
    private List<Anioslectivos> listaAnioLectivos;
    private List<Paralelos> listaParalelos;
    private List<Niveles> listaNiveles;
    private List<Detallecofig> listaDetalle;
    private List<Detallecofig> listaDetalleAuxiliar;
    
    private Integer idAsignacion;
    private Integer idAnioLectivo;
    private Integer idParalelo;
    private Integer idNivel;
    
    private Acceso acceso;
    private Datos usuario;
    private Configuracion configuracion;
    private Grupousuario grupousuario;
    private Detallecofig detalle;
    private Detallecofig detalleConfSelected;
    private Configuracion configSelected;
    private Configuracion configSelected1;
    private String opcion = "DO";
    private int filaSeleccionada;
    private String accion;
    private Date horaIn;
    private Date horaFin;
    private int horaF = 8;
    private String mensaje;
    
    public DetalleTestControlador() {
        detalle = new Detallecofig();
        configSelected = new Configuracion();
        detalleConfSelected = new Detallecofig();
    }
    
    public String init() {
        try {
            accion = "new";
            listaDetalle = new ArrayList<>();
            grupousuario = new Grupousuario();
            configuracion = new Configuracion();
            horaFin = null;
            resetTotal();
            usuario = (Datos) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            acceso = accesoFacade.acceso(usuario.getIddatos());
            List<Grupousuario> group = grupousuarioFacade.buscaGrupoUsuario(usuario.getDocumento());
            if (group != null && group.size() > 0) {
                grupousuario = group.get(0);
            }
            return "continua";
        } catch (Exception e) {
            MostrarMensaje.error("Información", "Estimado usuario, le informamos que no cumple con los requisitos, favor comuniquese con el administrador del sistema");
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            return "fallo";
        }
    }
    
    public List<Asignacion> getListaTestAsignados() {
        if (acceso.getIdperfil().getCodigo().compareTo("ADMIN") == 0) {
            listaTestAsignados = asignacionFacade.findAll();
        } else {
            listaTestAsignados = asignacionFacade.buscaAsignacion(acceso.getIdinstitucion());
        }
        return listaTestAsignados;
    }
    
    public void nuevo() {
        accion = "nuevo";
        reset();
    }
    
    private void setDetalle() {
        //metodo para cargar a lista una vez validado
        
        configuracion.setHorain(configuracion.getFechain());
        configuracion.setHorafin(configuracion.getFechafin());
        
        configuracion.getHorain().setHours(horaIn.getHours());
        configuracion.getHorain().setMinutes(horaIn.getMinutes());
        
        configuracion.getHorafin().setHours(horaFin.getHours());
        configuracion.getHorafin().setMinutes(horaFin.getMinutes());
        
        Date inicio = configuracion.getFechain();
        inicio.setHours(configuracion.getHorain().getHours());
        inicio.setMinutes(configuracion.getHorain().getMinutes());
        
        Date cierre = configuracion.getFechafin();
        cierre.setHours(configuracion.getHorafin().getHours());
        cierre.setMinutes(configuracion.getHorafin().getMinutes());
        
        configuracion.setInicio(inicio);
        configuracion.setCierre(cierre);
        
        Asignacion asignacion = asignacionFacade.asignacion(idAsignacion);
        configuracion.setAsignacion(asignacion);
        configuracion.setActiva(Boolean.TRUE);
        if (accion.compareTo("new") == 0) {
            detalle = new Detallecofig();
            detalle.setIdconfiguracion(configuracion);
            detalle.setIdaniolectivo(idAnioLectivo);
            detalle.setIdnivel(idNivel);
            detalle.setIdparalelo(idParalelo);
            detalle.setTipo(opcion);
            detalle.setActiva(Boolean.TRUE);
            listaDetalle.add(detalle);
            reset();
        } else {
            detalle = new Detallecofig();
            detalle.setIdconfiguracion(configuracion);
            detalle.setIdaniolectivo(idAnioLectivo);
            detalle.setIdnivel(idNivel);
            detalle.setIdparalelo(idParalelo);
            detalle.setTipo(opcion);
            detalle.setActiva(Boolean.TRUE);
            listaDetalle.add(detalle);
            reset();
        }
        
    }
    
    private boolean validaLista() {
        boolean flag = false;
        for (Detallecofig det : listaDetalle) {
            if (det.getIdconfiguracion().getAsignacion().getAsignacionPK().getIdasignacion() != idAsignacion) {
                mensaje = "No puede insetar un test diferente a los ya ingresado";
                flag = false;
                reset();
                break;
            } else if (Objects.equals(det.getIdnivel(), idNivel) && Objects.equals(det.getIdparalelo(), idParalelo)) {
                mensaje = "Ya existe un test asignado";
                flag = false;
                reset();
                break;
            } else if (det.getTipo().compareTo(opcion) != 0) {
                mensaje = "No puede ingresar asignaciones diferentes";
                flag = false;
                reset();
                break;
            } else {
                flag = true;
            }
        }
        return flag;
    }
    
    private boolean validar() {
        if (idAsignacion == 0) {
            MostrarMensaje.warning("Advertencia", "El test en necesario");
            return false;
        } else if (idAnioLectivo == 0) {
            MostrarMensaje.warning("Advertencia", "El Anio lectivo es necesario");
            return false;
        } else if (idNivel == 0) {
            MostrarMensaje.warning("Advertencia", "El nivel es necesario");
            return false;
        } else if (idParalelo == 0) {
            MostrarMensaje.warning("Advertencia", "El Paralelo es necesario");
            return false;
        } else {
            return true;
        }
    }
    
    public void nuevoDetalleConfig() {
        Calendar cal = Calendar.getInstance();
        if (idAsignacion != 0) {
            if (configuracion.getFechafin() != null && configuracion.getFechain() != null
                    && horaIn != null && horaFin != null
                    && idAsignacion != null) {
                if (configuracion.getFechain().equals(configuracion.getFechafin())) {
                    if (horaIn.getHours() > horaFin.getHours() || horaFin.getHours() != horaIn.getHours()) {
                        if (opcion.compareTo("DO") == 0) {
                            if (idAnioLectivo == 0) {
                                MostrarMensaje.warning("Advertencia", "Es necesario anio lectivo");
                            } else {
                                if (listaDetalle.isEmpty()) {
                                    //cargo a lista
                                    setDetalle();
                                } else {
                                    ///si la lista es mayo a 1
                                    if (validaLista()) {
                                        setDetalle();
                                    } else {
                                        MostrarMensaje.warning("Informacón", mensaje);
                                    }
                                }
                            }
                        } else {
                            if (validar()) {
                                if (listaDetalle.isEmpty()) {
                                    //cargo a lista
                                    setDetalle();
                                } else {
                                    ///si la lista es mayo a 1
                                    if (validaLista()) {
                                        setDetalle();
                                    } else {
                                        MostrarMensaje.warning("Informacón", mensaje);
                                    }
                                }
                            } else {
                                reset();
                            }
                        }
                        
                    } else {
                        MostrarMensaje.warning("Información", "La hora final no puede ser mayor a la inicial o iguales  ");
                    }
                } else if (configuracion.getFechafin().after(configuracion.getFechain())) {
                    if (opcion.compareTo("DO") == 0) {
                        if (idAnioLectivo == 0) {
                            MostrarMensaje.warning("Advertencia", "Es necesario anio lectivo");
                        } else {
                            if (listaDetalle.isEmpty()) {
                                //cargo a lista
                                setDetalle();
                            } else {
                                ///si la lista es mayo a 1
                                if (validaLista()) {
                                    setDetalle();
                                } else {
                                    MostrarMensaje.warning("Informacón", mensaje);
                                }
                            }
                        }
                    } else {
                        if (validar()) {
                            if (listaDetalle.isEmpty()) {
                                //cargo a lista
                                setDetalle();
                            } else {
                                ///si la lista es mayo a 1
                                if (validaLista()) {
                                    setDetalle();
                                } else {
                                    MostrarMensaje.warning("Informacón", mensaje);
                                }
                            }
                        } else {
                            reset();
                        }
                    }
                } else {
                    MostrarMensaje.error("Información", "La fecha de fin no puede ser menor al fecha de inicio");
                }
                
            } else {
                MostrarMensaje.warning("Información", "Existe campos por llenar");
            }
        } else {
            MostrarMensaje.warning("Información", "Es necesario un test");
        }
        
    }
    
    private void reset() {
        idAnioLectivo = 0;
        idNivel = 0;
        idParalelo = 0;
        detalle = new Detallecofig();
        opcion = "DO";
        getListaAnioLectivos();
    }
    
    public void resetTotal() {
        idAsignacion = 0;
        idAnioLectivo = 0;
        idNivel = 0;
        idParalelo = 0;
        opcion = "DO";
    }
    
    public String guardar() {
        try {
            transaccion.begin();
            if (!listaDetalle.isEmpty()) {
                if (accion.compareTo("new") == 0) {
                    configuracionFacade.create(configuracion);
                    for (Detallecofig co : listaDetalle) {
                        co.setIdconfiguracion(configuracion);
                        detallecofigFacade.create(co);
                    }
                } else {
                    configuracion.setActiva(true);
                    configuracionFacade.edit(configuracion);
                    for (Detallecofig det : listaDetalleAuxiliar) {
                        detallecofigFacade.remove(det);
                    }
                    for (Detallecofig nue : listaDetalle) {
                        nue.setIdconfiguracion(configuracion);
                        detallecofigFacade.create(nue);
                    }
                }
                transaccion.commit();
                resetTotal();
                MostrarMensaje.informacion("Información", "Registro exitoso");
                FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
                return "exito";
            } else {
                transaccion.rollback();
                MostrarMensaje.warning("Información", "No existen registros para guardar");
                FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
                return "fallo";
            }
            
        } catch (Exception e) {
            MostrarMensaje.error("Información", "Fallo en el registro");
            return "fallo";
        }
    }
    
    public String modificar() {
        try {
            String valor = init();
            resetTotal();
            accion = "edit";
            configuracion.setIdconfiguracion(configSelected.getIdconfiguracion());
            configuracion.setAsignacion(configSelected.getAsignacion());
            configuracion.setFechain(configSelected.getFechain());
            configuracion.setFechafin(configSelected.getFechafin());
            configuracion.setHorain(configSelected.getHorain());
            configuracion.setHorafin(configSelected.getHorafin());
            horaIn = configSelected.getHorain();
            horaFin = configSelected.getHorafin();
            idAsignacion = configSelected.getAsignacion().getAsignacionPK().getIdasignacion();
            listaDetalleAuxiliar = new ArrayList<>();
            for (Detallecofig dc : configSelected.getDetallecofigList()) {
                Detallecofig det = new Detallecofig();
                det.setIddetalle(dc.getIddetalle());
                det.setIdconfiguracion(configSelected);
                det.setIdaniolectivo(dc.getIdaniolectivo());
                det.setIdnivel(dc.getIdnivel());
                det.setIdparalelo(dc.getIdparalelo());
                det.setTipo(dc.getTipo());
                det.setActiva(dc.getActiva());
                listaDetalle.add(det);
                listaDetalleAuxiliar.add(det);
            }
            return "modificar";
        } catch (Exception e) {
            MostrarMensaje.error("Información", "Error al cargar el test asignado");
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            return "fallo";
        }
    }
    
    public void eliminar() {
        listaDetalle.remove(filaSeleccionada);
        reset();
    }
    
    public Integer getIdAsignacion() {
        return idAsignacion;
    }
    
    public void setIdAsignacion(Integer idAsignacion) {
        this.idAsignacion = idAsignacion;
    }
    
    public Configuracion getConfiguracion() {
        return configuracion;
    }
    
    public void setConfiguracion(Configuracion configuracion) {
        this.configuracion = configuracion;
    }
    
    public Acceso getAcceso() {
        return acceso;
    }
    
    public Grupousuario getGrupousuario() {
        return grupousuario;
    }
    
    public void setGrupousuario(Grupousuario grupousuario) {
        this.grupousuario = grupousuario;
    }
    
    public Date getFechaMinima() {
        return Calendar.getInstance().getTime();
    }
    
    public int getHoraMinima() {
        Calendar cal = Calendar.getInstance();
        return cal.getTime().getHours();
    }
    
    public void horaMinimacambio(SelectEvent event) {
        //metodo para validar la hora  del test
        horaF = 8;
        Date date = (Date) event.getObject();
        Date fecha = new Date();
        if (date.getDate() == fecha.getDate()) {
            setHoraF(fecha.getHours());
        } else {
            setHoraF(8);
        }
    }
    
    public List<Detallecofig> getListaDetalle() {
        return listaDetalle;
    }
    
    public void setListaDetalle(List<Detallecofig> listaDetalle) {
        this.listaDetalle = listaDetalle;
    }
    
    public Detallecofig getDetalle() {
        return detalle;
    }
    
    public void setDetalle(Detallecofig detalle) {
        this.detalle = detalle;
    }
    
    public Configuracion getConfigSelected() {
        return configSelected;
    }
    
    public void setConfigSelected(Configuracion configSelected) {
        this.configSelected = configSelected;
    }
    
    public Detallecofig getDetalleConfSelected() {
        return detalleConfSelected;
    }
    
    public void setDetalleConfSelected(Detallecofig detalleConfSelected) {
        this.detalleConfSelected = detalleConfSelected;
    }
    
    public void onRowSelect(SelectEvent event) {
        System.out.println(event.getObject());
    }
    
    public String getOpcion() {
        return opcion;
    }
    
    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }
    
    public Integer getIdAnioLectivo() {
        return idAnioLectivo;
    }
    
    public void setIdAnioLectivo(Integer idAnioLectivo) {
        this.idAnioLectivo = idAnioLectivo;
    }
    
    public Integer getIdParalelo() {
        return idParalelo;
    }
    
    public void setIdParalelo(Integer idParalelo) {
        this.idParalelo = idParalelo;
    }
    
    public Integer getIdNivel() {
        return idNivel;
    }
    
    public void setIdNivel(Integer idNivel) {
        this.idNivel = idNivel;
    }
    
    public List<Anioslectivos> getListaAnioLectivos() {
        listaAnioLectivos = anioslectivosFacade.listaAnioLectivo(grupousuario.getInstitucion().getId());
        return listaAnioLectivos;
    }
    
    public void cargaComboParalelo() {
        listaParalelos = paralelosFacade.listaParalelos(idAnioLectivo, idNivel);
    }
    
    public void cargaComboNivel() {
        listaNiveles = nivelesFacade.findAll();
    }
    
    public List<Paralelos> getListaParalelos() {
        return listaParalelos;
    }
    
    public void setListaParalelos(List<Paralelos> listaParalelos) {
        this.listaParalelos = listaParalelos;
    }
    
    public List<Niveles> getListaNiveles() {
        return listaNiveles;
    }
    
    public void setListaNiveles(List<Niveles> listaNiveles) {
        this.listaNiveles = listaNiveles;
    }
    
    public int getFilaSeleccionada() {
        return filaSeleccionada;
    }
    
    public void setFilaSeleccionada(int filaSeleccionada) {
        this.filaSeleccionada = filaSeleccionada;
    }

    //metodos para devolver el strin de id ya que 
    //la tablas no estan relacionadas anivel BD
    public String anioLectivo(int idAnio) {
        //devuelve strin de anio 
        if (idAnio != 0) {
            Anioslectivos an = anioslectivosFacade.find(idAnio);
            return an.getAniolectivo();
        } else {
            return "";
        }
        
    }
    
    public String nivel(int idNivel) {
        //devuelve strin de nivel 
        if (idNivel != 0) {
            Niveles n = nivelesFacade.find(idNivel);
            return n.getNombre();
        } else {
            return "";
        }
        
    }
    
    public String paralelo(int idParalelo) {
        //devuelve strin de idparalelo
        if (idParalelo != 0) {
            Paralelos p = paralelosFacade.find(idParalelo);
            return p.getParalelo();
        } else {
            return "";
        }
        
    }
    ///////////

    public Date getHoraFin() {
        return horaFin;
    }
    
    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }
    
    public Date getHoraIn() {
        return horaIn;
    }
    
    public void setHoraIn(Date horaIn) {
        this.horaIn = horaIn;
    }
    
    public int getHoraF() {
        return horaF;
    }
    
    public void setHoraF(int horaF) {
        this.horaF = horaF;
    }
    
    public String getAccion() {
        return accion;
    }
    
    public void setAccion(String accion) {
        this.accion = accion;
    }
    
    public Configuracion getConfigSelected1() {
        return configSelected1;
    }
    
    public void setConfigSelected1(Configuracion configSelected1) {
        this.configSelected1 = configSelected1;
    }
    
}
