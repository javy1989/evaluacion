/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.eval;

import entidades.eval.Secuencial;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Multimedia
 */
@Stateless
public class SecuencialFacade extends AbstractFacade<Secuencial> {

    @PersistenceContext(unitName = "Evaluacion-ejbPU2")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SecuencialFacade() {
        super(Secuencial.class);
    }

    public Secuencial buscaSecuencial(String codigo) {
        Secuencial secuencial;
        try {
            secuencial = (Secuencial) em.createNamedQuery("Secuencial.findByCodigo")
                    .setParameter("codigo", codigo)
                    .getSingleResult();
            return secuencial;
        } catch (Exception e) {
            return null;
        }
    }
}
