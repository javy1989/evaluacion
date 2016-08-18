/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.eval;

import entidades.eval.Test;
import generica.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Multimedia
 */
@Stateless
public class TestFacade extends AbstractFacade<Test> {

    @PersistenceContext(unitName = "Evaluacion-ejbPU2")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TestFacade() {
        super(Test.class);
    }

    public Test test(String codigo) {

        try {
            Test t = (Test) em.createNamedQuery("Test.findByCodigo").setParameter("codigo", codigo).getSingleResult();
            return t;
        } catch (Exception e) {
            return null;
        }
    }
}