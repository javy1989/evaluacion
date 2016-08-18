/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.soft;

import entidades.soft.Paralelos;
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
public class ParalelosFacade extends AbstractFacade<Paralelos> {

    @PersistenceContext(unitName = "Evaluacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ParalelosFacade() {
        super(Paralelos.class);
    }

    public List<Paralelos> listaParalelos(int idAnio,int idNivel) {
        try {
            List<Paralelos> listado = em.createNamedQuery("Paralelos.findByAnioNivel")
                    .setParameter("idanio", idAnio)
                    .setParameter("idnivel",idNivel)
                    .getResultList();
            return listado;
        } catch (Exception e) {
            return null;
        }
    }
}
