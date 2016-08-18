/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.eval;

import entidades.eval.Pregunta;
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
public class PreguntaFacade extends AbstractFacade<Pregunta> {

    @PersistenceContext(unitName = "Evaluacion-ejbPU2")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PreguntaFacade() {
        super(Pregunta.class);
    }

    public List<Pregunta> lista(int idTest, int idSubClase, int idClase) {
        try {
            List<Pregunta> lista = null;
            if (idTest == 0 && idClase == 0 && idSubClase == 0) {
                lista = em.createNamedQuery("Pregunta.findAll").getResultList();
            } else if (idTest != 0 && idClase == 0 && idSubClase == 0) {
                lista = em.createNamedQuery("Pregunta.findByIdTest")
                        .setParameter("idtest", idTest)
                        .getResultList();
            } else if (idTest != 0 && idClase != 0 && idSubClase == 0) {
                lista = em.createNamedQuery("Pregunta.findByIdTestIdClase")
                        .setParameter("idtest", idTest)
                        .setParameter("idclase", idClase)
                        .getResultList();
            } else if (idTest != 0 && idClase != 0 && idSubClase != 0) {
                lista = em.createNamedQuery("Pregunta.findByIdTestIdClaseIdSubclase")
                        .setParameter("idtest", idTest)
                        .setParameter("idclase", idClase)
                        .setParameter("idsubclase", idSubClase)
                        .getResultList();
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }

    public int idPregunta() {
        try {
            String sql = "select max(idpregunta) from  pregunta";
            Query query = em.createNativeQuery(sql);
            int valor = (int) query.getSingleResult() + 1;
            return valor;
        } catch (Exception e) {
            return 0;
        }
    }

    public List<Pregunta> listaPregRandom(int idSubClase) {
        try {
            List<Pregunta> listaRam = em.createNativeQuery("Select * from Pregunta where idsubclase="+" "+idSubClase+" order by random()","mappregunta")
                    .getResultList();
            return listaRam;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }
}
