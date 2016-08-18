/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.eval;

import entidades.eval.Datos;
import generica.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Multimedia
 */
@Stateless
public class DatosFacade extends AbstractFacade<Datos> {

    @PersistenceContext(unitName = "Evaluacion-ejbPU2")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DatosFacade() {
        super(Datos.class);
    }

    public Datos buscaUsuario(String user, String password) {
        try {
            Datos dat = (Datos) em.createNamedQuery("Datos.findByUsuario")
                    .setParameter("usuario", user)
                    .setParameter("password", password)
                    .getSingleResult();
            return dat;
        } catch (Exception e) {
            return null;
        }
    }
}
