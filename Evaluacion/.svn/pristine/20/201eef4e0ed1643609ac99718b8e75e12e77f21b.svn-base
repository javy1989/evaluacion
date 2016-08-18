/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.eval;

import entidades.eval.Testuser;
import generica.AbstractFacade;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Multimedia
 */
@Stateless
public class TestuserFacade extends AbstractFacade<Testuser> {

    @PersistenceContext(unitName = "Evaluacion-ejbPU2")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TestuserFacade() {
        super(Testuser.class);
    }

    public List<Testuser> listaTestFecha(Date date,int idUser,String codigo) {
        List<Testuser> lista;
        try {
            lista = em.createNamedQuery("Testuser.findByFeccreacion")
                    .setParameter("fecha", date)
                    .setParameter("idusuario",idUser)
                    .setParameter("codigo",codigo)
                    .getResultList();
            return lista;
        } catch (Exception e) {
            return null;
        }
    }

}
