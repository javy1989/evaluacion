/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.eval;

import entidades.eval.Asignacion;
import generica.AbstractFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Multimedia
 */
@Stateless
public class AsignacionFacade extends AbstractFacade<Asignacion> {

    @PersistenceContext(unitName = "Evaluacion-ejbPU2")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AsignacionFacade() {
        super(Asignacion.class);
    }

    public List<Asignacion> buscaAsignacion(int idInstitucion) {
        try {
            List<Asignacion> listado = em.createNamedQuery("Asignacion.findByIdinstitucion")
                    .setParameter("idinstitucion", idInstitucion)
                    .getResultList();
            return listado;
        } catch (Exception e) {
            return null;
        }
    }

    public Asignacion asignacion(int idAsignacion) {
        try {
            Asignacion as = (Asignacion) em.createNamedQuery("Asignacion.findByIdasignacion")
                    .setParameter("idasignacion", idAsignacion)
                    .getSingleResult();
            return as;
        } catch (Exception e) {
            return null;
        }
    }

}
