/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.eval;

import entidades.eval.Percentil;
import entidades.eval.Subclase;
import entidades.eval.Test;
import generica.AbstractFacade;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Multimedia
 */
@Stateless
public class PercentilFacade extends AbstractFacade<Percentil> {

    @PersistenceContext(unitName = "Evaluacion-ejbPU2")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PercentilFacade() {
        super(Percentil.class);
    }

    public Percentil buscaPercentil(int idsubclase, int idtest, BigDecimal valor) {
        Percentil p;
        try {
            p = (Percentil) em.createNamedQuery("Percentil.findByValor")
                    .setParameter("idsubclase", idsubclase)
                    .setParameter("idtest", idtest)
                    .setParameter("valor", valor)
                    .getSingleResult();
            return p;
        } catch (Exception e) {
            return null;
        }

    }
}
