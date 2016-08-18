/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.soft;

import entidades.soft.Entidades;
import generica.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Multimedia
 */
@Stateless
public class EntidadesFacade extends AbstractFacade<Entidades> {

    @PersistenceContext(unitName = "Evaluacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EntidadesFacade() {
        super(Entidades.class);
    }

    public Entidades entidadBuscada(String user,String pass) {
        try {
            Entidades en=(Entidades)em.createNamedQuery("Entidades.findByUserPassword")
                    .setParameter("user", user)
                    .setParameter("pass", pass)
                    .getSingleResult();
            return  en;
        } catch (Exception e) {
            return  null;
        }
    }

}
