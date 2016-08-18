/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.eval;

import entidades.eval.Matriz;
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
public class MatrizFacade extends AbstractFacade<Matriz> {

    @PersistenceContext(unitName = "Evaluacion-ejbPU2")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MatrizFacade() {
        super(Matriz.class);
    }

    public Matriz buscaMatriz(int idClase, BigDecimal total, int idtest) {
        Matriz matriz;
        try {
            matriz = (Matriz) em.createNamedQuery("Matriz.findByValoresClase")
                    .setParameter("idclase", idClase)
                    .setParameter("valor", total)
                    .setParameter("idtest", idtest)
                    .getSingleResult();
            return matriz;
        } catch (Exception e) {
            return null;
        }
    }

    public Matriz buscaMatrizTotal(BigDecimal total, int idtest) {
        try {
           Matriz  matriz = (Matriz) em.createNamedQuery("Matriz.findByValoresClaseTotal")
                    .setParameter("valor", total)
                    .setParameter("idtest", idtest)
                    .getSingleResult();
            return matriz;
        } catch (Exception e) {
            return null;
        }
    }

    public Matriz buscaMatrizSubClase(BigDecimal sumaClase, int idTest, int idSubclase) {
        Matriz matriz;
        try {
            matriz = (Matriz) em.createNamedQuery("Matriz.findByValoresSubclase")
                    .setParameter("valor", sumaClase)
                    .setParameter("idtest", idTest)
                    .setParameter("idsubclase", idSubclase)
                    .getSingleResult();
            return matriz;
        } catch (Exception e) {
            return null;
        }
    }
}
