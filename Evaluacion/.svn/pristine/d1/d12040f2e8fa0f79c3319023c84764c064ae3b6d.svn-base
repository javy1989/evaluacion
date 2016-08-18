/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.eval;

import entidades.eval.Configuracion;
import generica.AbstractFacade;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Multimedia
 */
@Stateless
public class ConfiguracionFacade extends AbstractFacade<Configuracion> {

    @PersistenceContext(unitName = "Evaluacion-ejbPU2")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConfiguracionFacade() {
        super(Configuracion.class);
    }

    public List<Configuracion> listadoConfiguracion(String test, Date fecha) {
        List<Configuracion> listado;
        try {
            listado=em.createNamedQuery("Configuracion.findByTestUsuarioIngreso")
                    .setParameter("fecha", fecha)
                    .setParameter("test", test)
                    .getResultList();
            return  listado;
        } catch (Exception e) {
            return null;
        }
    }
}
