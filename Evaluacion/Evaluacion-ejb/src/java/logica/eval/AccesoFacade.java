/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.eval;

import entidades.eval.Acceso;
import generica.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Multimedia
 */
@Stateless
public class AccesoFacade extends AbstractFacade<Acceso> {

    @PersistenceContext(unitName = "Evaluacion-ejbPU2")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccesoFacade() {
        super(Acceso.class);
    }

    public Acceso acceso(int idDatos) {
        try {
            Acceso acc = (Acceso) em.createNamedQuery("Acceso.findByIdDatos")
                    .setParameter("iddatos", idDatos)
                    .getSingleResult();
            return acc;
        } catch (Exception e) {
            return null;
        }
    }

    public Acceso buscaAccesoIns(int idInstitucion) {

        try {
            Acceso acc = (Acceso) em.createNamedQuery("Acceso.findByIdinstitucion")
                    .setParameter("idinstitucion", idInstitucion)
                    .getSingleResult();
            return acc;
        } catch (Exception e) {
            return null;
        }
    }
}
