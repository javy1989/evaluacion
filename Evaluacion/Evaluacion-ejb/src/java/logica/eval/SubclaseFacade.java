/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.eval;

import entidades.eval.Subclase;
import generica.AbstractFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Multimedia
 */
@Stateless
public class SubclaseFacade extends AbstractFacade<Subclase> {

    @PersistenceContext(unitName = "Evaluacion-ejbPU2")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SubclaseFacade() {
        super(Subclase.class);
    }

    public List<Subclase> listaSubclase(int idClase) {
        try {
            Query query = em.createNamedQuery("Subclase.findByIdclase")
                    .setParameter("idclase", idClase);
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
}
